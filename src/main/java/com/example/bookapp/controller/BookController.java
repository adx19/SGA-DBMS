package com.example.bookapp.controller;

import com.example.bookapp.entity.Book;
import com.example.bookapp.service.AuthorService;
import com.example.bookapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("joined", bookService.findBooksWithAuthors());
        return "books";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return "book_form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("authors", authorService.findAll());
            return "book_form";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("authors", authorService.findAll());
        return "book_form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("book") Book book,
                         BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("authors", authorService.findAll());
            return "book_form";
        }
        book.setId(id);
        bookService.save(book);
        return "redirect:/books";
    }
}
