package com.sumit.learning.services;

import java.util.List;

import com.sumit.learning.entities.Book;

public interface BookService {

	
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public void addBook(List<Book> book);
	public void deleteBook(int id);
	public List<Book> updateBook(List<Book> books);
}
