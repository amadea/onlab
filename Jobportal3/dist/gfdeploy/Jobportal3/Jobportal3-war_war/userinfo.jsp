<%-- 
    Document   : userinfo
    Created on : 2013.12.14., 16:55:01
    Author     : Ami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User information</title>
    </head>
    <body>
        <h1>User information</h1>
        <form action="./NewServlet" method="POST">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="userName" value="${user.userName}"/></td>
            </tr>
               <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" value="${user.lastName}"/></td>
            </tr>
               <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" value="${user.firstName}"/></td>
            </tr>
               <tr>
                <td>Email address</td>
                <td><input type="text" name="email" value="${user.email}"/> </td>
            </tr>
               <tr>
                <td>Password</td>
                <td><input type="text" name="password" value="${user.password}"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Add" /></td>
                <td><input type="submit" name="action" value="Edit" /></td>
                <td><input type="submit" name="action" value="Delete" /></td>
                <td><input type="submit" name="action" value="Search" /></td>
                <td><input type="submit" name="action" value="ShowAll" /></td>
            </tr>
         </table>
            </form>
                
            <br>
            <table border="1">
                <tr>
                    <th>User Name</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Email address</th>
                    <th>Password</th>
                </tr>
                <c:forEach items="${allUsers}" var="user">
                    <tr>
                        <td>${user.userName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.firstName}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                    </tr>
                </c:forEach>
            </table>
        
    </body>
</html>
