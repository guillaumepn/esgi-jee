package com.guillaumepn.servlets;

import com.guillaumepn.bdd.Logins;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Connected", urlPatterns = {"/connected"})
public class Connected extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("login") != null) {
            System.out.println("logged");

            Logins logins = new Logins();
            List users = logins.listUsers();
            request.setAttribute("users", users);
            this.getServletContext().getRequestDispatcher("/connected.jsp").forward(request, response);
        } else {
            System.out.println("not logged");
            response.sendRedirect("/accueil");
        }
    }
}
