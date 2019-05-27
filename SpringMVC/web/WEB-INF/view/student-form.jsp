<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 01.05.2019
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    <form:select path="country">

        <form:options items="${student.countryOptions}"/>

    </form:select>

    <br><br>

    Favorite Language:

    <br><br>

     <form:radiobutton path="favoriteLanguage" label="Java" value="Java"/>
     <form:radiobutton path="favoriteLanguage" label="PHP" value="PHP"/>
     <form:radiobutton path="favoriteLanguage" label="JS" value="JS"/>
     <form:radiobutton path="favoriteLanguage" label="C#" value="C#"/>

    <br><br>

    Operating System:

    <br><br>

    <form:checkbox path="operatingSystems" label="Linux" value="Linux"/>
    <form:checkbox path="operatingSystems" label="MacOS" value="MacOS"/>
    <form:checkbox path="operatingSystems" label="Windows" value="Windows"/>

    <br><br>

    <input type="submit" value="Submit">

</form:form>

</body>
</html>
