package com.izeye.danwoo.core.bot.demo.eliza;

import java.util.Date;

import org.junit.Test;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

public class ElizaBotTest {

	private ElizaBot elizaBot = new ElizaBot();

	@Test
	public void respond() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.DANWOO.name();
		String value = "Hello.";
		String ipAddress = "1.2.3.4";
		Message request = new Message(timestamp, from, to, value, ipAddress);

		Message response = elizaBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "My problem is you.";
		request = new Message(timestamp, from, to, value, ipAddress);
		response = elizaBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "Yes.";
		request = new Message(timestamp, from, to, value, ipAddress);
		response = elizaBot.respond(request);
		System.out.println(request);
		System.out.println(response);

		value = "Not really.";
		request = new Message(timestamp, from, to, value, ipAddress);
		response = elizaBot.respond(request);
		System.out.println(request);
		System.out.println(response);
	}

}
