
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>比赛编辑</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form role="form" action="matchupdateservlet" >
    <div class="form-group col-lg-3">
        <label for="name">比赛名称</label>
        <input type="text" class="form-control" id="name" value="${match.match_name}" name="match_name" >
    </div>
    <div class="form-group col-lg-3">
        <label for="name">比赛开始时间</label>
        <input type="text" class="form-control" id="start_time" value="${match.start_time}" name="start_time" >
    </div>
    <div class="form-group col-lg-3">
        <label for="name">报名结束时间</label>
        <input type="text" class="form-control" id="stop_time" value="${match.stop_time}" name="stop_time">
    </div>
    <br/>
    <input type="hidden" name="id" value="${match.id}">
    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>
