<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 11.05.2019
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role: <security:authentication property="principal.authorities"/>
</p>
<hr>
<security:authorize access="hasRole('MANAGER')">
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
</security:authorize>
<hr>
<h2>Hello World</h2>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
