package com.csea;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentService {
    public static void main(String[] args) {
        StudentNew s = new StudentNew();
//        s.setRno(44);
//        s.setName("sreeshant");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();
        StudentNew studentToDelete = session.get(StudentNew.class, 44);
        if (studentToDelete != null) {
            session.delete(studentToDelete);
            System.out.println("Successfully deleted student with roll number: 44");
        } else {
            System.out.println("Student with roll number 44 not found, unable to delete.");
        }


//        session.persist(s);//for saving obj
        t.commit();

        session.close();
        factory.close();
        System.out.println("successfully saved");
    }
}


// for updating

//StudentNew studentToUpdate = session.get(StudentNew.class, 44);
//        if (studentToUpdate != null) {
//        studentToUpdate.setName("Updated Name");  // Update the name field
//            session.update(studentToUpdate);  // Save the updated object
//            System.out.println("Successfully updated student with roll number: 44");
//        } else {
//                System.out.println("Student with roll number 44 not found, unable to update.");
//        }