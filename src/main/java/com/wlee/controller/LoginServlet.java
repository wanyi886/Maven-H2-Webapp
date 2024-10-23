package com.wlee.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wlee.dao.UserDAO;
import com.wlee.model.User;
import com.wlee.util.PasswordUtils;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            // IOException: if an input or output error is detected when the servlet handles the GET request
            // ServletException: if the request could not be handled
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                User existingUser = userDAO.findByEmail(email);
    
                if (existingUser == null || !PasswordUtils.checkPassword(password, existingUser.getPassword())) {
                    request.setAttribute("errorMessage", "Invalid username or password");
                    request.getRequestDispatcher("/login.jsp").forward(request, response); 
                }

                HttpSession session = request.getSession(); // create a new session if there's no session
                session.setAttribute("user", existingUser);
                response.sendRedirect("welcome.jsp");
                
            } catch (SQLException e) {
                throw new ServletException("Database error", e);
            }

        }
}
