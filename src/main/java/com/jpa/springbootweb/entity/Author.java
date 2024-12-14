package com.jpa.springbootweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "author_id")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int author_id;
	String firstName;
	String lastName;
	String language;
	
	@OneToOne
	@JoinColumn(name = "book_id")
	@JsonBackReference
	Book book;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Author(int author_id, String firstName, String lastName, String language, Book book) {
		super();
		this.author_id = author_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.book = book;
	}


	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
				+ language + ", b=" + book + "]";
	}
	
	
	
}
