package com.izeye.danwoo.core.bot.demo;

import org.springframework.stereotype.Service;

import com.izeye.danwoo.core.bot.Bot;
import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.domain.MessageFactory;

@Service
public class EchoBot implements Bot {

	@Override
	public Message respond(Message request) {
		return MessageFactory.createResponse(request, request.getValue());
	}

}
