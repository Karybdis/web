<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/Navigator.jsp"%>
<html>
<head>
    <title>用户</title>
</head>
<body>

<div class="container">
    <h2>用户管理</h2>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>重置密码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" >
            <tr>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td><a href="resetpasswordservlett?username=${user.username}">
                    <span class="glyphicon glyphicon-repeat"></span>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>重置密码后密码均为123456</p>
</div>

<%@ include file="./include/Footer.jsp" %>
</body>
</html>
