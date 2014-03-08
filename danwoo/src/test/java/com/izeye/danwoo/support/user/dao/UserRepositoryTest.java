package com.izeye.danwoo.support.user.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.danwoo.support.user.domain.User;
import com.izeye.danwoo.support.user.domain.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void test() {
		userRepository.deleteAll();
		entityManager.flush();

		User user1 = new User("admin", "1234", UserRole.SUPERVISOR);
		User user2 = new User("izeye", "1234");

		userRepository.save(user1);
		userRepository.save(user2);

		Iterable<User> users = userRepository.findAll();
		System.out.println(users);
	}

}
