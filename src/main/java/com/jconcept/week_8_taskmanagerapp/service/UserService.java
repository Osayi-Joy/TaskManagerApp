package com.example.ToDoList.service;

import com.example.ToDoList.entity.User;
import com.example.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
