package com.example.cse539;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/currentDateTime")
public class CurrentDateAndTime extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set content type and character encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Create a formatter for date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date and time
        String formattedDateTime = currentDateTime.format(formatter);

        // Create HTML content
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Current Date & Time</title></head>");
        out.println("<body>");
        out.println("<h2>Current Date & Time</h2>");
        out.println("<p>" + formattedDateTime + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}