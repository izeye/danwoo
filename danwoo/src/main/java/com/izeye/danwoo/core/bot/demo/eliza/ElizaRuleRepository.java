package com.izeye.danwoo.core.bot.demo.eliza;

import java.util.List;
import java.util.Map;

import com.izeye.danwoo.core.util.PrettyPrinter;

public class ElizaRuleRepository {

	private List<KeywordRule> keywordRules;
	private Map<String, String> preTransformationRules;
	private Map<String, String> postTransformationRules;
	private Map<String, List<String>> synonyms;

	public List<KeywordRule> getKeywordRules() {
		return keywordRules;
	}

	public void setKeywordRules(List<KeywordRule> keywordRules) {
		this.keywordRules = keywordRules;
	}

	public Map<String, String> getPreTransformationRules() {
		return preTransformationRules;
	}

	public void setPreTransformationRules(
			Map<String, String> preTransformationRules) {
		this.preTransformationRules = preTransformationRules;
	}

	public Map<String, String> getPostTransformationRules() {
		return postTransformationRules;
	}

	public void setPostTransformationRules(
			Map<String, String> postTransformationRules) {
		this.postTransformationRules = postTransformationRules;
	}

	public String preTransform(String word) {
		return preTransformationRules.get(word);
	}

	public String postTransform(String word) {
		return postTransformationRules.get(word);
	}

	public Map<String, List<String>> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Map<String, List<String>> synonyms) {
		this.synonyms = synonyms;
	}

	@Override
	public String toString() {
		return "ElizaRuleRepository [keywordRules="
				+ PrettyPrinter.prettify(keywordRules)
				+ ", preTransformationRules=" + preTransformationRules
				+ ", postTransformationRules=" + postTransformationRules
				+ ", synonyms=" + synonyms + "]";
	}

}
