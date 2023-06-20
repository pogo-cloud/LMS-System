package com.advanceSpringbootProject.LibraryManagementSystem.Controller;

import com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto.studentRequestDto;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Student;
import com.advanceSpringbootProject.LibraryManagementSystem.Exception.StudentNotFoundException;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.StudentRepository;
import com.advanceSpringbootProject.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody studentRequestDto StudentrequestDto){
        studentService.addStudent(StudentrequestDto);
        return "Student added Successfully";
    }
    @PutMapping("/update-mobNo")
    public UpdateStudentMobNoResponseDto updateMob(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobNoRequestDto);
    }

}
