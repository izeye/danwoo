package com.izeye.danwoo.support.lang.service;

import com.izeye.danwoo.support.lang.domain.Language;

public interface LanguageService {

	Language detect(String text);

}
