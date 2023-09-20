package com.makers.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makers.crud.model.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
