package com.izeye.danwoo.core.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class BotServiceTest {

	@Autowired
	private BotService botService;

	@Test
	public void respond() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.ECHO.name();
		String value = "abc";
		String ipAddress = "1.2.3.4";
		Message request = new Message(timestamp, from, to, value, ipAddress);

		assertThat(botService.respond(request).getValue(), is(value));

		to = BotType.REVERSE.name();
		request = new Message(timestamp, from, to, value, ipAddress);
		String expected = "cba";

		assertThat(botService.respond(request).getValue(), is(expected));
	}

}
