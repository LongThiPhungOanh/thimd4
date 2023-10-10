package com.example.thithuchanhmd4.repository;

import com.example.thithuchanhmd4.model.Classroom;
import com.example.thithuchanhmd4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByClassroom(Classroom classroom);
}
