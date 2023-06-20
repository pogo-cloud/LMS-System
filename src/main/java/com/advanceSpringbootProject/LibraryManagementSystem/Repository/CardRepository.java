package com.advanceSpringbootProject.LibraryManagementSystem.Repository;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
