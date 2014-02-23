package com.izeye.danwoo.support.lang.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.izeye.danwoo.support.lang.domain.Language;

public class LanguageServiceTest {

	@Test
	public void detect() {
		LanguageService languageService = new DefaultLanguageService();

		String text = "Hello.";
		assertThat(languageService.detect(text), is(Language.UNKNOWN));

		text = "안녕하세요.";
		assertThat(languageService.detect(text), is(Language.KOREAN));
	}

}
