package com.csea.SpringBootDemoProject.services.impl;

import com.csea.SpringBootDemoProject.entity.Student;
import com.csea.SpringBootDemoProject.repository.StudentRepository;
import com.csea.SpringBootDemoProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchAll(){
        return studentRepository.findAll();
    }

    @Override
    public Student fetchById(Integer rno){
        return studentRepository.findById(rno).get();
    }

//    @Override
//    public void deleteById(Integer rno){
//        studentRepository.deleteById(rno);
//    }

//    @Override
//    public Student update(Student student){
//        return studentRepository.save(student);
//    }

    @Override
    public List<Student> fetchByName(String name) {
        return studentRepository.findByName(name);
    }
}
