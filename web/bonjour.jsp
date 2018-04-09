<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 27/02/2018
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Bonjour</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<%--<c:set target="${ auteur }" property="prenom" value="Matt"/>--%>

<c:if test="${ !empty sessionScope.login }">
    <p>Bonjour ${ sessionScope.login }</p>
</c:if>

<p>${ !empty form.resultat ? form.resultat : "" }</p>

<h2>Inscription</h2>
<form action="bonjour" method="post">
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

<h3>Liste des users</h3>

<c:forEach items="${ users }" var="user">
    ${ user.login } / ${ user.password } <br>
</c:forEach>

<%--<p><c:out value="${ test }">Wow</c:out></p>--%>

<%--<c:forEach var="i" begin="0" end="10" step="1">--%>
    <%--<p>tacle assassin carton rouge n°<c:out value="${ i }"/></p>--%>
<%--</c:forEach>--%>

<%--<c:if test="${ 50 > 10 }">--%>
    <%--OIUIIIII Hééhéhéhéééé à--%>
<%--</c:if>--%>


<%--<c:set var="inverse" value="${ !auteur.actif }" scope="page" />--%>

<%--<p><c:out value="${ inverse }"/></p>--%>

<%--<p>${ auteur.actif ? "actif" : "nope" }</p>--%>

<%--<p><c:out value="Bonjour" /></p>--%>

</body>
</html>
