package com.izeye.danwoo.support.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.izeye.danwoo.support.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
