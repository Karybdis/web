<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div class=" container">
    <div class="row">
        <h2 class="text-center">注册</h2>
        <form action="signupservlet" method="get" class="form-horizontal" >
            <div class="form-group ">
                <label class="col-lg-5 control-label" >学 号</label>
                <div class="col-lg-3">
                    <input type="text"  class="form-control" name="username"/>
                </div>
            </div>
            <div class="form-group ">
                <label class="col-lg-5 control-label" >密 码</label>
                <div class="col-lg-3">
                    <input type="password" class="form-control" name="password"/>
                </div>
            </div>
            <div class="form-group ">
                <label class="col-lg-5 control-label" >姓 名</label>
                <div class="col-lg-3">
                    <input type="text" class="form-control" name="name"/>
                </div>
            </div>
            <div class="form-group ">
                <label class="col-lg-5 control-label" >性 别</label>
                <div class="col-lg-3">
                    <input type="radio" name="sex" value="1" checked/>男
                    <input type="radio" name="sex" value="0"/>女
                </div>
            </div>
            <div class="form-group ">
                <label class="col-lg-5 control-label" >邮 箱</label>
                <div class="col-lg-3">
                    <input type="text" class="form-control" name="email"/>
                </div>
            </div>
            <div class="form-group ">
                <label class="col-lg-5 control-label" >电 话</label>
                <div class="col-lg-3">
                    <input type="text" class="form-control" name="phone"/>
                </div>
            </div>
            <div class="form-group" align="center">
                <input type="submit" class="btn btn-info" value="确定" />
            </div>
        </form>
    </div>
</div>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
