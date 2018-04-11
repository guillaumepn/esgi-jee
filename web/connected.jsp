<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 09/04/2018
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connected</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<p>${ !empty message ? message : '' }</p>

<c:if test="${ !empty sessionScope.login }">
    <p>Bonjour ${ sessionScope.login }</p>
</c:if>

<h1>Connecté</h1>

<h2>Page privée</h2>

<table class="table">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Supprimer</th>
    </tr>

    <c:forEach items="${ users }" var="user">
        <tr>
            <td><c:out value="${ user.getId() }"/></td>
            <td><c:out value="${ user.getLogin() }"/></td>
            <td><c:out value="${ user.getPassword() }"/></td>
            <td><a href="/delete?id=${ user.getId() }" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></a></td>
        </tr>
    </c:forEach>
</table>

<%@ include file="scripts.jsp"%>
</body>
</html>
