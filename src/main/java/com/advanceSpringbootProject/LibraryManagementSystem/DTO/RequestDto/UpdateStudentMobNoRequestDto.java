package com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStudentMobNoRequestDto {
    private int StudentId;
    private String mobNo;

}
