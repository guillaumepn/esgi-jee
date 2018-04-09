package com.guillaumepn.servlets;

import com.guillaumepn.bdd.Logins;
import com.guillaumepn.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Accueil", urlPatterns = {"/accueil"})
public class Accueil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        String message;
        Logins logins = new Logins();
        if (logins.verifUser(user)) {
                HttpSession session = request.getSession();
                message = "Connexion réussie !";
                session.setAttribute("login", request.getParameter("login"));

                request.setAttribute("message", message);
            response.sendRedirect("/connected");
        } else {
            message = "Connexion fail :(";

            request.setAttribute("message", message);
            this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
    }
}
