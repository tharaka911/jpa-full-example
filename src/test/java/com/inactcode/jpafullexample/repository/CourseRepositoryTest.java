package com.inactcode.jpafullexample.repository;

import com.inactcode.jpafullexample.entity.Course;
import com.inactcode.jpafullexample.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() {
        Course course = Course.builder()
                .title("French")
                .credit(4).build();

        courseRepository.save(course);

    }
    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher =Teacher.builder()
                .firstName("Ishara")
                .lastName("Lakshitha")
                .build();

        Course course = Course.builder()
                .title("php")
                .credit(2)
                .teacher(teacher)
                .build();

        courseRepository.save(course);



    }


}