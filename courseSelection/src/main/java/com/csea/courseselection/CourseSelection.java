package com.csea.courseselection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CourseSelection")
public class CourseSelection extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the course ID entered by the user
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        // Use CourseAllocation to validate and fetch course details
        CourseAllocation courseAllocation = new CourseAllocation();
        Course course = courseAllocation.getCourse(courseId);

        if (course != null) {
            // Valid course ID, forward to success.jsp
            request.setAttribute("course", course);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // Invalid course ID, forward to error.jsp
            request.setAttribute("message", "Invalid Course ID");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
