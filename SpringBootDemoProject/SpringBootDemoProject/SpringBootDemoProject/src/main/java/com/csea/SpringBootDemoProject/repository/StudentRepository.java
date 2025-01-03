package com.csea.SpringBootDemoProject.repository;

import com.csea.SpringBootDemoProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
}
