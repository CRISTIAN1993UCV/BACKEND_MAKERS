package com.makers.crud.model.dto;

import java.util.List;

import com.makers.crud.model.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsListDto {
    List<Student> students;
}
