package com.advanceSpringbootProject.LibraryManagementSystem.Controller;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Book;
import com.advanceSpringbootProject.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) throws Exception{
        return bookService.addBook(book);
    }
}
