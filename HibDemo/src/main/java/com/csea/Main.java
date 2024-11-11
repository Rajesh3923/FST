// database name - students

package com.csea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main
{
    @SuppressWarnings("deprecation")
    public static void main( String[] args )
    {
        Students s = new Students();
        s.setRno(7);
        s.setName("Vinay");
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students.class);
        SessionFactory sf = con.buildSessionFactory();
        Session se = sf.openSession();
        Transaction tx = se.beginTransaction();

        // Save the student object
        se.save(s);

        // Commit the transaction
        tx.commit();
        System.out.println("Student inserted successfully.");





//        Transaction tx2 = se.beginTransaction();
//        Students studentToUpdate = se.get(Students.class, 39); // Fetch the student by roll number
//        if (studentToUpdate != null) {
//            studentToUpdate.setName("Rajesh Kumar"); // Update name
//            se.update(studentToUpdate); // Save changes
//            System.out.println("Student updated successfully.");
//        } else {
//            System.out.println("Student not found for updating.");
//        }
//        tx2.commit();





//         Delete a student
        Transaction tx3 = se.beginTransaction();
        Students studentToDelete = se.get(Students.class, 39); // Fetch the student by roll number
        if (studentToDelete != null) {
            se.delete(studentToDelete); // Delete the student
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found for deletion.");
        }
        tx3.commit();

//         Close the session and session factory








        // View list of all students
        Transaction tx4 = se.beginTransaction();
        List<Students> studentsList = se.createQuery("from Students", Students.class).list(); // Fetch all students
        System.out.println("List of all students:");
        for (Students student : studentsList) {
            System.out.println("Roll No: " + student.getRno() + ", Name: " + student.getName());
        }
        tx4.commit();
        se.close();
        sf.close();
    }
}