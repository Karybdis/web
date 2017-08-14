<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="signupservlet" method="get">
    <label>学  号</label> <input type="text" name="username">
    <br/>
    <label>密  码</label> <input type="password" name="password">
    <br/>
    <label>姓  名</label> <input type="text" name="name">
    <br/>
    <label>性  别</label> <input type="radio" name="sex" value="1" checked>男
    <input type="radio" name="sex" value="0">女
    <br/>
    <label>邮  箱</label> <input type="text" name="email">
    <br/>
    <input type="submit" value="确定" />
</form>
</body>
</html>
