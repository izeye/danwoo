package com.izeye.danwoo.core;

public class EchoBot implements Bot {

	@Override
	public String respond(String request) {
		return request;
	}

}
