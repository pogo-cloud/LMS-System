package com.advanceSpringbootProject.LibraryManagementSystem.Entity;

import com.advanceSpringbootProject.LibraryManagementSystem.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="myBook")
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 private String title;
 private int noOfPages;
 @Enumerated(EnumType.STRING)
 private Genre genre;

 private int price;
 @ManyToOne
 @JoinColumn
 Author author;

 @OneToMany(mappedBy = "book",cascade =CascadeType.ALL)
 List<Transaction> transactionList=new ArrayList<>();

 @ManyToOne
 @JoinColumn
 LibraryCard libraryCard;
}

