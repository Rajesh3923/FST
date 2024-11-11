package com.csea.hibernatemavendynamic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rno = Integer.parseInt(request.getParameter("rno"));

        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            Student student = session.get(Student.class, rno);
            if (student != null) {
                session.delete(student);
                tx.commit();

                PrintWriter out = response.getWriter();
//                out.println("Student deleted successfully: " + rno);
                out.println("<html><body>");
                out.println("<h2>Student deleted successfully: " + rno + "</h2>");
                out.println("<a href='index.html'>Go to Home</a>");
                out.println("</body></html>");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Student not found.");
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting student.");
        }
    }
}
