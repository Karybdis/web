<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/Navigator.jsp"%>
<html>
<head>
    <title>报名</title>
</head>
<body>
<div class=" container">
    <div class="row">
        <form action="userenterservlet" method="get" class="form-horizontal" >
            <c:forEach  var="num" begin="1" end="${match.teammate_num}">
                <div class="form-group ">
                    <c:if test="${num==1}">
                        <label class="col-lg-5 control-label" >队长学号</label>
                    </c:if>
                    <c:if test="${!(num==1)}">
                        <label class="col-lg-5 control-label" ><c:out value="${num}"/>号学号</label>
                    </c:if>
                    <div class="col-lg-3">
                        <input type="text"  class="form-control" name="username">
                    </div>
                </div>
            </c:forEach>
            <input type="hidden"  value="${match.id}" name="id"/>
            <div align="center">
                <button type="submit" class="btn btn-default" >提交</button>
            </div>
        </form>
    </div>
</div>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
