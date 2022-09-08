package com.library.books.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.User;
import com.library.books.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping("/get/{username}/{password}")
	public ResponseEntity<User> login(@PathVariable("username") String username ,@PathVariable("password")String password, User u){
		u.setUsername(username); 
		u.setPassword(password);
		User user = userService.login(u);
		if (userService.login(u) != null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		
	}
}
