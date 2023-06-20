package com.advanceSpringbootProject.LibraryManagementSystem.Entity;

import com.advanceSpringbootProject.LibraryManagementSystem.Enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="userCard")
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CardId;

    private String ValidTill;
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy="libraryCard",cascade = CascadeType.ALL)
    List<Book>issuedBook=new ArrayList<>();
    @OneToMany(mappedBy="libraryCard",cascade=CascadeType.ALL)
    List<Transaction> transactionlist=new ArrayList<>();

}
