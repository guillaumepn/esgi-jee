package com.guillaumepn.servlets;

import com.guillaumepn.bdd.Logins;
import com.guillaumepn.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        Logins logins = new Logins();
        logins.addUser(user);
        String message = "L'utilisateur " + user.getLogin() + " a été ajouté";
        request.setAttribute("message", message);
        this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
