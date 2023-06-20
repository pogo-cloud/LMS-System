package com.advanceSpringbootProject.LibraryManagementSystem.Service;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Author;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Book;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book) throws Exception{
        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch(Exception e){
            throw new Exception("Author not present");
        }
        author.getBook().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
        return "Book";

    }

}
