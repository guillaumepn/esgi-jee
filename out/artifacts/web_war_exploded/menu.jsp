<%--
  Created by IntelliJ IDEA.
  User: guillaume
  Date: 27/02/2018
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<ul>
    <li><a href="/accueil">Accueil</a></li>
    <li><a href="/connected">Page privée</a></li>
    <c:if test="${ !empty sessionScope.login }">
        <li><a href="/logout">Se déconnecter</a></li>
    </c:if>
</ul>