package com.guillaumepn.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
    private String resultat;

    public void verifier(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (password.equals("test")) {
            this.resultat = "Vous êtes bien connecté";
        } else {
            this.resultat = "Identifiants incorrects";
        }
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
