package com.izeye.danwoo.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.danwoo.core.bot.DanwooBot;
import com.izeye.danwoo.core.bot.demo.EchoBot;
import com.izeye.danwoo.core.bot.demo.ReverseBot;
import com.izeye.danwoo.core.dao.MessageRepository;
import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

@Controller
public class BotController {

	@Autowired
	private EchoBot echoBot;

	@Autowired
	private ReverseBot reverseBot;

	@Autowired
	private DanwooBot danwooBot;

	@Autowired
	private MessageRepository messageRepository;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("botTypes", BotType.values());
		return "home";
	}

	@RequestMapping("/respond")
	@ResponseBody
	public Message respond(@RequestParam long timestamp,
			@RequestParam String from, @RequestParam BotType to,
			@RequestParam String value, @ModelAttribute String ipAddress) {
		Message request = new Message(new Date(timestamp), from, to.name(),
				value, ipAddress);
		messageRepository.save(request);

		// NOTE:
		// Give some delay to make the user feel like being in conversation.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Message response;
		switch (to) {
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
			throw new IllegalStateException("Unexpected bot type: " + to);
		}
		messageRepository.save(response);

		return response;
	}

	@ModelAttribute
	public String ipAddress(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
