package com.library.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.books.model.Book;
import com.library.books.repository.BookRepository;
import com.library.exception.ResourceNotFoundException;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		Iterable<Book> it = bookRepository.findAll();
		List<Book> books = new ArrayList<Book>();
		for (Book b : it) {
			books.add(b);
		}
		return books;
	}

	public Book getById(int id) {
		Book book = null;
		Optional<Book> opt = bookRepository.findById(id);
		if (opt.isPresent()) {
			book = opt.get();
		}
		return book;
	}

	public List<Book> findAllByAuthorName(String aName) {
		List<Book> books = bookRepository.findAllByAuthorName(aName);
		return books;
	}

	public Book addBook(Book b) {
		if (b == null) {
			throw new NullPointerException("Book object is null in class - BookService and method: addBook");
		}
		return bookRepository.save(b);
	}

	public Book updateBook(Book b) {
		if (b == null) {
			throw new NullPointerException("Book object is null in class - BookService and method: updateBook");
		}
		Book book = null;
		Optional<Book> opt = bookRepository.findById(b.getBookId());
		if (opt.isPresent()) {
			book = opt.get();
		}
		return bookRepository.save(b);
	}

	public void deleteBook(int id) {
		Optional<Book> opt = bookRepository.findById(id);
		if(!opt.isPresent()) {
			throw new ResourceNotFoundException("Book","BookId",id);
		}
		bookRepository.deleteById(id);
	}

}
