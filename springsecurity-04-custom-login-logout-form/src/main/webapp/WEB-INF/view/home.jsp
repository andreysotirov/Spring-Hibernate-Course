<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h2>Hello World</h2>
        <form:form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Logout"/>
        </form:form>
</body>
</html>
