<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 27/02/2018
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<ul class="menu">
    <li><a class="btn btn-light" href="/accueil">Accueil</a></li>
    <li><a class="btn btn-light" href="/connected">Page privée</a></li>
    <c:if test="${ !empty sessionScope.login }">
        <li><a class="btn btn-light" href="/logout">Se déconnecter</a></li>
    </c:if>
</ul>