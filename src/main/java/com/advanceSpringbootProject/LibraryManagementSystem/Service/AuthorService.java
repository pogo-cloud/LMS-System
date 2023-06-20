package com.advanceSpringbootProject.LibraryManagementSystem.Service;

import com.advanceSpringbootProject.LibraryManagementSystem.DTO.ResponseDto.AuthorResponseDto;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Author;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author){
       authorRepository.save(author);
       return "author added Successfully";
    }
    public AuthorResponseDto showAuthor(String email){
        Author author=authorRepository.findAuthorByEmail(email);
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        return authorResponseDto;
    }
}
