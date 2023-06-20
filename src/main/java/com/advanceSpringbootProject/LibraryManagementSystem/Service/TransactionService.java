package com.advanceSpringbootProject.LibraryManagementSystem.Service;

import com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto.IssueBookRequestDto;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.ResponseDto.IssueBookResponseDto;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Book;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.LibraryCard;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Transaction;
import com.advanceSpringbootProject.LibraryManagementSystem.Enums.CardStatus;
import com.advanceSpringbootProject.LibraryManagementSystem.Enums.TransactionStatus;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.BookRepository;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.CardRepository;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

public class TransactionService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    private JavaMailSender emailSender;
    public IssueBookResponseDto showTransaction(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        LibraryCard card;
        try {
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.DEACTIVATED);
            transactionRepository.save(transaction);
            throw new Exception("Card is Deactivated");
        }
        transaction.setLibraryCard(card);
        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.DEACTIVATED);
            transactionRepository.save(transaction);
            throw new Exception("Card is Deactivated");
        }
        transaction.setBook(book);
        if(card.getStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.EXPIRED);
            transactionRepository.save(transaction);
            throw new Exception("Card is Expired!");
        }
        transaction.setTransactionStatus(TransactionStatus.ACTIVATED);
        book.setLibraryCard(card);
        book.getTransactionList().add(transaction);
        card.getIssuedBook().add(book);
        card.getTransactionlist().add(transaction);
        cardRepository.save(card);

        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        String text="The book is issued by-"+card.getStudent().getName()+"you have been issued the book"+book.getTitle();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dee@gmail.com");
        message.setTo(card.getStudent().getMobNo());
        message.setSubject("Issue book");
        message.setText(text);
        emailSender.send(message);
        return issueBookResponseDto;
     }
}
