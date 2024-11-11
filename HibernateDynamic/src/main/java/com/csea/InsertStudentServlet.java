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

@WebServlet("/InsertStudentServlet")  // Correct mapping here
public class InsertStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Reading form data
        int rno = Integer.parseInt(request.getParameter("rno"));
        String name = request.getParameter("name");

        // Setting up Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Creating a new student object
            StudentNew student = new StudentNew();
            student.setRno(rno);
            student.setName(name);

            // Starting transaction
            t = session.beginTransaction();
            session.persist(student);
            t.commit();

            // Success message
            out.println("<h3>Student inserted successfully!</h3>");
            out.println("<a href='ViewStudentsServlet'>Click here to view all students</a>");

        } catch (Exception e) {
            if (t != null) t.rollback();
            out.println("<h3>Error inserting student: " + e.getMessage() + "</h3>");
        } finally {
            session.close();
            factory.close();
        }
    }
}
