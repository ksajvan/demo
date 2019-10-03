package com.example.starter.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.starter.demo.entities.Book;
import com.example.starter.demo.service.base.BookService;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getAllBooks() {

        Book b1 = new Book();
        b1.setId(1000L);
        b1.setAuthor("Author 1");
        b1.setTitle("Title 1");

        Book b2 = new Book();
        b2.setId(2000L);
        b2.setAuthor("Author 2");
        b2.setTitle("Title 2");

        List<Book> result = new ArrayList<>();
        result.add(b1);
        result.add(b2);

        return result;
    }

    @Override
    public Book getBookById(Long id) {
        return new Book();
    }
}
