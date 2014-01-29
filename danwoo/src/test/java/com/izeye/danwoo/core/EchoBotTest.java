package com.izeye.danwoo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EchoBotTest {

	@Test
	public void respond() {
		String request = "abc";

		EchoBot echoBot = new EchoBot();
		assertThat(echoBot.respond(request), is(request));
	}

}
