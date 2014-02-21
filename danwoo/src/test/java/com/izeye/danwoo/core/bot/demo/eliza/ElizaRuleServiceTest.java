package com.izeye.danwoo.core.bot.demo.eliza;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

public class ElizaRuleServiceTest {

	private ElizaRuleService elizaRuleService;

	@Before
	public void setUp() throws FileNotFoundException {
		elizaRuleService = new ElizaRuleService();

		File scriptFile = ResourceUtils
				.getFile("classpath:com/izeye/danwoo/core/bot/demo/eliza/eliza_script.json");
		elizaRuleService.load(scriptFile);
	}

	@Test
	public void getKeywordRule() {
		String word = "sorry";
		KeywordRule keywordRule = elizaRuleService.getKeywordRule(word);
		System.out.println(keywordRule);
		assertThat(keywordRule, is(notNullValue()));
	}

	@Test
	public void preTransform() {
		String expected = "i don't know.";
		String sentence = "i dont know.";
		assertThat(elizaRuleService.preTransform(sentence), is(expected));
	}

	@Test
	public void postTransform() {
		String expected = "what should you do?";
		String sentence = "what should i do?";
		assertThat(elizaRuleService.postTransform(sentence), is(expected));
	}

	@Test
	public void synonymToRegex() {
		String expected = "(mother|mom|dad|father|sister|brother|wife|children)";
		String synonym = "family";
		assertThat(elizaRuleService.synonymToRegex(synonym), is(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void synonymToRegexWithNonExistentSynonym() {
		String synonym = "test";
		elizaRuleService.synonymToRegex(synonym);
	}

}
