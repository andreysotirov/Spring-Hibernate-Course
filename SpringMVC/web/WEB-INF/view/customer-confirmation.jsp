<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 02.05.2019
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation Form</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br><br>
Free passes: ${customer.freePasses}
<br><br>
Postal code: ${customer.postalCode}
<br><br>
Course code: ${customer.courseCode}
</body>
</html>
