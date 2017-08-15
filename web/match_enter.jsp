<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/Navigator.jsp"%>
<html>
<head>
    <title>报名</title>
</head>
<body>
<form role="form"  action="userenterservlet">
    <div class="form-group col-lg-2">
        <c:forEach  var="num" begin="1" end="${match.teammate_num}">
            <c:if test="${num==1}">
                <label for="username">队长学号</label>
            </c:if>
            <c:if test="${!(num==1)}">
                <label for="username"> <c:out value="${num}"/>号学号</label>
            </c:if>
            <input type="text" class="form-control" id="username" name="username">
        </c:forEach>
        <input type="hidden"  value="${match.id}" name="id"/>
        <button type="submit" class="btn btn-default" >提交</button>
    </div>
</form>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
