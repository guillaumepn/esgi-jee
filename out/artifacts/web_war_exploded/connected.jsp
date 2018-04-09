<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 09/04/2018
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


</body>
</html>
