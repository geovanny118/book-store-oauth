package com.bookstoremvc.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoremvc.app.entities.Book;
import com.bookstoremvc.app.repositories.IBookRepository;

@Service
public class BookService {
	@Autowired
	private IBookRepository bookRepository;
	
	public Book create(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getBooks(){
		return bookRepository.getAllBooks();
	}
	
	public boolean delete(Book book) {
		try {
			bookRepository.delete(book);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public Book getBook(int id) {
		return bookRepository.findById(id).orElse(null);
	}
}
