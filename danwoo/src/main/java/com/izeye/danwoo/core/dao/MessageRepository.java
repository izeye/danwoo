package com.izeye.danwoo.core.dao;

import org.springframework.data.repository.CrudRepository;

import com.izeye.danwoo.core.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
