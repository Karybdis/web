<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp" %>
<html>
<head>
    <title>找回密码</title>
</head>
<body>
<div class=" container">
    <div class="row">
        <h2 class="text-center">找回密码</h2>
        <form action="forgetpasswordservlet" method="get" class="form-horizontal" >
            <div class="form-group">
                <label class="col-lg-5 control-label" >学 号</label>
                <div class="col-lg-3">
                    <input type="text"  class="form-control" name="username" />
                </div>
            </div>
            <div class="form-group" align="center">
                <button class="btn btn-info" type="submit" >确定</button>
            </div>
        </form>
    </div>
    <p>输入学号后密码会发送到注册时绑定的邮箱，当前版本就用这个劣质的方法了。另外邮件可能被当成垃圾邮件处理，所以请留意垃圾箱</p>
</div>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
