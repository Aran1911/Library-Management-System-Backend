package com.library.books.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.books.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	abstract public User findByUsernameAndPassword(String username, String password);
}
