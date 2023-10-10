package com.example.thithuchanhmd4.controller;

import com.example.thithuchanhmd4.model.Student;
import com.example.thithuchanhmd4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(iStudentService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student = iStudentService.findById(id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Student student = iStudentService.findById(id);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            iStudentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Student student){
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
