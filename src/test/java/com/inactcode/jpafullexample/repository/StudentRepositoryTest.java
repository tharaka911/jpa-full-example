package com.inactcode.jpafullexample.repository;

import com.inactcode.jpafullexample.entity.Guardian;
import com.inactcode.jpafullexample.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("tharaka@gmail.com")
                .firstName("Lakshan")
                .lastName("tharaka")
                //.guardianName("Nimal")
                //.guardianEmail("nimal@gmail.com")
                //.guardianMobile("0710507342")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian =Guardian.builder()
                .name("Paminda")
                .email("paminda@gmail.com")
                .mobile("0111111111")
                .build();

        Student student = Student.builder()
                .emailId("ishara@gmail.com")
                .firstName("Ishara")
                .lastName("Lakshitha")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = "+studentList);
    }

}