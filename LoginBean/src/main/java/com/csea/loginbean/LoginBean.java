package com.csea.loginbean;

// LoginBean.java
public class LoginBean {
    private String username;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Validation method
    public boolean validate() {
        return "Admin".equals(username) && "Admin@123".equals(password);
    }
}

