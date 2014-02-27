package com.izeye.danwoo.support.emoticon.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class DefaultEmoticonService implements EmoticonService {

	private static final String WORD_SEPARATOR = " ";

	private static final String LOL = "lol";

	private static final Set<String> emoticons = new HashSet<String>();
	static {
		emoticons.add(LOL);
	}

	@Override
	public String removeEmoticons(String input) {
		List<String> finalWords = new ArrayList<String>();
		String[] words = input.split(WORD_SEPARATOR);
		for (String word : words) {
			if (emoticons.contains(word)) {
				continue;
			}
			finalWords.add(word);
		}
		return StringUtils.join(finalWords, WORD_SEPARATOR);
	}

}
