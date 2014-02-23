package com.izeye.danwoo.core.bot.alice;

import com.izeye.danwoo.core.bot.Bot;
import com.izeye.danwoo.core.bot.danwoo.DanwooBot;
import com.izeye.danwoo.core.domain.Message;

// NOTE:
// This is just a female version of Danwoo. 
public class AliceBot implements Bot {

	private DanwooBot danwooBot = new DanwooBot();

	@Override
	public Message respond(Message request) {
		return danwooBot.respond(request);
	}

}
