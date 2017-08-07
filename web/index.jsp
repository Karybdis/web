<%--
  Created by IntelliJ IDEA.
  User: sunsc
  Date: 2017/7/27
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
 欢迎 <%=(String)request.getSession().getAttribute("username")%>
<br/>
</body>
</html>
