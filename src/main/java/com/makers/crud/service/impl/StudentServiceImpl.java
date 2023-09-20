package com.makers.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makers.crud.model.dto.StudentsListDto;
import com.makers.crud.model.entity.Student;
import com.makers.crud.repository.StudentRepository;
import com.makers.crud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentsListDto getAllStudents() {
        // TODO Auto-generated method stub
        StudentsListDto studentsListDto=new StudentsListDto();
        studentsListDto.setStudents(studentRepository.findAll());
        return studentsListDto;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        // TODO Auto-generated method stub
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
        // TODO Auto-generated method stub
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        // TODO Auto-generated method stub
        Student studentDB=studentRepository.getById(id);
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        // TODO Auto-generated method stub
        studentRepository.deleteById(id);
    }
}
