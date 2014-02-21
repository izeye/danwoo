package com.izeye.danwoo.core.bot.demo.eliza;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import com.izeye.danwoo.core.bot.Bot;
import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.domain.MessageFactory;

public class ElizaBot implements Bot {

	private ElizaEngine elizaEngine;

	public ElizaBot() {
		elizaEngine = new ElizaEngine();

		try {
			File scriptFile = ResourceUtils
					.getFile("classpath:com/izeye/danwoo/core/bot/demo/eliza/eliza_script.json");
			elizaEngine.load(scriptFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Message respond(Message request) {
		return MessageFactory.createResponse(request,
				elizaEngine.respond(request.getValue()));
	}

}
