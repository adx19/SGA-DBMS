package com.example.bookapp.service;

import com.example.bookapp.entity.Book;
import com.example.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() { return bookRepository.findAll(); }
    public Book findById(Long id) { return bookRepository.findById(id).orElse(null); }
    public Book save(Book b) { return bookRepository.save(b); }
    public List<Object[]> findBooksWithAuthors() { return bookRepository.findBooksWithAuthors(); }
}
