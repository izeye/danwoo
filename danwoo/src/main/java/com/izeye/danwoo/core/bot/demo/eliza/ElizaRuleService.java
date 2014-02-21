package com.izeye.danwoo.core.bot.demo.eliza;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ElizaRuleService {

	private static final String NONE = "_none";

	private ElizaRuleRepository ruleRepository;

	private Map<String, KeywordRule> keywordDictionary = new HashMap<String, KeywordRule>();

	private DecompositionRule noneDecompositionRule;

	public void load(File scriptFile) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ruleRepository = mapper.readValue(scriptFile,
					ElizaRuleRepository.class);

			List<KeywordRule> keywordRules = ruleRepository.getKeywordRules();
			for (KeywordRule keywordRule : keywordRules) {
				keywordDictionary.put(keywordRule.getKeyword(), keywordRule);
			}

			KeywordRule noneKeywordRule = keywordDictionary.get(NONE);
			noneDecompositionRule = noneKeywordRule.getDecompositionRules()
					.get(0);
		} catch (JsonParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public KeywordRule getKeywordRule(String word) {
		return keywordDictionary.get(word);
	}

	public String preTransform(String sentence) {
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String preTransformed = ruleRepository.preTransform(word);
			if (preTransformed != null) {
				words[i] = preTransformed;
			}
		}
		return StringUtils.join(words, " ");
	}

	public String postTransform(String sentence) {
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String postTransformed = ruleRepository.postTransform(word);
			if (postTransformed != null) {
				words[i] = postTransformed;
			}
		}
		return StringUtils.join(words, " ");
	}

	public String synonymToRegex(String synonym) {
		List<String> synonyms = ruleRepository.getSynonyms().get(synonym);
		if (synonyms == null) {
			throw new IllegalArgumentException("Unregistered synonym: "
					+ synonym);
		}

		StringBuilder sb = new StringBuilder();
		sb.append('(');
		for (String s : synonyms) {
			sb.append(s);
			sb.append('|');
		}
		sb.setCharAt(sb.length() - 1, ')');
		return sb.toString();
	}

	public String nextNoneResponse() {
		return noneDecompositionRule.nextReassemblyRule();
	}

}
