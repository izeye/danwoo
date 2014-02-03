package com.izeye.danwoo.core.bot.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.danwoo.core.bot.demo.ReverseBot;
import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class ReverseBotTest {

	@Autowired
	private ReverseBot reverseBot;

	@Test
	public void respond() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.REVERSE.name();
		String value = "abc";
		String ipAddress = "1.2.3.4";
		Message request = new Message(timestamp, from, to, value, ipAddress);

		String expected = "cba";

		// ReverseBot reverseBot = new ReverseBot();
		assertThat(reverseBot.respond(request).getValue(), is(expected));
	}

}
