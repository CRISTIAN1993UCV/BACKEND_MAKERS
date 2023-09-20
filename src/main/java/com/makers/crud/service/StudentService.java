package com.makers.crud.service;

import java.util.List;
import java.util.Optional;

import com.makers.crud.model.dto.StudentsListDto;
import com.makers.crud.model.entity.Student;

public interface StudentService {
    StudentsListDto getAllStudents();
    
    Optional<Student>  getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);
}