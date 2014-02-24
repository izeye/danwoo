package com.izeye.danwoo.core.bot.danwoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

public class DanwooBotTest {

	private DanwooBot danwooBot;

	private List<String> inputs;

	@Before
	public void setUp() throws IOException {
		danwooBot = new DanwooBot();

		inputs = new ArrayList<String>();

		File file = ResourceUtils
				.getFile("classpath:com/izeye/danwoo/core/bot/danwoo/input.lst");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			inputs.add(line);
		}
		br.close();
	}

	@Test
	public void respond() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.DANWOO.name();
		String ipAddress = "1.2.3.4";

		for (String input : inputs) {
			Message request = new Message(timestamp, from, to, input, ipAddress);

			Message response = danwooBot.respond(request);
			System.out.println(request.getValue());
			System.out.println(response.getValue());
		}
	}

}
