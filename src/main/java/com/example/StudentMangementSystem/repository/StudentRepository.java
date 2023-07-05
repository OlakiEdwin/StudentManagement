package com.example.StudentMangementSystem.repository;

import com.example.StudentMangementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

}