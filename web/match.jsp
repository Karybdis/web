<%--
  Created by IntelliJ IDEA.
  User: sunsc
  Date: 2017/8/7
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>比赛设置</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form role="form" action="home.jsp">
    <div class="form-group col-lg-3">
        <label for="name">比赛名称</label>
        <input type="text" class="form-control" id="name"
               placeholder="请输入名称"  >
    </div>
    <div class="form-group col-lg-3">
        <label for="name">比赛开始时间</label>
        <input type="text" class="form-control" id="start_time" >
    </div>
    <div class="form-group col-lg-3">
        <label for="name">比赛结束时间</label>
        <input type="text" class="form-control" id="stop_time" >
    </div>
    <br/>
    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>
