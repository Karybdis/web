
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./include/Navigator.jsp" %>
<html>
<head>
    <title>比赛编辑</title>
</head>
<body>
<form role="form" action="matchupdateservlet" >
    <div class="form-group col-lg-3">
        <label for="match_name">比赛名称</label>
        <input type="text" class="form-control" id="match_name" value="${match.match_name}" name="match_name" >
    </div>
    <div class="form-group col-lg-3">
        <label for="start_time">比赛开始时间</label>
        <input type="text" class="form-control" id="start_time" value="${match.start_time}" name="start_time" >
    </div>
    <div class="form-group col-lg-3">
        <label for="stop_time">报名结束时间</label>
        <input type="text" class="form-control" id="stop_time" value="${match.stop_time}" name="stop_time">
    </div>
    <div class="form-group col-lg-3">
        <label for="teammate_num">队伍人数</label>
        <input type="text" class="form-control" id="teammate_num" value="${match.teammate_num}" name="teammate_num">
    </div>
    <br/>
    <input type="hidden" name="id" value="${match.id}">
    <div align="center">
        <button type="submit" class="btn btn-default">提交</button>
    </div>
</form>
<%@ include file="./include/Footer.jsp" %>
</body>
</html>
