package com.csea.SpringBootDemoProject.controller;

import com.csea.SpringBootDemoProject.entity.Student;
import com.csea.SpringBootDemoProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String fetchAll(Model model) {
        List<Student> students = studentService.fetchAll();
        model.addAttribute("students", students);
        return "studentList";
    }


    @GetMapping("/getStudent/{rno}")  // Include {rno} in the URL pattern
    public String fetchById(@PathVariable Integer rno, Model model) {
        Student student = studentService.fetchById(rno);
        model.addAttribute("student", student);
        return "studentDetails"; // Make sure you have a template for this
    }


    @GetMapping("/addStudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/saveStudent")
    public String save(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping("/searchByName")
    public String fetchByName(@RequestParam String name, Model model) {
        List<Student> students = studentService.fetchByName(name);
        model.addAttribute("students", students);
        return "studentList";
    }

//    @GetMapping("/students")
//    public String fetchAll(Model model) {
//        List<Student> students = studentService.fetchAll();
//        System.out.println("Fetched Students: " + students); // Debugging line
//        model.addAttribute("students", students);
//        return "studentList";
//    }


/***
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/fetchAll")
    public List<Student> fetchAll() {
        return studentService.fetchAll();
    }

    @GetMapping("/fetchById/{rno}")
    public Student fetchById(@PathVariable Integer rno) {
        return studentService.fetchById(rno);
    }

    @DeleteMapping("/deleteById/{rno}")
    public String deleteById(@PathVariable("rno") Integer rno) {
        studentService.deleteById(rno);
        return "Deleted Successfully";
    }

    @PostMapping("/fetchByName")
    public List<Student> fetchByName(@RequestBody Student student) {
        return studentService.fetchByName(student.getName());
    }
***/


}
