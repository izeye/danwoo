package com.izeye.danwoo.core.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izeye.danwoo.core.bot.alice.AliceBot;
import com.izeye.danwoo.core.bot.danwoo.DanwooBot;
import com.izeye.danwoo.core.bot.demo.echo.EchoBot;
import com.izeye.danwoo.core.bot.demo.eliza.ElizaBot;
import com.izeye.danwoo.core.bot.demo.reverse.ReverseBot;
import com.izeye.danwoo.core.dao.MessageRepository;
import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

@Service
public class DefaultBotService implements BotService {

	@Autowired
	private EchoBot echoBot;

	@Autowired
	private ReverseBot reverseBot;

	private Map<String, ElizaBot> elizaBots = new HashMap<String, ElizaBot>();
	private Map<String, DanwooBot> danwooBots = new HashMap<String, DanwooBot>();
	private Map<String, AliceBot> aliceBots = new HashMap<String, AliceBot>();

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Message respond(Message request) {
		messageRepository.save(request);

		// NOTE:
		// Give some delay to make the user feel like being in conversation.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String from = request.getFrom();

		Message response;

		BotType botType = BotType.valueOf(request.getTo());
		switch (botType) {
		case ALICE:
			AliceBot aliceBot = aliceBots.get(from);
			if (aliceBot == null) {
				aliceBot = new AliceBot();
			}
			response = aliceBot.respond(request);
			break;

		case DANWOO:
			DanwooBot danwooBot = danwooBots.get(from);
			if (danwooBot == null) {
				danwooBot = new DanwooBot();
			}
			response = danwooBot.respond(request);
			break;

		case ELIZA:
			ElizaBot elizaBot = elizaBots.get(from);
			if (elizaBot == null) {
				elizaBot = new ElizaBot();
			}
			response = elizaBot.respond(request);
			break;

		case ECHO:
			response = echoBot.respond(request);
			break;

		case REVERSE:
			response = reverseBot.respond(request);
			break;

		default:
			throw new IllegalStateException("Unexpected bot type: " + botType);
		}
		messageRepository.save(response);

		return response;
	}

}
