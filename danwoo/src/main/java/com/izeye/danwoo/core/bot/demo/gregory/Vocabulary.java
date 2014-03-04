package com.izeye.danwoo.core.bot.demo.gregory;

import java.util.ArrayList;
import java.util.List;

import com.izeye.danwoo.core.util.RandomUtils;

public class Vocabulary {

	private static final String DEFAULT_PHRASE = "I didn't understand.";

	private List<PhraseCollection> phraseCollections;

	public Vocabulary() {
		phraseCollections = new ArrayList<PhraseCollection>();
	}

	public List<PhraseCollection> getPhraseCollections() {
		return phraseCollections;
	}

	public void setPhraseCollections(List<PhraseCollection> phraseCollections) {
		this.phraseCollections = phraseCollections;
	}

	public String getPhrase(String input) {
		String output = searchPhrase(input);
		if (output == null) {
			return DEFAULT_PHRASE;
		}
		return output;
	}

	public String searchPhrase(String input) {
		input = input.toLowerCase();

		ArrayList<PhraseCollection> matchingKeys = new ArrayList<PhraseCollection>();
		for (PhraseCollection phrase : phraseCollections) {
			if (input.contains(phrase.getKey())) {
				matchingKeys.add(phrase);
			}
		}
		if (matchingKeys.size() > 0) {
			return RandomUtils.pickAny(matchingKeys).getPhrase();
		}
		return null;
	}

}
