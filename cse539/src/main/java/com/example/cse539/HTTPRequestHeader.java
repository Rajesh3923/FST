package com.example.cse539;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class HTTPRequestHeader
 */
@WebServlet("/http")

public class HTTPRequestHeader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()/
     */
    public HTTPRequestHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        Enumeration<String> headers = request.getHeaderNames();
        String nameServer = request.getServerName();
        int port = request.getServerPort();
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>HTTP Request Headers</title></head>");
        out.println("<body>");
        out.println("<h1>HTTP Request Headers</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");
        out.println("<tr><td>" + nameServer + "</td><td>" + port + "</td></tr>");

        while (headers.hasMoreElements()) {
            String name = headers.nextElement();
            String value = request.getHeader(name);
            out.println("<tr><td>" + name + "</td><td>" + value + "</td></tr>");
        }

        out.println("</table></body></html>");

    }

//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}