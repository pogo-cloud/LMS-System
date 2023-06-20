package com.advanceSpringbootProject.LibraryManagementSystem.Repository;

import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
