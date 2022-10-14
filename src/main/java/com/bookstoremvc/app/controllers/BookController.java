package com.bookstoremvc.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoremvc.app.entities.Book;
import com.bookstoremvc.app.services.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.create(book);
	}
	
	@GetMapping("/list")
	public List<Book> listBooks() {
		return bookService.getBooks();
	}
	
	@DeleteMapping("/delete")
	public boolean deleteBook(@RequestBody Book book) {
		return bookService.delete(book);
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.create(book); 
	}
	
	@GetMapping("/search")
	public Book getBook(int id) {
		return bookService.getBook(id);
	}
}
