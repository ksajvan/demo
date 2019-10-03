package com.example.starter.demo.repository;

import java.util.List;

import com.example.starter.demo.entities.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();
}