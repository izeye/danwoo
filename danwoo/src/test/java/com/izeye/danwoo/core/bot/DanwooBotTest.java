package com.izeye.danwoo.core.bot;

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
		String value = "abc";
		String ipAddress = "1.2.3.4";
		Message request = new Message(timestamp, from, to, value, ipAddress);

		Message response = danwooBot.respond(request);
		System.out.println(response);
	}

}
