package com.izeye.danwoo.support.lang.service;

import com.izeye.danwoo.support.lang.domain.Language;

public class DefaultLanguageService implements LanguageService {

	@Override
	public Language detect(String text) {
		for (char c : text.toCharArray()) {
			if (isKorean(c)) {
				return Language.KOREAN;
			}
		}
		return Language.UNKNOWN;
	}

	// http://en.wikipedia.org/wiki/Korean_language_and_computers
	private static final char KOREAN_SYLLABLE_START = 0xAC00;
	private static final char KOREAN_SYLLABEL_END = 0xD7A3;
	private static final char KOREAN_JAMO_START = 0x1100;
	private static final char KOREAN_JAMO_END = 0x11FF;
	private static final char KOREAN_COMPATIBILITY_JAMO_START = 0x3130;
	private static final char KOREAN_COMPATIBILITY_JAMO_END = 0x318F;
	private static final char KOREAN_JAMO_EXTENDED_A_START = 0xA960;
	private static final char KOREAN_JAMO_EXTENDED_A_END = 0xA97F;
	private static final char KOREAN_JAMO_EXTENDED_B_START = 0xD7B0;
	private static final char KOREAN_JAMO_EXTENDED_B_END = 0xD7FF;

	private boolean isKoreanSyllable(char c) {
		return c >= KOREAN_SYLLABLE_START && c <= KOREAN_SYLLABEL_END;
	}

	private boolean isKoreanJamo(char c) {
		return c >= KOREAN_JAMO_START && c <= KOREAN_JAMO_END;
	}

	private boolean isKoreanCompatibilityJamo(char c) {
		return c >= KOREAN_COMPATIBILITY_JAMO_START
				&& c <= KOREAN_COMPATIBILITY_JAMO_END;
	}

	private boolean isKoreanJamoExtendedA(char c) {
		return c >= KOREAN_JAMO_EXTENDED_A_START
				&& c <= KOREAN_JAMO_EXTENDED_A_END;
	}

	private boolean isKoreanJamoExtendedB(char c) {
		return c >= KOREAN_JAMO_EXTENDED_B_START
				&& c <= KOREAN_JAMO_EXTENDED_B_END;
	}

	public boolean isKorean(char c) {
		return isKoreanSyllable(c) || isKoreanJamo(c)
				|| isKoreanCompatibilityJamo(c) || isKoreanJamoExtendedA(c)
				|| isKoreanJamoExtendedB(c);
	}

}
