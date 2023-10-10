package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.Classroom;
import com.example.thithuchanhmd4.model.Student;
import com.example.thithuchanhmd4.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return iStudentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchClassroom(Classroom classroom) {
        return iStudentRepository.findAllByClassroom(classroom);
    }
}
