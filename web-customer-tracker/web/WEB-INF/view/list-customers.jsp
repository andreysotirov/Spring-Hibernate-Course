<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 05.05.2019
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List Customers</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">

        <input type="button" value="Add Customer"
               onclick="window.location.href='addCustomer'; return false;"
               class="add-button"/>
        <div>
            <form:form action="search" method="get">
                Search Customer:<input type="text" name="searchName"/>
                <input type="submit" value="Search" class="add-button"/>
            </form:form>
        </div>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempCostumers" items="${customers}">

                <c:url var="updateLink" value="/customer/updateCustomer">
                    <c:param name="customerId" value="${tempCostumers.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCostumers.id}"/>
                </c:url>

                <tr>
                    <td>${tempCostumers.firstName}</td>
                    <td>${tempCostumers.lastName}</td>
                    <td>${tempCostumers.email}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
