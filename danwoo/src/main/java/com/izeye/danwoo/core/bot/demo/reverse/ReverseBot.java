package com.izeye.danwoo.core.bot.demo.reverse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.izeye.danwoo.core.bot.Bot;
import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.domain.MessageFactory;

@Service
public class ReverseBot implements Bot {

	@Override
	public Message respond(Message request) {
		return MessageFactory.createResponse(request,
				StringUtils.reverse(request.getValue()));
	}

}
