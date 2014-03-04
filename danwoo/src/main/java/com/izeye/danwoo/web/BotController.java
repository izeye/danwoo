package com.izeye.danwoo.web;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;
import com.izeye.danwoo.core.service.BotService;
import com.izeye.danwoo.core.service.MessageService;

@Controller
public class BotController {

	@Autowired
	private BotService botService;

	@Autowired
	private MessageService messageService;

	@RequestMapping("/")
	public String home(Model model) {
		List<BotType> botTypes = Arrays.asList(new BotType[] { BotType.ALICE,
				BotType.DANWOO, BotType.ELIZA });
		model.addAttribute("botTypes", botTypes);
		return "home";
	}

	@RequestMapping("/respond")
	@ResponseBody
	public Message respond(@RequestParam long timestamp,
			@RequestParam String from, @RequestParam BotType to,
			@RequestParam String value, @ModelAttribute String ipAddress) {
		// NOTE:
		// Can't rely on the client-side system clock.
		timestamp = System.currentTimeMillis();

		Message request = new Message(new Date(timestamp), from, to.name(),
				value, ipAddress);
		return botService.respond(request);
	}

	@RequestMapping("/messages")
	public String messages() {
		return "messages";
	}

	@RequestMapping("/messages.json")
	@ResponseBody
	public Iterable<Message> messagesJson() {
		return messageService.getMessages();
	}

	@ModelAttribute
	public String ipAddress(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
