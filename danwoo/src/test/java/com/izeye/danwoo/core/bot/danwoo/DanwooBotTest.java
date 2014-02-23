package com.izeye.danwoo.core.bot.danwoo;

import java.util.Date;

import org.junit.Test;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

public class DanwooBotTest {

	private DanwooBot danwooBot = new DanwooBot();

	@Test
	public void respond() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.DANWOO.name();
		String value = "hello";
		String ipAddress = "1.2.3.4";
		Message request = new Message(timestamp, from, to, value, ipAddress);

		Message response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());

		value = "I have a headache.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());

		value = "Let's have a party.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());

		value = "Shut up.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());

		value = "Sucker.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());

		value = "Cool.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());

		value = "Fool?";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = danwooBot.respond(request);
		System.out.println(request.getValue());
		System.out.println(response.getValue());
	}

}
