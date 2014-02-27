package com.izeye.danwoo.core.util;

import org.junit.Test;

public class RandomUtilsTest {

	@Test
	public void pickAny() {
		String[] array = new String[] { "A", "B", "C" };
		for (int i = 0; i < array.length; i++) {
			String picked = RandomUtils.pickAny(array);
			System.out.println(picked);
		}
	}

}
