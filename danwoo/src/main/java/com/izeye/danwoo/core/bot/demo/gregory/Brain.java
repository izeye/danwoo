package com.izeye.danwoo.core.bot.demo.gregory;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Brain {

	private static final String DEFAULT_USERNAME = "human";

	private Vocabulary vocabulary;

	private String username = DEFAULT_USERNAME;

	public void load(File scriptFile) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			vocabulary = mapper.readValue(scriptFile, Vocabulary.class);
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

	public Vocabulary getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

	private static final String KEY_NAME = "my name is";
	private static final String PLACEHOLDER_NAME = "*name*";

	public String respond(String input) {
		String phrase = vocabulary.getPhrase(input);

		phrase = handleUsername(input, phrase);

		return phrase;
	}

	private String handleUsername(String input, String phrase) {
		// Recognize the username.
		String lowerCaseInput = input.toLowerCase();
		if (lowerCaseInput.contains(KEY_NAME)) {
			int index = lowerCaseInput.indexOf(KEY_NAME);
			// FIXME:
			// Assume that the last character is period.
			username = input.substring(index, input.length() - 1).split(" ")[3];
		}

		// Apply the username.
		if (phrase.contains(PLACEHOLDER_NAME)) {
			phrase = phrase.replace(PLACEHOLDER_NAME, username);
		}
		return phrase;
	}

}
