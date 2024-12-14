package com.jpa.springbootweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.springbootweb.entity.Book;
import com.jpa.springbootweb.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		return bookService.getAllBooks().size()==0?ResponseEntity.status(HttpStatus.NOT_FOUND).build():ResponseEntity.status(HttpStatus.CREATED).body(bookService.getAllBooks());
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id){
		return bookService.getBookById(id)==null?ResponseEntity.status(HttpStatus.NOT_FOUND).build():ResponseEntity.status(HttpStatus.CREATED).body(bookService.getBookById(id));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b){
		try{
			bookService.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
		try {
			bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/books")
	public  ResponseEntity<Void> deleteBooks(){
		try {
			bookService.deleteAllBooks();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBooks(@PathVariable("id")int id,@RequestBody Book b){
		try {
			bookService.updateBook(id,b);
			return ResponseEntity.status(HttpStatus.CREATED).body(b);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
