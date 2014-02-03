package com.izeye.danwoo.core.domain;

public class MessageFactory {

	public static Message createResponse(Message request, String value) {
		return new Message(request.getTo(), request.getFrom(), value);
	}

}
