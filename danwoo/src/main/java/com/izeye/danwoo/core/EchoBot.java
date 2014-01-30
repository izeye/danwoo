package com.izeye.danwoo.core;

import org.springframework.stereotype.Service;

@Service
public class EchoBot implements Bot {

	@Override
	public String respond(String request) {
		return request;
	}

}
