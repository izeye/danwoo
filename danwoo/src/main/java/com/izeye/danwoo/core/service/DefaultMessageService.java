package com.izeye.danwoo.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izeye.danwoo.core.dao.MessageRepository;
import com.izeye.danwoo.core.domain.Message;

@Service
public class DefaultMessageService implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Iterable<Message> getMessages() {
		return messageRepository.findAllByOrderByIdDesc();
	}

}
