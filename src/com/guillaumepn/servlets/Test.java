package com.guillaumepn.servlets;

import com.guillaumepn.bdd.Logins;
import com.guillaumepn.beans.Auteur;
import com.guillaumepn.beans.User;
import com.guillaumepn.forms.ConnectionForm;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test")
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ConnectionForm form = new ConnectionForm();
//        form.verifier(request);
//
//        request.setAttribute("form", form);

        /**
         * Inscription
         */
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        Logins logins = new Logins();
        logins.addUser(user);

        // Listing des users
        request.setAttribute("users", logins.listUsers());

        this.getServletContext().getRequestDispatcher("/bonjour.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logins tableLogins = new Logins();
        request.setAttribute("users", tableLogins.listUsers());
        this.getServletContext().getRequestDispatcher("/bonjour.jsp").forward(request, response);
    }
}
