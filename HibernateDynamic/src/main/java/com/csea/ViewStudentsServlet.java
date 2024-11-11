package com.csea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        List<StudentNew> students = session.createQuery("from StudentNew", StudentNew.class).list();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Student Information</h2>");

        if (students.isEmpty()) {
            out.println("<p>No student records found.</p>");
        } else {
            out.println("<table border='1'>");
            out.println("<tr><th>Roll No</th><th>Name</th></tr>");

            for (StudentNew student : students) {
                out.println("<tr><td>" + student.getRno() + "</td><td>" + student.getName() + "</td></tr>");
            }

            out.println("</table>");
        }

        session.close();
        factory.close();
    }
}
