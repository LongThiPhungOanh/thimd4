package com.example.thithuchanhmd4.repository;

import com.example.thithuchanhmd4.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom, Long> {
}
