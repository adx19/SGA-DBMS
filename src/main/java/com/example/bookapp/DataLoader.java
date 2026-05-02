package com.example.bookapp;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.repository.AuthorRepository;
import com.example.bookapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataLoader(AuthorRepository a, BookRepository b) {
        this.authorRepository = a;
        this.bookRepository = b;
    }

    @Override
    public void run(String... args) {
        if (authorRepository.count() > 0) return;

        List<Author> authors = List.of(
            new Author("J.K. Rowling", "United Kingdom"),
            new Author("George R.R. Martin", "United States"),
            new Author("J.R.R. Tolkien", "United Kingdom"),
            new Author("Agatha Christie", "United Kingdom"),
            new Author("Stephen King", "United States"),
            new Author("Haruki Murakami", "Japan"),
            new Author("Gabriel Garcia Marquez", "Colombia"),
            new Author("Chimamanda Ngozi Adichie", "Nigeria"),
            new Author("Leo Tolstoy", "Russia"),
            new Author("Jane Austen", "United Kingdom")
        );
        authorRepository.saveAll(authors);

        List<Book> books = List.of(
            new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 1997, authors.get(0)),
            new Book("A Game of Thrones", "Fantasy", 1996, authors.get(1)),
            new Book("The Hobbit", "Fantasy", 1937, authors.get(2)),
            new Book("Murder on the Orient Express", "Mystery", 1934, authors.get(3)),
            new Book("The Shining", "Horror", 1977, authors.get(4)),
            new Book("Norwegian Wood", "Fiction", 1987, authors.get(5)),
            new Book("One Hundred Years of Solitude", "Magical Realism", 1967, authors.get(6)),
            new Book("Half of a Yellow Sun", "Historical", 2006, authors.get(7)),
            new Book("War and Peace", "Historical", 1869, authors.get(8)),
            new Book("Pride and Prejudice", "Romance", 1813, authors.get(9))
        );
        bookRepository.saveAll(books);

        System.out.println(">>> Sample data loaded: "
            + authorRepository.count() + " authors, "
            + bookRepository.count() + " books");
    }
}
