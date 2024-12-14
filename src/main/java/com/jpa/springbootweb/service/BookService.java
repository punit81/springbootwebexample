package com.jpa.springbootweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.springbootweb.entity.Book;
import com.jpa.springbootweb.repository.BookRepository;

import jakarta.transaction.Transactional;

// this class is created to mimic fake db service with some records to add/Show/delete/insert
@Component
public class BookService {

	//static List<Book>listBooks=new ArrayList<>();
	
	/*
	 * static { listBooks.add(new Book(1,"Let us C","Yashwant Kanetkar"));
	 * listBooks.add(new Book(2,"Wings Of Fire","A.P.J Abdul Kalam"));
	 * listBooks.add(new Book(3,"A Brief History Of Time","Stephen Hawkings")); }
	 */
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}
	
	@Transactional
	public Book addBook(Book b) {
		Book result=null;
		try {
			if (b.getAuthor() != null) 
			{
				b.getAuthor().setBook(b); // Set the bi-directional relationship 
			}
			result=this.bookRepository.save(b);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Book getBookById(int id) {
		try {
			return this.bookRepository.findById(id).get();
		}
		catch (Exception e) {
			return null;
		}
		
	}

	@Transactional
	public void deleteBookById(int id) {
		this.bookRepository.deleteById(id);
	}
	
	@Transactional
	public void deleteAllBooks() {
		this.bookRepository.deleteAll();
	}

	@Transactional
	public void updateBook(int id, Book book) {
		book.setId(id);
		this.bookRepository.save(book);
	}
}
