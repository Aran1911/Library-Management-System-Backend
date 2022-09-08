package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.library.books.model.User;
import com.library.books.repository.UserRepository;

@SpringBootApplication
public class LibraryMagmentApplication implements CommandLineRunner {
	
	@Autowired
	public UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryMagmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(0,"Admin","admin@hcl.com","Admin123");
		userRepository.save(user);
	}

}
