package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // You can define custom query methods if needed, like this:

    // below is the custom query to fidn by name , but we are not using this query
    // to use this query , we should implement this in all files , add to fetch student details by his
    // name , url should be like - http://localhost:8080/api/students/findByName?name=Rajesh
    List<Student> findByName(String name);
    Student findByRno(int rno);
}
