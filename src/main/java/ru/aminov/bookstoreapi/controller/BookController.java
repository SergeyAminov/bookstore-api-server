package ru.aminov.bookstoreapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.aminov.bookstoreapi.service.BookService;
import ru.aminov.bookstoreapi.dto.BookDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookRepository(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("/books")
    public List<BookDto> getBooks() {
        return this.bookService.findAll();
    }
    
}
