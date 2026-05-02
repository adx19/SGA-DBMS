package com.example.bookapp.controller;

import com.example.bookapp.entity.Author;
import com.example.bookapp.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("author", new Author());
        return "author_form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("author") Author author, BindingResult br) {
        if (br.hasErrors()) return "author_form";
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "author_form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("author") Author author, BindingResult br) {
        if (br.hasErrors()) return "author_form";
        author.setId(id);
        authorService.save(author);
        return "redirect:/authors";
    }
}
