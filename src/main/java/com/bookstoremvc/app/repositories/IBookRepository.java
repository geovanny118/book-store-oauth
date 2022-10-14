package com.bookstoremvc.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstoremvc.app.entities.Book;

@Repository
public interface IBookRepository extends CrudRepository<Book, Integer> {
	
	@Query(value = "SELECT * FROM books", nativeQuery = true)
	public List<Book> getAllBooks();
	
}
