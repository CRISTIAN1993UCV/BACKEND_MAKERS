package com.makers.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makers.crud.model.dto.ResponseEntityDto;
import com.makers.crud.model.entity.Student;
import com.makers.crud.repository.StudentRepository;
import com.makers.crud.service.StudentService;
import com.makers.crud.service.impl.StudentServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntityDto getAllStudents() {
        System.out.println(studentService.getAllStudents().getStudents().size());
        return ResponseEntityDto.builder()._embedded(studentService.getAllStudents()).build();
    }

     @GetMapping("/{id}")
    public ResponseEntityDto getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        
        return ResponseEntityDto.builder()._embedded(student.get()).build();
    }

    @PostMapping
    public ResponseEntityDto createStudent(@RequestBody Student student) {
        student= studentService.createStudent(student);
        return ResponseEntityDto.builder()._embedded(student).build();
    }

    @PutMapping("/{id}")
    public ResponseEntityDto updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        updatedStudent= studentService.updateStudent(id,updatedStudent);
        return ResponseEntityDto.builder()._embedded(updatedStudent).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntityDto deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntityDto.builder()._embedded(null).build();
    }
}
