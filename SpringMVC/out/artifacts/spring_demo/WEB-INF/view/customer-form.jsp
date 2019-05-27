<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 02.05.2019
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration Form</title>

    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">

    First Name: <form:input path="firstName"/>

    <br><br>

    Last Name: <form:input path="lastName" placeholder="*"/>
    <form:errors cssClass="error" path="lastName"/>

    <br><br>

    Free Passes: <form:input path="freePasses"/>
    <form:errors cssClass="error" path="freePasses"/>

    <br><br>

    Postal Code: <form:input path="postalCode"/>
    <form:errors cssClass="error" path="postalCode"/>

    <br><br>

    Course Code <form:input path="courseCode"/>
    <form:errors cssClass="error" path="courseCode"/>

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>

</body>
</html>
