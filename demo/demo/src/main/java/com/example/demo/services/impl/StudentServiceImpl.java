package com.example.demo.services.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.StudentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    private final StudentRepository studentRepository;

    // Constructor-based Dependency Injection
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Implementation of retrieving all students
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();  // Retrieves all students from the DB
    }

    // Implementation of inserting a new student
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);  // Saves a new student to the DB
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student getStudentByRno(int rno) {
        return studentRepository.findByRno(rno);
    }
}
