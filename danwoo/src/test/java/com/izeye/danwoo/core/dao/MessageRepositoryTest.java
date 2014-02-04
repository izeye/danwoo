package com.izeye.danwoo.core.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.izeye.danwoo.core.domain.BotType;
import com.izeye.danwoo.core.domain.Message;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class MessageRepositoryTest {

	@Autowired
	private MessageRepository messageRepository;

	@Test
	@Transactional
	public void test() {
		Date timestamp = new Date();
		String from = "Anonymous";
		String to = BotType.ECHO.name();
		String value = "abc";
		String ipAddress = "1.2.3.4";
		Message message = new Message(timestamp, from, to, value, ipAddress);

		messageRepository.save(message);

		Iterable<Message> messages = messageRepository.findAll();
		for (Message m : messages) {
			System.out.println(m);
		}
	}

	@Test
	public void findAllByOrderByTimestampDesc() {
		Iterable<Message> messages = messageRepository
				.findAllByOrderByTimestampDesc();
		for (Message message : messages) {
			System.out.println(message);
		}
	}

}
