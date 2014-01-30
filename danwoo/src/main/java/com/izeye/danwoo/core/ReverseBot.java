package com.izeye.danwoo.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ReverseBot implements Bot {

	@Override
	public String respond(String request) {
		return StringUtils.reverse(request);
	}

}
