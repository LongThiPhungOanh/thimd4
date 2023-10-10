package com.example.thithuchanhmd4.service;

import com.example.thithuchanhmd4.model.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
    Classroom findById(Long id);

}
