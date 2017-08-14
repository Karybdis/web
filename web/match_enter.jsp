<%--
  Created by IntelliJ IDEA.
  User: sunsc
  Date: 2017/8/14
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>
<html>
<head>
    <title>报名</title>
</head>
<body>
<c:forEach begin="1" end="${match.teammate_num}">
    <input type="text">
    <br/>
</c:forEach>
</body>
</html>
