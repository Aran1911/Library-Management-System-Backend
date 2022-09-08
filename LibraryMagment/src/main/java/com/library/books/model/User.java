package com.library.books.model;

import javax.persistence.*;

@Entity
@Table(name="library_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "user_userid_seq")
	private Integer id;
	
	@Column(name="username", nullable = false )
	private String username;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
