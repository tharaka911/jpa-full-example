package com.inactcode.jpafullexample.repository;

import com.inactcode.jpafullexample.entity.Course;
import com.inactcode.jpafullexample.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

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
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("lenn")
                .lastName("dharamapala")
                .build();

        Course course = Course.builder()
                .title("medicine")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable firstPageWithTwoRecords =
                PageRequest.of(1, 2);
        List<Course> courses =
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getContent();

        long totalElement =
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getTotalElements();


        long totalPages =
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElement = " + totalElement);
        System.out.println("course = " + courses);


    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDescending =
                PageRequest.of(0,2,Sort.by("credit")
                        .descending());

        Pageable sortByCreditAndTitleDescending =
                PageRequest.of(0,2,Sort.by("title")
                        .descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle)
                .getContent();
        System.out.println("courses = " + courses);
    }
    
    
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =PageRequest.of(0,10);
        
        List<Course> courses = 
                courseRepository.findByTitleContaining(
                        "E",firstPageTenRecords
                ).getContent();

        System.out.println("courses = " + courses);
    }

}