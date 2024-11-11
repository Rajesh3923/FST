package com.example.cse539;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServerDetails
 */
@WebServlet("/serverDetails")

public class ServerDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
//
//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getServerName();
        int port = request.getServerPort();

        // Create HTML content
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Server Details</title></head>");
        out.println("<body>");
        out.println("<h2>Server Details:</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Detail</th><th>Value</th></tr>");
        out.println("<tr><td>Server Name</td><td>" + name + "</td></tr>");
        out.println("<tr><td>Server Port</td><td>" + port + "</td></tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
