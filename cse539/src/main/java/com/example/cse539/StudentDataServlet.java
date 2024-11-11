package com.example.cse539;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet("/sql")

public class StudentDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vasavi";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type for the response
        response.setContentType("text/html");

        // Get the PrintWriter object to write the response
        PrintWriter out = response.getWriter();

        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC driver (MySQL driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement object
            statement = connection.createStatement();

            // Define the SQL query
            String query = "SELECT rno, name, branch, clg FROM students";

            // Execute the query and get the result set
            resultSet = statement.executeQuery(query);

            // Generate HTML to display the results
            out.println("<html><body>");
            out.println("<h2>Student Data</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>Roll No</th><th>Name</th><th>Branch</th><th>College</th></tr>");

            // Process the result set
            while (resultSet.next()) {
                int rno = resultSet.getInt("rno");
                String name = resultSet.getString("name");
                String branch = resultSet.getString("branch");
                String clg = resultSet.getString("clg");

                out.println("<tr>");
                out.println("<td>" + rno + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + branch + "</td>");
                out.println("<td>" + clg + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            // Handle exceptions
            out.println("<html><body>");
            out.println("<h2>Error</h2>");
            out.println("<p>Error retrieving student data: " + e.getMessage() + "</p>");
            out.println("</body></html>");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
