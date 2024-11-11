package com.csea;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Students {

    @Id
    private int rno;
    private String name;
//    private String brn;

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
