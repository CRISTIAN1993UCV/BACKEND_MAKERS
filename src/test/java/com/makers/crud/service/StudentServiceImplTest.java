package com.makers.crud.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.makers.crud.model.dto.StudentsListDto;
import com.makers.crud.model.entity.Student;
import com.makers.crud.repository.StudentRepository;
import com.makers.crud.service.StudentService;
import com.makers.crud.service.impl.StudentServiceImpl;

public class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student(), new Student());
        when(studentRepository.findAll()).thenReturn(students);

        StudentsListDto studentsListDto = studentService.getAllStudents();

        assertNotNull(studentsListDto.getStudents());
        assertEquals(students.size(), studentsListDto.getStudents().size());
    }

    @Test
    public void testGetStudentById() {
        Long studentId = 1L;
        Student student = new Student();
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        Optional<Student> retrievedStudent = studentService.getStudentById(studentId);

        assertTrue(retrievedStudent.isPresent());
        assertEquals(student, retrievedStudent.get());
    }
    @Test
    public void testCreateStudent() {
        Student student = new Student();
        
        when(studentRepository.save(student)).thenReturn(student);
        
        Student createdStudent = studentService.createStudent(student);
        
        // Verifica que el estudiante creado no sea nulo y sea igual al estudiante ficticio
        assertNotNull(createdStudent);
        assertEquals(student, createdStudent);
    }
    
    @Test
    public void testUpdateStudent() {
        Long studentId = 1L;
        Student updatedStudent = new Student();
        
        when(studentRepository.getById(studentId)).thenReturn(new Student());
        when(studentRepository.save(any())).thenReturn(updatedStudent);

        Student updated = studentService.updateStudent(studentId, updatedStudent);
        
        assertNotNull(updated);
        assertEquals(studentId, updated.getId()); // Verifica que el ID del estudiante sea el mismo
    }
    
    @Test
    public void testDeleteStudent() {
        Long studentId = 1L;
        
        doNothing().when(studentRepository).deleteById(studentId);
        
        studentService.deleteStudent(studentId);
        
        verify(studentRepository, times(1)).deleteById(studentId);
    }
    
}
