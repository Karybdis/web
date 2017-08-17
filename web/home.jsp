<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./include/Navigator.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>自动化科协报名网站</title>
</head>
<body>
<div class="container">
    <h2>比赛信息</h2>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
        <tr>
            <th>ID</th>
            <th>比赛名称</th>
            <th>比赛开始时间</th>
            <th>报名结束时间</th>
            <% if ("1".equals(b)) { %>
            <th>编辑</th>
            <th>删除</th>
            <% }  else if ("0".equals(b)) { %>
            <th>报名</th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${matchs}" var="match">
            <tr>
                <td>${match.id}</td>
                <td><a href="information.jsp?information=${match.information}">${match.match_name}</a></td>
                <td>${match.start_time}</td>
                <td>${match.stop_time}</td>
                <% if ("1".equals(b)) { %>
                <td><a href="matcheditservlet?id=${match.id}">
                    <span class="glyphicon glyphicon-edit"></span>
                </a></td>
                <td><a href="matchdelservlet?id=${match.id}">
                    <span class="glyphicon glyphicon-trash"></span>
                </a></td>
                <% } else if ("0".equals(b))  { %>
                <td>  <a href="matchenterservlet?id=${match.id}">
                    <span class="glyphicon glyphicon-plus"></span>
                </a></td>
                <% } %>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<a href="matchretrieveservlet"><button type="button" class="btn btn-default">查询比赛</button></a>
<% if ("1".equals(b)) { %>
<div class="panel panel-success">
    <div class="panel-heading">新增比赛</div>
    <div class="panel-body">
        <form role="form" action="matchaddservlet">
            <div class="form-group col-lg-12">
                <label for="information">比赛详情</label>
                <textarea rows="15" class="form-control" id="information" name="information"></textarea>
            </div>
            <div class="form-group col-lg-3">
                <label for="name">比赛名称</label>
                <input type="text" class="form-control" id="name" placeholder="请输入名称" name="match_name"/>
            </div>
            <div class="form-group col-lg-3">
                <label for="start_time">比赛开始时间</label>
                <input type="text" class="form-control" id="start_time" name="start_time"/>
            </div>
            <div class="form-group col-lg-3">
                <label for="stop_time">报名结束时间</label>
                <input type="text" class="form-control" id="stop_time" name="stop_time"/>
            </div>
            <div class="form-group col-lg-3" >
                <label for="teammate_num">队伍人数</label>
                <input type="text" class="form-control" id="teammate_num" name="teammate_num"/>
            </div>
            <div align="center">
                <button type="submit" class="btn btn-default" >提交</button>
            </div>
        </form>
    </div>
</div>
<% } %>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>