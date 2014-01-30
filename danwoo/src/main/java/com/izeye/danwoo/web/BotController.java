package com.izeye.danwoo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.izeye.danwoo.core.EchoBot;
import com.izeye.danwoo.core.ReverseBot;

@Controller
public class BotController {

	@Autowired
	private EchoBot echoBot;

	@Autowired
	private ReverseBot reverseBot;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

}
