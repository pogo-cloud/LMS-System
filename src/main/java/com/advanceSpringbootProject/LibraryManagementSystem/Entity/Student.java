package com.advanceSpringbootProject.LibraryManagementSystem.Entity;

import com.advanceSpringbootProject.LibraryManagementSystem.Enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentId;

    private String name;

    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String mobNo;

    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)
    LibraryCard card;
}
