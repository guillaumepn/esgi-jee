<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 27/02/2018
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<ul>
    <li><a href="/accueil">Accueil</a></li>
    <li><a href="/connected">Page privée</a></li>
    <c:if test="${ !empty sessionScope.login }">
        <li><a href="/logout">Se déconnecter</a></li>
    </c:if>
</ul>