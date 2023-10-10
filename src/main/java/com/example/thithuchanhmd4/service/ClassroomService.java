package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.Classroom;
import com.example.thithuchanhmd4.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository iClassroomRepository;
    @Override
    public List<Classroom> findAll() {
        return iClassroomRepository.findAll();
    }

    @Override
    public Classroom findById(Long id) {
        return iClassroomRepository.findById(id).orElse(null);
    }
}
