package com.example;  

import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.Cookie;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  

import java.io.IOException;  

@WebServlet("/storeUserInfo")  
public class StoreUserInfoServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        String username = request.getParameter("username");  

        // Create a cookie and set the username or email  
        Cookie cookie = new Cookie("userInfo", username);  
        cookie.setMaxAge(60 * 60 * 24); // Cookie lasts for 1 day  
        response.addCookie(cookie);  

        // Redirect back to the form page  
        response.sendRedirect("index.html");  
    }  
}