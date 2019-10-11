package com.example.starter.demo.service.base;

import java.util.List;

import com.example.starter.demo.entities.Book;

public interface BookService {

    public List<Book> getAllBooks();

    public Book getBookById(Long id);

    public Book save(Book book);
}