package com.example.bookapp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleIntegrity(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("errorMessage",
            "Data integrity violation: " + ex.getMostSpecificCause().getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneric(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Unexpected error: " + ex.getMessage());
        return "error";
    }
}
