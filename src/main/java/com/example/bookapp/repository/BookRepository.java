package com.example.bookapp.repository;

import com.example.bookapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Custom query: INNER JOIN between Book and Author.
     * Returns rows of [bookTitle, genre, publishedYear, authorName, authorCountry]
     */
    @Query("SELECT b.title, b.genre, b.publishedYear, a.name, a.country " +
           "FROM Book b INNER JOIN b.author a ORDER BY a.name, b.title")
    List<Object[]> findBooksWithAuthors();
}
