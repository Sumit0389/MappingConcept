package com.sumit.learning.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.learning.entities.Book;
import com.sumit.learning.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
	List<Book> listOfBooks = bookService.getAllBooks();
	if(listOfBooks.size()<=0)
	{
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(listOfBooks));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookbyId(@PathVariable("id") int id)
	{
		Book book =bookService.getBookById(id);
		if(book==null)
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return ResponseEntity.of(Optional.of(book));
	}
    
	@PostMapping("/books")
	public List<Book> addBook(@RequestBody List<Book> books)
	{
		bookService.addBook(books);
		return books;
	}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable int id)
	{
	 bookService.deleteBook(id);	
	}
	// Update Handler
	@PutMapping("/books")
	public List<Book> updateBooks(@RequestBody List<Book> books)
	{
		return bookService.updateBook(books);
	
		}
	
}
