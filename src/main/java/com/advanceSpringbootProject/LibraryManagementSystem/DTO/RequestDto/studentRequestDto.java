package com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto;

import com.advanceSpringbootProject.LibraryManagementSystem.Enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class studentRequestDto {
  private String name;
  private int age;
  private Department department;
  private String mobNo;
}
