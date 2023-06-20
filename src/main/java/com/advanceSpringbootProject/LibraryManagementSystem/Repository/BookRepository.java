package com.advanceSpringbootProject.LibraryManagementSystem.Repository;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
