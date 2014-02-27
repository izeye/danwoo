package com.izeye.danwoo.core.bot.danwoo;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.ResourceUtils;

import com.izeye.danwoo.core.bot.demo.eliza.ElizaEngine;
import com.izeye.danwoo.core.util.RandomUtils;
import com.izeye.danwoo.support.emoticon.service.DefaultEmoticonService;
import com.izeye.danwoo.support.emoticon.service.EmoticonService;
import com.izeye.danwoo.support.lang.domain.Language;
import com.izeye.danwoo.support.lang.service.DefaultLanguageService;
import com.izeye.danwoo.support.lang.service.LanguageService;
import com.izeye.danwoo.support.math.service.DefaultMathService;
import com.izeye.danwoo.support.math.service.MathService;

public class DanwooEngine {

	private ElizaEngine elizaEngine;

	private LanguageService languageService = new DefaultLanguageService();
	private MathService mathService = new DefaultMathService();
	private EmoticonService emoticonService = new DefaultEmoticonService();

	public DanwooEngine() {
		elizaEngine = new ElizaEngine();

		try {
			File scriptFile = ResourceUtils
					.getFile("classpath:com/izeye/danwoo/core/bot/danwoo/eliza_script.danwoo.json");
			elizaEngine.load(scriptFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static final String[] DEFAULT_RESPONSES_FOR_KOREAN = {
			"I haven't learned Korean yet. Please speak in English.",
			"I don't understand Korean. Please speak in English." };

	private static final String[] DEFAULT_RESPONSES_FOR_NUMBER = { "What is the number for?" };

	public String respond(String input) {
		// Handle language specific.
		Language language = languageService.detect(input);
		switch (language) {
		case KOREAN:
			return RandomUtils.pickAny(DEFAULT_RESPONSES_FOR_KOREAN);

		default:
			break;
		}

		// Handle number specific.
		if (NumberUtils.isDigits(input)) {
			return RandomUtils.pickAny(DEFAULT_RESPONSES_FOR_NUMBER);
		}

		// Handle math specific.
		if (mathService.isExpression(input)) {
			return mathService.calculate(input);
		}

		// Remove emoticon.
		// Later, it needs to be handled properly.
		input = emoticonService.removeEmoticons(input);

		return elizaEngine.respond(input);
	}

}
