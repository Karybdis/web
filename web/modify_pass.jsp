<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<div class=" container">
    <div class="row">
        <h2 class="text-center">修改密码</h2>
        <form action="modifypasswordservlet" method="get" class="form-horizontal" >
            <div class="form-group ">
                <label class="col-lg-5 control-label" >原密码</label>
                <div class="col-lg-3">
                    <input type="text"  class="form-control" name="ex_password">
                </div>
            </div>
            <div class="form-group ">
                <label class="col-lg-5 control-label" >新密码</label>
                <div class="col-lg-3">
                    <input type="text" class="form-control" name="password" >
                </div>
            </div>
            <input type="hidden" name="username" value="<%=(String)request.getSession().getAttribute("username")%>"/>
            <div align="center">
                <button type="submit" class="btn btn-default">确定</button>
            </div>
        </form>
    </div>
</div>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
