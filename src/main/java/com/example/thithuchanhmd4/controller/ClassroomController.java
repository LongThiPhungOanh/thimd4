package com.example.thithuchanhmd4.controller;

import com.example.thithuchanhmd4.model.Classroom;
import com.example.thithuchanhmd4.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/class")
public class ClassroomController {
    @Autowired
    private IClassroomService iClassroomService;

    @GetMapping
    public ResponseEntity<List<Classroom>> findAll(){
        return ResponseEntity.ok(iClassroomService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Classroom> findById(@PathVariable Long id){
        Classroom classroom = iClassroomService.findById(id);
        if (classroom == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(classroom, HttpStatus.OK);
        }
    }

}
