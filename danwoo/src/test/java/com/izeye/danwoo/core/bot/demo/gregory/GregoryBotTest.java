package com.izeye.danwoo.core.bot.demo.gregory;

import java.util.Date;

import org.junit.Test;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

public class GregoryBotTest {

	private GregoryBot gregoryBot = new GregoryBot();

	@Test
	public void respond() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.GREGORY.name();
		String ipAddress = "1.2.3.4";

		String value = "Hello.";
		Message request = new Message(timestamp, from, to, value, ipAddress);

		Message response = gregoryBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "Goodbye.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = gregoryBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "How are you?";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = gregoryBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "I'm good.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = gregoryBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "My name is Johnny.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = gregoryBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "Hi.";
		request = new Message(timestamp, from, to, value, ipAddress);

		response = gregoryBot.respond(request);
		System.out.println(request);
		System.out.println(response);
	}

}
