package com.library.books.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.Book;
import com.library.books.service.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin("http://localhost:4200")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/all-books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book>books = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById (@PathVariable("id") int id){
		Book book =  bookService.getById(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

	@PostMapping("/add-book")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
		Book b = bookService.addBook(book);
		return new ResponseEntity<Book>(b,HttpStatus.CREATED);
	}
	
	@PutMapping("/update-book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id ,@RequestBody Book book) {
		Book b = bookService.updateBook(book);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-book/{id}")
	public void deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
	}
	
	@GetMapping("/author/{name}")
	public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable("name")String aName){
		List<Book>books = bookService.findAllByAuthorName(aName);
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
}
