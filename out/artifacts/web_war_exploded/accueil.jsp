<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 27/02/2018
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Accueil</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<p>${ !empty message ? message : '' }</p>

<h1>Accueil</h1>

<h2>Connexion</h2>

<c:choose>
  <c:when test="${ !empty sessionScope.login }">
      <p>Bonjour ${ sessionScope.login }</p>
  </c:when>
  <c:otherwise>
      <form action="accueil" method="post">
          <p>
              <label for="login">Login : </label>
              <input type="text" id="login" name="login">
          </p>
          <p>
              <label for="password">Password : </label>
              <input type="password" id="password" name="password">
          </p>

          <input type="submit">
      </form>
  </c:otherwise>
</c:choose>

</body>
</html>
