package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.Classroom;
import com.example.thithuchanhmd4.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    void delete(Long id);
    List<Student> searchClassroom(Classroom classroom);
}
