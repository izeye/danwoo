package com.izeye.danwoo.core.bot.danwoo;

import com.izeye.danwoo.core.bot.Bot;
import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.domain.MessageFactory;

public class DanwooBot implements Bot {

	private DanwooEngine danwooEngine = new DanwooEngine();

	@Override
	public Message respond(Message request) {
		return MessageFactory.createResponse(request,
				danwooEngine.respond(request.getValue()));
	}

}
