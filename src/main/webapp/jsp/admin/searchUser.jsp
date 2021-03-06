<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>搜索用户</title>
    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp"%>
    </style>
</head>
<body>
<%@include file="adminBoard.jsp" %>
<!-- 提示脚本 -->
<%
    Object successfullyAdd = session.getAttribute("successfullyDeleteUser");
    if (successfullyAdd != null) {
%>
<script type="text/javascript">
    alert("删除用户成功")
</script>
<% session.removeAttribute("successfullyDeleteUser");
}%>
<!-- 提示脚本 -->
<%
    Object successfullyUpdateUser = session.getAttribute("successfullyUpdateUser");
    if (successfullyUpdateUser != null) {
%>
<script type="text/javascript">
    alert("更新用户信息成功")
</script>
<% session.removeAttribute("successfullyUpdateUser");
}%>

<div class="text-center">
    <h1>用户检索</h1>
</div>
<div class="center-block">
    <form action="/jsp/admin/userDetail" method="get" class="form-inline my-2 my-md-0">
        <input type="text" placeholder="请输入用户ID" name="userID" class="form-control">
        <input class="btn btn-success" type="submit" value="搜索">
    </form>
</div>
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
