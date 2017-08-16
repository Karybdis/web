<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
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
                <li ><a href="home.jsp" class="glyphicon glyphicon-home">主页</a></li>
                <% String a=(String)request.getSession().getAttribute("username");
                    if (a==null) { %>
                <li ><a href="login.jsp" class="glyphicon glyphicon-log-in">登录/注册</a></li>
                <% } else { %>
                <li ><a href="logoutservlet" class="glyphicon glyphicon-log-out" >登出</a></li>
                <p class="navbar-text navbar-right">
                    Hello! <%=(String)request.getSession().getAttribute("username")%>
                </p>
                <% } %>


            </ul>
            <%  String b=(String)request.getSession().getAttribute("who");
                if ("0".equals(b)) {%>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        个人设置 <b class="caret"></b>
                    </a>
                    <ul  class="dropdown-menu">
                        <li><a href="mymatchservlet?username=<%=(String)request.getSession().getAttribute("username")%>">我的比赛</a></li>
                        <li><a href="modify_pass.jsp">修改密码</a></li>
                    </ul>
                </li>
            </ul>
            <% } %>
        </div>
    </div>
</nav>
</body>
</html>
