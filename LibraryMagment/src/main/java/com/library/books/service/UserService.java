package com.library.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.books.model.User;
import com.library.books.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User login(User user){
		User user1 = null;
		user1 = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		if (user1 != null ) {
			return user1;
		} else {
			return null ;
		}
	}
}
