package com.izeye.danwoo.support;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.izeye.danwoo.support.emoticon.service.DefaultEmoticonService;
import com.izeye.danwoo.support.emoticon.service.EmoticonService;

public class EmoticonServiceTest {

	@Test
	public void removeEmoticons() {
		String expected = "He is your father";
		String input = "He is your father lol";

		EmoticonService emoticonService = new DefaultEmoticonService();
		String actual = emoticonService.removeEmoticons(input);

		assertThat(actual, is(expected));
	}

}
