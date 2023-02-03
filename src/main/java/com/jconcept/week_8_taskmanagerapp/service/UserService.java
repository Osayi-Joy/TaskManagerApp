package com.jconcept.week_8_taskmanagerapp.service;

import com.jconcept.week_8_taskmanagerapp.entity.User;
import com.jconcept.week_8_taskmanagerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void save(User user) {
		userRepository.save(user);
	}
}
