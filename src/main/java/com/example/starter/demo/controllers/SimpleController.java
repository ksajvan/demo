package com.example.starter.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.starter.demo.entities.Book;
import com.example.starter.demo.service.base.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleController {

    @Value("$spring.application.name")
    String appName;

    private BookService bookService;

    @Autowired
    public SimpleController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/test")
    public String home() {
        return "appName";
    }

    @GetMapping("/test1")
    public String myHome() {
        return "another test another build 8888888888888888";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> response = bookService.getAllBooks();

        if (response.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }
}
