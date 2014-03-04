package com.izeye.danwoo.core.util;

import java.util.List;
import java.util.Random;

public class RandomUtils {

	private static ThreadLocal<Random> random = new ThreadLocal<Random>() {
		protected Random initialValue() {
			return new Random();
		}
	};

	public static <T> T pickAny(T[] array) {
		return array[random.get().nextInt(array.length)];
	}

	public static <T> T pickAny(List<T> list) {
		return list.get(random.get().nextInt(list.size()));
	}

}
