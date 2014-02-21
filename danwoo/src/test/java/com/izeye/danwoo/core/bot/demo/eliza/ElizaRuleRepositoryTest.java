package com.izeye.danwoo.core.bot.demo.eliza;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ElizaRuleRepositoryTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException {
		File scriptFile = ResourceUtils
				.getFile("classpath:com/izeye/danwoo/core/bot/demo/eliza/eliza_script.json");
		ObjectMapper mapper = new ObjectMapper();
		ElizaRuleRepository repository = mapper.readValue(scriptFile,
				ElizaRuleRepository.class);
		System.out.println(repository);
	}

}
