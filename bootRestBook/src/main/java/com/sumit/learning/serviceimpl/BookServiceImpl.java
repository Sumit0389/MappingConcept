package com.sumit.learning.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sumit.learning.entities.Book;
import com.sumit.learning.repository.BookRepository;
import com.sumit.learning.services.BookService;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	private static List<Book> listOfbooks= new ArrayList<>();
	
	
	public List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id)
	{    
	      try {
		  return bookRepository.findById(id);
	      }catch(Exception e)
	      {
	    	e.printStackTrace();  
	      }
	    return null;
	}
	public void addBook(List<Book> books)
	{
		bookRepository.saveAll(books);
	}
	@Override
	public void deleteBook(int id) {
		
		bookRepository.delete(bookRepository.findById(id));
		
	}
	public List<Book> updateBook(List<Book> books)
	{
		//listOfbooks=bookRepository.findAll();
		for(Book b: books)
		{
			Book book=bookRepository.findById(b.getId());
			book.setAuther(b.getAuther());
			book.setName(b.getName());
			bookRepository.save(book);
		}
		return bookRepository.findAll();
		
	}
	

}
//tOfbooks	=listOfbooks.stream().map(object->()
	/*
	 * if(object.getId()==b.getId()) { object.setAuther(b.getAuther());
	 * object.setName(b.getName()); }
	 */