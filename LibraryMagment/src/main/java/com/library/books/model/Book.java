package com.library.books.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "book_bookid_seq")
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "cost", nullable = false)
	private double cost;
	
	public Book() {
		super();
	}
	public Book(String title, String authorName, int cost) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.cost = cost;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
