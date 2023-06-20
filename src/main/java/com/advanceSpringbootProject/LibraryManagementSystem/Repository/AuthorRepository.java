package com.advanceSpringbootProject.LibraryManagementSystem.Repository;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findAuthorByEmail(@Param("email") String email);

}
