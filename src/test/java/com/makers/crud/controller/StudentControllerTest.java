package com.makers.crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makers.crud.model.entity.Student;
import com.makers.crud.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStudentById() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setFirstname("Cristhian");
        student.setLastname("Terris");

        when(studentService.getStudentById(1L)).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setFirstname("Cristhian");
        student.setLastname("Terris");

        when(studentService.createStudent(student)).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void testDeleteStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
