package com.izeye.danwoo.core;

import org.apache.commons.lang3.StringUtils;

public class ReverseBot implements Bot {

	@Override
	public String respond(String request) {
		return StringUtils.reverse(request);
	}

}
