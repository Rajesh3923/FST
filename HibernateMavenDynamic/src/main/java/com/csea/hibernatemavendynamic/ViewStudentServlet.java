package com.csea.hibernatemavendynamic;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int rno = Integer.parseInt(request.getParameter("rno"));

        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            Student student = session.get(Student.class, rno);

            PrintWriter out = response.getWriter();
            if (student != null) {
//                out.println("Student ID: " + student.getId());

                out.println("<html><body>");
                out.println("<h2>Student Rno : " +  student.getRno() + "</h2>");
                out.println("<h2>Student Name: " +  student.getName() + "</h2>");
                out.println("<a href='index.html'>Go to Home</a>");
                out.println("</body></html>");
//                out.println("Roll Number: " + student.getRno());
//                out.println("Name: " + student.getName());
            } else {
                out.println("Student not found.");
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error viewing student.");
        }
    }
}
