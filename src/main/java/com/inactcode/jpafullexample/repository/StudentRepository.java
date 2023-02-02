package com.inactcode.jpafullexample.repository;

import com.inactcode.jpafullexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentsByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentsByFirstNameByEmailAddress(String emailId);


    //native SQL
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address =?1"
            ,nativeQuery = true
    )
    Student getStudentsByEmailAddressNative(String emailId);

    //native SQL Named Param
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address =:emailId",
            nativeQuery = true
    )
    Student getStudentsByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name =?1 WHERE email_address =?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstname, String emailId);

}
