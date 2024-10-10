package com.wlee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    // protected void doPost(HttpServletRequest request, HttpServletResponse response)
    // throws ServletException, IOException {
    //         // IOException: if an input or output error is detected when the servlet handles the GET request
    //         // ServletException: if the request could not be handled
    //         String email = request.getParameter("email");
    //         String password = request.getParameter("password");

    //         User existingUser = FakeDatabase.getUser(email);

    //         if (existingUser == null || !existingUser.getPassword().equals(password)) {

    //             request.setAttribute("errorMessage", "Invalid username or password");

    //             request.getRequestDispatcher("/login.jsp").forward(request, response);
                
    //         }

    //         HttpSession session = request.getSession(); // create a new session if there's no session
    //         session.setAttribute("user", existingUser);

    //         String sessionToken = session.getId();

    //         String redirectURL = String.format("/welcome;WebLogicSession=%s?PN=LGN&PE=22&FLAG_BORSA=0&FLAG_PART_EMPR=P&FLAG_BKONLINE=0&FLAG_BANCA_PRIVADA=0&FLAG_BANCA_PERSONAL=null", sessionToken);

    //         response.sendRedirect(redirectURL);


    //     }
}
