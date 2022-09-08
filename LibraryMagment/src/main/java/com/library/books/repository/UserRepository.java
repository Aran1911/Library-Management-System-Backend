package com.library.books.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.books.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	abstract public User findByUsernameAndPassword(String username, String password);
}
