package com.izeye.danwoo.core.bot.danwoo;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import com.izeye.danwoo.core.bot.demo.eliza.ElizaEngine;
import com.izeye.danwoo.support.lang.domain.Language;
import com.izeye.danwoo.support.lang.service.DefaultLanguageService;
import com.izeye.danwoo.support.lang.service.LanguageService;
import com.izeye.danwoo.support.math.service.DefaultMathService;
import com.izeye.danwoo.support.math.service.MathService;

public class DanwooEngine {

	private ElizaEngine elizaEngine;

	private LanguageService languageService = new DefaultLanguageService();
	private MathService mathService = new DefaultMathService();

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

	private static final String DEFAULT_RESPONSE_FOR_KOREAN = "I don't know Korean. Please speak in English.";

	public String respond(String input) {
		// Handle language specific.
		Language language = languageService.detect(input);
		switch (language) {
		case KOREAN:
			return DEFAULT_RESPONSE_FOR_KOREAN;

		default:
			break;
		}

		// Handle math specific.
		if (mathService.isExpression(input)) {
			return mathService.calculate(input);
		}

		return elizaEngine.respond(input);
	}

}
