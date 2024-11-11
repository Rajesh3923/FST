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
import java.sql.SQLException;
@WebServlet("/dbcheck")
public class DatabaseConnectionServlet extends HttpServlet {
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

        try {
            // Load JDBC driver (MySQL driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // If the connection is successful, display a success message
            out.println("<html><body>");
            out.println("<h2>Database Connection Status</h2>");
            out.println("<p>Connection to the database was successful!</p>");
            out.println("</body></html>");
        } catch (SQLException | ClassNotFoundException e) {
            // If an exception occurs, display an error message
            out.println("<html><body>");
            out.println("<h2>Database Connection Status</h2>");
            out.println("<p>Error connecting to the database: " + e.getMessage() + "</p>");
            out.println("</body></html>");
            e.printStackTrace();
        } finally {
            // Close the connection if it was established
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
