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

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Lakshan");

        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Is");

        System.out.println("students = " + students);

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nimal");
        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student students = studentRepository.getStudentsByEmailAddress("ishara@gmail.com");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstname = studentRepository.getStudentsByFirstNameByEmailAddress("ishara@gmail.com");

        System.out.println("Student First Name for a given email = " + firstname);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student students = studentRepository.getStudentsByEmailAddressNative("ishara@gmail.com");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student students = studentRepository.getStudentsByEmailAddressNativeNamedParam("ishara@gmail.com");

        System.out.println("Students = " + students);
    }


    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Chamo","ishara@gmail.com");


    }

}