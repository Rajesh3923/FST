package com.csea.SpringBootDemoProject.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Student {

    @Id
    private Integer rno;
    private String name;
    private String brn;

    public Integer getRno() {
        return rno;
    }
    public void setRno(Integer rno) {
        this.rno = rno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrn() {
        return brn;
    }
    public void setBrn(String brn) {
        this.brn = brn;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", brn='" + brn + '\'' +
                '}';
    }

}
