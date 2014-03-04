package com.izeye.danwoo.core.bot.demo.gregory;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

import com.izeye.danwoo.core.bot.Bot;
import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.domain.MessageFactory;

public class GregoryBot implements Bot {

	private Brain brain;

	public GregoryBot() {
		brain = new Brain();

		try {
			File scriptFile = ResourceUtils
					.getFile("classpath:com/izeye/danwoo/core/bot/demo/gregory/gregory_script.json");
			brain.load(scriptFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Message respond(Message request) {
		return MessageFactory.createResponse(request,
				brain.respond(request.getValue()));
	}

}
