<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/Navigator.jsp" %>
<html>
<head>
    <title>我的比赛</title>
</head>
<body>
<div class="container">
    <h2>我的比赛</h2>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th>ID</th>
            <th>比赛名称</th>
            <th>比赛开始时间</th>
            <th>报名结束时间</th>
            <th>取消报名</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${matchs}" var="match">
            <tr>
                <td>${match.id}</td>
                <td><a href="information.jsp?information=${match.information}">${match.match_name}</a></td>
                <td>${match.start_time}</td>
                <td>${match.stop_time}</td>
                <c:if test="${match.leader==1}">
                    <td><a href="delmymatchservlet?username=<%=(String)request.getSession().getAttribute("username")%>&id=${match.id}">
                        <span class="glyphicon glyphicon-remove"></span></a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@ include file="./include/Footer.jsp" %>
</html>
