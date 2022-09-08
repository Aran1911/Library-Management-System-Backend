package com.library.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value = "SELECT * FROM book b WHERE b.authorName=?1", nativeQuery = true)
	List<Book> findAllByAuthorName(String name);
	
}
