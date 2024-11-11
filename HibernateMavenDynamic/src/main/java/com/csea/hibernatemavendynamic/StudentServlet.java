package com.csea.hibernatemavendynamic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String rno = request.getParameter("rno");
        String name = request.getParameter("name");

        // Logic to insert student into the database
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            Student student = new Student();
            student.setRno(Integer.parseInt(rno));
            student.setName(name);

            session.save(student);
            tx.commit();
            session.close();

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Student inserted successfully: " + name + "</h2>");
            out.println("<a href='index.html'>Go to Home</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inserting student.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().println("Use POST request to submit student data.");
    }
}
