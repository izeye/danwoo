package com.izeye.danwoo.core.bot.demo.gregory;

import java.util.List;

import com.izeye.danwoo.core.util.RandomUtils;

public class PhraseCollection {

	private String key;
	private List<String> phrases;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<String> phrases) {
		this.phrases = phrases;
	}

	public String getPhrase() {
		return RandomUtils.pickAny(phrases);
	}

	@Override
	public String toString() {
		return "PhraseCollection [key=" + key + ", phrases=" + phrases + "]";
	}

}
