package com.izeye.danwoo.core.util;

import java.util.List;

public class PrettyPrinter {

	public static String prettify(List<? extends Object> list) {
		StringBuilder sb = new StringBuilder();
		for (Object object : list) {
			sb.append(object);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}
