package com.example.demo.services;

import com.example.demo.entity.Student;
import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAllStudents();  // Method to retrieve all students

    List<Student> getStudentByName(String name);     // Fetch by name
    Student getStudentByRno(int rno);


    Student saveStudent(Student student);  // Method to insert a new student
}
