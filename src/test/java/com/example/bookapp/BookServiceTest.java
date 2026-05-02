package com.example.bookapp;

import com.example.bookapp.entity.Author;
import com.example.bookapp.entity.Book;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock BookRepository bookRepository;
    @InjectMocks BookService bookService;

    @Test
    void findAllDelegatesToRepository() {
        Author a = new Author("A", "C");
        Book b = new Book("T", "G", 2000, a);
        when(bookRepository.findAll()).thenReturn(List.of(b));

        assertThat(bookService.findAll()).hasSize(1);
        verify(bookRepository).findAll();
    }

    @Test
    void saveDelegatesToRepository() {
        Author a = new Author("A", "C");
        Book b = new Book("T", "G", 2000, a);
        when(bookRepository.save(b)).thenReturn(b);

        assertThat(bookService.save(b)).isEqualTo(b);
    }
}
