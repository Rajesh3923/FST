package com.csea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int rno = Integer.parseInt(request.getParameter("rno"));
        String name = request.getParameter("name");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            t = session.beginTransaction();
            StudentNew student = session.get(StudentNew.class, rno);
            if (student != null) {
                student.setName(name);
                session.update(student);
                t.commit();


                out.println("<h3>Student updated successfully!</h3>");
                out.println("<a href='ViewStudentsServlet'>Click here to view all students</a>");

            } else {
                out.println("<h3>Student with roll number " + rno + " not found.</h3>");
            }
        } catch (Exception e) {
            if (t != null) t.rollback();
            out.println("<h3>Error updating student: " + e.getMessage() + "</h3>");
        } finally {
            session.close();
            factory.close();
        }
    }
}
