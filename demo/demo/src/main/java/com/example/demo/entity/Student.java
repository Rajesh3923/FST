package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")  // Mapping the table name
public class Student {

    @Id  // Marking the primary key
    private int rno;  // 'rno' column

    private String name;  // 'name' column

    // Getters and Setters
    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
