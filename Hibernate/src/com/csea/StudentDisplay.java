package com.csea;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Arrays;
import java.util.List;
public class StudentDisplay {
    @SuppressWarnings({ "deprecation", "null" })
    public static void main(String[] args) {
        StudentNew s = new StudentNew();
//        s.setRno(39);
//        s.setName("Rajesh");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        List<Integer> rollNumbers = Arrays.asList(7, 39, 40, 41,44); // Enter Roll Numbers you inserted previously

        System.out.println("Extracting rows using get() and load():");

        for (Integer rno : rollNumbers) {
            // Using get() to fetch the student by roll number
            StudentNew studentGet = session.get(StudentNew.class, rno);
            if (studentGet != null) {
                System.out.println("Using get() - Roll No: " + studentGet.getRno() + ", Name: " + studentGet.getName());
            }
            else {
                System.out.println("No student found with Roll No: " + rno + " using get()");
            }

            // Using load() to fetch the student by roll number
            try {
                StudentNew studentLoad = session.load(StudentNew.class, rno);
                System.out.println("Using load() - Roll No: " + studentLoad.getRno() + ", Name: " + studentLoad.getName());
            }
            catch (org.hibernate.ObjectNotFoundException e) {
                System.out.println("No student found with Roll No: " + rno + " using load()");
            }
        }

        session.close();
        factory.close();
    }
}
