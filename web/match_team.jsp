<%@ page import="javax.naming.Name" %>
<%@ page import="bean.Team" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp" %>
<html>
<head>
    <title>报名队伍</title>
</head>
<body>
<div class="container">
    <h2>报名队伍</h2>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th class="col-lg-2">队长学号</th>
            <th class="col-lg-8">队伍成员</th>
            <th class="col-lg-2">删除队伍</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teams}" var="team">
            <tr>
                <td>${team.leader_name}</td>
                <td><c:forEach items="${team.names}" var="name">${name}  </c:forEach></td>
                <td><a href="delmymatchservlet?username=${team.leader_name}&id=${team.id}&who=1">
                    <span class="glyphicon glyphicon-trash"></span>
                </a></td>
            </tr>
            <c:set var="match_id" scope="request" value="${team.id}"/>
            <c:set var="teammate_num" scope="request" value="${team.teammate_num}"/>
        </c:forEach>
        </tbody>
    </table>
</div>
<form action="teamprintservlet">
    <input type="hidden" value="<c:out value="${match_id}"/>" name="id"/>
    <input type="hidden" value="<c:out value="${teammate_num}"/>" name="teammate_num"/>
    <div align="center">
        <button type="submit" class="btn btn-default">导出Excel</button>
    </div>
</form>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
