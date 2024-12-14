package com.jpa.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.springbootweb.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
