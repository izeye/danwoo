package com.izeye.danwoo.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izeye.danwoo.core.bot.DanwooBot;
import com.izeye.danwoo.core.bot.demo.EchoBot;
import com.izeye.danwoo.core.bot.demo.ReverseBot;
import com.izeye.danwoo.core.dao.MessageRepository;
import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

@Service
public class DefaultBotService implements BotService {

	@Autowired
	private EchoBot echoBot;

	@Autowired
	private ReverseBot reverseBot;

	@Autowired
	private DanwooBot danwooBot;

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

		Message response;

		BotType botType = BotType.valueOf(request.getTo());
		switch (botType) {
		case ECHO:
			response = echoBot.respond(request);
			break;

		case REVERSE:
			response = reverseBot.respond(request);
			break;

		case DANWOO:
			response = danwooBot.respond(request);
			break;

		default:
			throw new IllegalStateException("Unexpected bot type: " + botType);
		}
		messageRepository.save(response);

		return response;
	}

}
