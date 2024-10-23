package com.wlee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wlee.dao.UserDAO;
import com.wlee.model.User;
import com.wlee.util.PasswordUtils;

@WebServlet("/changePWD")

public class ChangePWDServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("/changePWD.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String email = request.getParameter("email");
        String currentPWD = request.getParameter("currentPassword");
        String newPWD = request.getParameter("newPassword");

        try {
            User existingUser = userDAO.findByEmail(email);
            
            if (existingUser == null || !PasswordUtils.checkPassword(currentPWD, existingUser.getPassword())) {
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
                return;
            }

            // update password
            userDAO.updatePWD(email, newPWD);

            request.setAttribute("Succeeded", "Password Updated.");
            
            request.getRequestDispatcher("/welcome").forward(request, response);
            
        } catch (Exception e) {
            throw new ServletException("Error while changing password.", e);
        }
   }
}
