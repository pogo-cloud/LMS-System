package com.advanceSpringbootProject.LibraryManagementSystem.Service;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.RequestDto.studentRequestDto;
import com.advanceSpringbootProject.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.LibraryCard;
import com.advanceSpringbootProject.LibraryManagementSystem.Entity.Student;
import com.advanceSpringbootProject.LibraryManagementSystem.Enums.CardStatus;
import com.advanceSpringbootProject.LibraryManagementSystem.Exception.StudentNotFoundException;
import com.advanceSpringbootProject.LibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(studentRequestDto StudentRequestDto){
        Student student=new Student();
        student.setName(StudentRequestDto.getName());
        student.setAge(StudentRequestDto.getAge());
        student.setDepartment(StudentRequestDto.getDepartment());
        student.setMobNo(StudentRequestDto.getMobNo());
        LibraryCard card=new LibraryCard();
        card.setValidTill("2024-11-01");
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);

    }
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {
        try{
            Student student=studentRepository.findById(updateStudentMobNoRequestDto.getStudentId()).get();
            student.setMobNo(updateStudentMobNoRequestDto.getMobNo());
            Student updateStudent=studentRepository.save(student);

            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto=new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updateStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updateStudentMobNoRequestDto.getMobNo());
            return updateStudentMobNoResponseDto;

        }
        catch(Exception e){
            throw new StudentNotFoundException("Invalid student ID");
        }


    }
}
