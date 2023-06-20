package com.advanceSpringbootProject.LibraryManagementSystem.Controller;

import com.advanceSpringbootProject.LibraryManagementSystem.DTO.ResponseDto.AuthorResponseDto;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Author;
import com.advanceSpringbootProject.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){
       return authorService.addAuthor(author);
    }
    @GetMapping("/getEmail")
    public AuthorResponseDto getByEmail(@RequestParam("email")String email){
        return authorService.showAuthor(email);
    }
}
