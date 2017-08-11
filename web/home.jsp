<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                <li ><a href="home.jsp">主页</a></li>
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
            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${matchs}" var="match">
            <tr>
                <td>${match.match_name}</td>
                <td>${match.start_time}</td>
                <td>${match.stop_time}</td>
                <td><span class="glyphicon glyphicon-edit"></span></td>
                <td><a href="matchdelservlet?match_name=${match.match_name}">
                    <span class="glyphicon glyphicon-trash"></span>
                </a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<a href="matchretrieveservlet"><button type="button" class="btn btn-default">查询比赛</button></a>

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
<p>管理员 admin 123</p>
</body>
</html>