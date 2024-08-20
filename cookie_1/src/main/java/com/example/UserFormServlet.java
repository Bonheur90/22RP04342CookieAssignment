package com.example;  

import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;  
import jakarta.servlet.http.Cookie;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  

import java.io.IOException;  

@WebServlet("/form")  
public class UserFormServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // Check for cookies  
        String username = null;  
        Cookie[] cookies = request.getCookies();  
        
        if (cookies != null) {  
            for (Cookie cookie : cookies) {  
                if ("userInfo".equals(cookie.getName())) {  
                    username = cookie.getValue();  
                    break;  
                }  
            }  
        }  

        // Set the username attribute so it can be used in the JSP  
        request.setAttribute("username", username);  
        request.getRequestDispatcher("index.html").include(request, response);  
    }  
}