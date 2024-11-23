package com.csea.loginbean;

// LoginControllerServlet.java
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create LoginBean object and set username and password
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        // Validate credentials
        if (loginBean.validate()) {
            // Forward to success.jsp if credentials are valid
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // Forward to error.jsp if credentials are invalid
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

