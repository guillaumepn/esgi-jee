<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 27/02/2018
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accueil</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>


<c:if test="${!empty message}">
    <div class="alert alert-info" role="alert">${ message }</div>
</c:if>

<h1>Accueil</h1>

<h3>Connexion</h3>

<c:choose>
  <c:when test="${ !empty sessionScope.login }">
      <p>Bonjour ${ sessionScope.login }</p>
      <p>Vous êtes connecté</p>
  </c:when>
  <c:otherwise>
      <form class="form-inline" action="accueil" method="post">
              <input class="form-control" type="text" id="login" name="login" placeholder="Identifiant" required>

              <input class="form-control" type="password" id="password" name="password" placeholder="Mot de passe" required>

          <input class="btn btn-primary" type="submit" value="Se connecter">
      </form>
  </c:otherwise>
</c:choose>

<c:if test="${ empty sessionScope.login }">
    <h3>Inscription</h3>
    <form class="form-inline" action="register" method="post">
        <input class="form-control" type="text" id="loginRegister" name="login" placeholder="Identifiant" required>

        <input class="form-control" type="password" id="passwordRegister" name="password" placeholder="Mot de passe" required>

        <input class="btn btn-primary" type="submit" value="S'inscrire">
    </form>
</c:if>

<%@ include file="scripts.jsp"%>
</body>
</html>
