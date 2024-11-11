package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private final StudentServiceInterface studentService;

    public StudentController(StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    // Endpoint to retrieve all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Endpoint to insert a new student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentService.getStudentByName(name); // Retrieve students by name
    }

    @GetMapping("/rno/{rno}")
    public Student getStudentByRno(@PathVariable int rno) {
        return studentService.getStudentByRno(rno); // Retrieve a student by roll number
    }
}
