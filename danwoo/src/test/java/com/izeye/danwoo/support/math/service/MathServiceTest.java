package com.izeye.danwoo.support.math.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathServiceTest {

	@Test
	public void isExpression() {
		MathService mathService = new DefaultMathService();

		String input = "Hello.";
		assertThat(mathService.isExpression(input), is(false));

		input = "1+1";
		assertThat(mathService.isExpression(input), is(true));
	}

	@Test
	public void calculate() {
		MathService mathService = new DefaultMathService();

		String input = "1+1";
		assertThat(mathService.calculate(input), is("2"));
	}

}
