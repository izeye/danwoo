package com.izeye.danwoo.support.math.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultMathService implements MathService {

	// NOTE:
	// Only addition supported.
	private static final String REGEX_EXPRESSION = "(\\d+)(\\+)(\\d+)";
	private static final Pattern PATTERN_EXPRESSION = Pattern
			.compile(REGEX_EXPRESSION);

	@Override
	public boolean isExpression(String input) {
		return input.matches(REGEX_EXPRESSION);
	}

	@Override
	public String calculate(String expression) {
		Matcher matcher = PATTERN_EXPRESSION.matcher(expression);
		matcher.find();
		int operand1 = Integer.parseInt(matcher.group(1));
		int operand2 = Integer.parseInt(matcher.group(3));
		return String.valueOf(operand1 + operand2);
	}

}
