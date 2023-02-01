package com.inactcode.jpafullexample.repository;

import com.inactcode.jpafullexample.entity.Course;
import com.inactcode.jpafullexample.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){


        Course course =Course.builder()
                .credit(6)
                .title("AWS fundamentals")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();


        courseMaterialRepository.save(courseMaterial);
    }


    @Test
    public void printAllCoursesMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("courseMaterials =" + courseMaterials);
    }

}