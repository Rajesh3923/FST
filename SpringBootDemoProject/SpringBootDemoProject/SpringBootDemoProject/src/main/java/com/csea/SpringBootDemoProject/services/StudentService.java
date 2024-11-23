package com.csea.SpringBootDemoProject.services;

import com.csea.SpringBootDemoProject.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> fetchAll();
    Student fetchById(Integer rno);
//    void deleteById(Integer rno);
//    Student update(Student student);
    List<Student> fetchByName(String name);

}