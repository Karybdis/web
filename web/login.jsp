<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登录界面</title>
    <script>
        function r()
        {
            var username=document.getElementById("username");
            var pass=document.getElementById("password");
            if(username.value=="")
            {
                alert("请输入用户名");
                username.focus();
                return;
            }
            if(pass.value=="")
            {
                alert("请输入密码");
                return;
            }
            return true;
        }
    </script>
</head>
<body>
<div class=" container">
    <div class="row">
        <h2 class="text-center">登录</h2>
        <form action="loginservlet" method="get" class="form-horizontal" >
            <div class="form-group has-success">
                <label class="col-sm-2 col-md-2 control-label" >学 号</label>
                <div class="col-sm-10 col-md-10">
                    <input type="text"  class="form-control" name="username" placeholder="学号" >
                </div>
            </div>
            <div class="form-group has-success">
                <label class="col-sm-2 col-md-2 control-label">密 码</label>
                <div class="col-sm-10 col-md-10">
                    <input type="password" class="form-control" name="password" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10 col-md-10">
                    <input type="radio" name="who" value="0" checked> 用户
                    <input type="radio" name="who" value="1"> 管理员
                </div>
            </div>
            <div class="form-group ">
                <div class="col-sm-offset-4 col-sm-10 col-md-10">
                    <button class="btn btn-info" type="submit" onclick="r()">登 录</button>
                    <button class="btn btn-info" type="button" onclick="window.location=('sign_up.jsp')">注 册</button>
                    <button class="btn btn-info" type="reset">清 空</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
