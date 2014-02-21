package com.izeye.danwoo.core.bot;

import com.izeye.danwoo.core.bot.demo.eliza.ElizaBot;
import com.izeye.danwoo.core.domain.Message;

public class DanwooBot implements Bot {

	private ElizaBot elizaBot = new ElizaBot();

	@Override
	public Message respond(Message request) {
		return elizaBot.respond(request);
	}

}
