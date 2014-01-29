package com.izeye.danwoo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReverseBotTest {

	@Test
	public void respond() {
		String request = "abc";
		String expected = "cba";

		ReverseBot reverseBot = new ReverseBot();
		assertThat(reverseBot.respond(request), is(expected));
	}

}
