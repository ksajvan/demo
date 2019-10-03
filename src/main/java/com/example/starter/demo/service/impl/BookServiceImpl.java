package com.example.starter.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.starter.demo.entities.Book;
import com.example.starter.demo.repository.BookRepository;
import com.example.starter.demo.service.base.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return new Book();
    }
}
