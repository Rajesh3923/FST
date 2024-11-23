package com.csea.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SetupCredentialsServlet")
public class SetupCredentialsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simulate initial credentials (for demo purposes, we're hardcoding them here)
        String initialUsername = "testUser";
        String initialPassword = "testPass";

        // Store the credentials in a single cookie
        String credentials = initialUsername + ":" + initialPassword;
        Cookie credentialsCookie = new Cookie("userCredentials", credentials);
        credentialsCookie.setMaxAge(60 * 60 * 24); // Set cookie for 1 day

        // Add the cookie to the response
        response.addCookie(credentialsCookie);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<h3>Credentials are set in the cookie. You can now <a href='login.html'>login here</a>.</h3>");
        out.close();
    }
}

