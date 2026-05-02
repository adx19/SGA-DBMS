package com.example.bookapp;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.repository.AuthorRepository;
import com.example.bookapp.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired AuthorRepository authorRepo;
    @Autowired BookRepository bookRepo;

    @Test
    void innerJoinQueryReturnsRows() {
        Author a = authorRepo.save(new Author("Test Author", "Testland"));
        bookRepo.save(new Book("Test Book", "Test", 2020, a));

        List<Object[]> rows = bookRepo.findBooksWithAuthors();
        assertThat(rows).isNotEmpty();
        assertThat(rows.get(0)[0]).isEqualTo("Test Book");
        assertThat(rows.get(0)[3]).isEqualTo("Test Author");
    }

    @Test
    void saveAndFindAuthor() {
        Author a = authorRepo.save(new Author("Unique Name", "X"));
        assertThat(authorRepo.findById(a.getId())).isPresent();
    }
}
