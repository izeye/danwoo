package com.izeye.danwoo.core.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RandomUtilsTest {

	@Test
	public void pickAnyWithArray() {
		String[] array = new String[] { "A", "B", "C" };
		for (int i = 0; i < array.length; i++) {
			String picked = RandomUtils.pickAny(array);
			System.out.println(picked);
		}
	}

	@Test
	public void pickAnyWithList() {
		List<String> list = Arrays.asList(new String[] { "A", "B", "C" });
		for (int i = 0; i < list.size(); i++) {
			String picked = RandomUtils.pickAny(list);
			System.out.println(picked);
		}
	}

}
