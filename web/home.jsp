<%--
  Created by IntelliJ IDEA.
  User: sunsc
  Date: 2017/8/7
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>自动化科协报名网站</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        onload=function()
        {
            var e=document.getElementById("refreshed");
            if(e.value=="no")e.value="yes";
            else{e.value="no";location.reload();}
        }  
    </script>
</head>
<body>

<input type="hidden" id="refreshed" value="no">

<nav class="navbar navbar-default" role="navigation"  >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" >网站导航</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a >主页</a></li>
                <% String a=(String)request.getSession().getAttribute("username");
                    if (a==null) { %>
                <li ><a href="login.jsp" >登录</a></li>
                <% } else { %>
                <li ><a href="logoutservlet" >登出</a></li>
               <% String b=(String)request.getSession().getAttribute("who");
                    if ("0".equals(b)) { %>
                <li ><a >报名</a></li>
                <% } else { %>
                <li class="dropdown">
                    <a href="match.jsp" class="dropdown-toggle" data-toggle="dropdown">
                        比赛设置
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">添加比赛</a></li>
                        <li><a href="#">删除比赛</a></li>
                        <li><a href="#">修改比赛</a></li>

                    </ul>
                        <% } %>
                <li>Hello! <%=(String)request.getSession().getAttribute("username")%> </li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h2>比赛信息</h2>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th>比赛名称</th>
            <th>比赛开始时间</th>
            <th>报名结束时间</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>8/8</td>
            <td>8/7</td>

        </tr>
        <tr>
            <td>2</td>
            <td>8/9</td>
            <td>8/8</td>

        </tr>
        </tbody>
    </table>
</div>

<% String b=(String)request.getSession().getAttribute("who");
    if ("1".equals(b)) { %>
<form role="form" action="matchaddservlet">
    <div class="form-group col-lg-3">
        <label for="name">比赛名称</label>
        <input type="text" class="form-control" id="name" placeholder="请输入名称" name="match_name" >
    </div>
    <div class="form-group col-lg-3">
        <label for="name">比赛开始时间</label>
        <input type="text" class="form-control" id="start_time" name="start_time" >
    </div>
    <div class="form-group col-lg-3">
        <label for="name">比赛结束时间</label>
        <input type="text" class="form-control" id="stop_time" name="stop_time">
    </div>
    <br/>
    <button type="submit" class="btn btn-default">提交</button>
</form>
<% } %>
</body>
</html>