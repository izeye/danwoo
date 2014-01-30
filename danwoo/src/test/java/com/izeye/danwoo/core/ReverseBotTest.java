package com.izeye.danwoo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class ReverseBotTest {

	@Autowired
	private ReverseBot reverseBot;

	@Test
	public void respond() {
		String request = "abc";
		String expected = "cba";

		// ReverseBot reverseBot = new ReverseBot();
		assertThat(reverseBot.respond(request), is(expected));
	}

}
