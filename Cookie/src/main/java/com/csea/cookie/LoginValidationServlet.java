package com.csea.cookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginValidationServlet")
public class LoginValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("password");

        // Retrieve the "userCredentials" cookie
        Cookie[] cookies = request.getCookies();
        Cookie credentialsCookie = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userCredentials")) {
                    credentialsCookie = cookie;
                    break;
                }
            }
        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Validate credentials if the cookie is found
        if (credentialsCookie != null) {
            String[] storedCredentials = credentialsCookie.getValue().split(":");
            String storedUsername = storedCredentials[0];
            String storedPassword = storedCredentials[1];

            // Check if input matches stored credentials
            if (storedUsername.equals(inputUsername) && storedPassword.equals(inputPassword)) {
                out.println("<h3>Login successful! Welcome back, " + inputUsername + ".</h3>");
            } else {
                out.println("<h3>Invalid credentials. Please try again.</h3>");
            }
        } else {
            out.println("<h3>No credentials found. Please contact the administrator.</h3>");
        }

        out.println("<a href='login.html'>Go back to Login</a>");
        out.close();
    }
}
