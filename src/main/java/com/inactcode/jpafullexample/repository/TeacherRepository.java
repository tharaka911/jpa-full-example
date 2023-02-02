package com.inactcode.jpafullexample.repository;

import com.inactcode.jpafullexample.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher , Long> {
}
