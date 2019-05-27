
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Student country: ${student.country}

<br><br>

Favorite language: ${student.favoriteLanguage}

<br><br>

Operating System:

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
    <li>${temp}</li>
    </c:forEach>
</ul>

</body>
</html>
