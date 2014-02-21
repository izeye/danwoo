package com.izeye.danwoo.core.bot.demo.eliza;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElizaEngine {

	private ElizaRuleService ruleService;

	private List<String> memory = new ArrayList<String>();

	public void load(File scriptFile) {
		ruleService = new ElizaRuleService();
		ruleService.load(scriptFile);
	}

	public String respond(String input) {
		input = input.toLowerCase();

		// Split input into sentences or phrases.
		String[] sentences = input.split("[\\,\\.\\?\\!]");
		for (String sentence : sentences) {
			sentence = ruleService.preTransform(sentence);

			List<KeywordRule> keywordRules = new ArrayList<KeywordRule>();
			String[] words = sentence.split(" ");
			for (String word : words) {
				KeywordRule keywordRule = ruleService.getKeywordRule(word);
				if (keywordRule != null) {
					keywordRules.add(keywordRule);
				}
			}
			if (keywordRules.isEmpty()) {
				continue;
			}

			Collections.sort(keywordRules);

			for (KeywordRule keywordRule : keywordRules) {
				String result = tryKeywordRule(sentence, keywordRule);
				if (result != null) {
					return result;
				}
			}
		}

		if (!memory.isEmpty()) {
			return memory.remove(0);
		}

		return ruleService.nextNoneResponse();
	}

	private String tryKeywordRule(String sentence, KeywordRule keywordRule) {
		List<DecompositionRule> decompositionRules = keywordRule
				.getDecompositionRules();
		for (DecompositionRule decompositionRule : decompositionRules) {
			String decompositionPattern = decompositionRule
					.getDecompositionPattern();
			List<String> decomposed = decompose(sentence, decompositionPattern);
			if (decomposed.isEmpty()) {
				continue;
			}

			String reassemblyRule = decompositionRule.nextReassemblyRule();
			if (reassemblyRule.startsWith("=")) {
				String keyword = reassemblyRule.substring(1);
				return tryKeywordRule(sentence,
						ruleService.getKeywordRule(keyword));
			}
			String reassembled = reassemble(reassemblyRule, decomposed);
			if (decompositionRule.isForMemory()) {
				memory.add(reassembled);
				continue;
			}
			return reassembled;
		}
		return null;
	}

	private List<String> decompose(String sentence, String decompositionPattern) {
		List<String> decomposed = new ArrayList<String>();

		String decompositionRegex = patternToRegex(decompositionPattern);
		Pattern pattern = Pattern.compile(decompositionRegex,
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(sentence);
		if (matcher.find()) {
			for (int i = 1; i <= matcher.groupCount(); i++) {
				decomposed.add(matcher.group(i));
			}
		}
		return decomposed;
	}

	private String patternToRegex(String decompositionPattern) {
		String decompositionRegex = decompositionPattern.replaceAll(
				"\\s*\\*\\s*", "\\\\s*(.*)\\\\s*");
		return handlePlaceholders(decompositionRegex);
	}

	private String handlePlaceholders(String decompositionRegex) {
		String placeholderRegex = "\\$\\{(\\w*)\\}";
		Pattern placeholderPattern = Pattern.compile(placeholderRegex);
		Matcher placeholderMatcher = placeholderPattern
				.matcher(decompositionRegex);
		while (placeholderMatcher.find()) {
			String placeholderName = placeholderMatcher.group(1);
			String placeholder = placeholderMatcher.group();
			decompositionRegex = decompositionRegex.replace(placeholder,
					ruleService.synonymToRegex(placeholderName));
		}
		return decompositionRegex;
	}

	private String reassemble(final String reassemblyRule,
			List<String> decomposed) {
		String reassembled = reassemblyRule;

		String regex = "\\$\\{(\\d)\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(reassemblyRule);
		while (matcher.find()) {
			int index = Integer.parseInt(matcher.group(1)) - 1;
			reassembled = reassemblyRule.replace(matcher.group(),
					ruleService.postTransform(decomposed.get(index)));
		}
		return reassembled;
	}

}
