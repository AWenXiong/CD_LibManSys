<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>添加用户</title>
    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp"%>
    </style>
</head>
<body>
<%@include file="adminBoard.jsp" %>
<!-- 提示脚本 -->
<%
    Object successfullyAdd = session.getAttribute("successfullyAddUser");
    if (successfullyAdd != null) {
%>
<script type="text/javascript">
    alert("新增用户成功")
</script>
<% session.removeAttribute("successfullyAddUser");
}%>

<form class="form-horizontal" action="/jsp/admin/doAddUser" method="post">
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="userName">用户姓名：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="userName" name="userName">
        </div>
    </div>

    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="password">密码：</label>
        <div class="col-sm-10">
            <input class="form-control" type="password" id="password" name="password">
        </div>
    </div>

    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="userType">用户类型：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="userType" name="type">
        </div>
    </div>

    <input class="btn btn-success" type="submit" value="添加">
</form>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>