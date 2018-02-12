<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Management</title>
        <style>
            th{
                text-align: left;
            }
            div{
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Customer Page</h1>
        <div>
            <a href="${SITE_URL}/home">GO TO HOME PAGE</a> &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${SITE_URL}/customers/add">ADD CUSTOMER</a>
        </div>

        <table border="1" width="100%">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Contact</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${requestScope.customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.contact}</td>
                    <td>${customer.status}</td>
                    <td><a href="${SITE_URL}/customers/edit_customer?id=${customer.id}" >Edit</a> &nbsp;&nbsp;&nbsp;
                        <a href="${SITE_URL}/customers/delete_customer?id=${customer.id}" onclick=" return confirm('Are you sure to delete?')" >Delete</a></td>
                </tr>  
            </c:forEach>
        </table>

    </body>
</html>
