package com.example.bookapp.service;

import com.example.bookapp.entity.Author;
import com.example.bookapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() { return authorRepository.findAll(); }
    public Author findById(Long id) { return authorRepository.findById(id).orElse(null); }
    public Author save(Author a) { return authorRepository.save(a); }
}
