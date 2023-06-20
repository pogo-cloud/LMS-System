package com.advanceSpringbootProject.LibraryManagementSystem.Repository;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
