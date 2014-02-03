package com.izeye.danwoo.core.bot;

import org.springframework.stereotype.Service;

import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.domain.MessageFactory;

@Service
public class DanwooBot implements Bot {

	@Override
	public Message respond(Message request) {
		return MessageFactory.createResponse(request, "I'm not available yet.");
	}

}
