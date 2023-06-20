package com.advanceSpringbootProject.LibraryManagementSystem.Controller;

import com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto.IssueBookRequestDto;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.ResponseDto.IssueBookResponseDto;
import com.advanceSpringbootProject.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/add")
    public IssueBookResponseDto showTransaction(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception{
           return transactionService.showTransaction(issueBookRequestDto);
    }
}
