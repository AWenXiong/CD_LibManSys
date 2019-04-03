<%@ page import="org.library.entity.user" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>用户详情页</title>
    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp"%>
    </style>
</head>
<body>
<%@include file="adminBoard.jsp" %>
<div class="container">
    <div class="card">
        <div class="card-header text-center text-primary">
            <h2>用户详情</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户姓名</th>
                    <th>用户类型</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>
                        <c:if test="${user.userType == 0}">普通用户</c:if>
                        <c:if test="${user.userType == 1}">管理员</c:if>
                    </td>
                    <%
                        user specialUser = new user();
                        session.setAttribute("specialUser", specialUser);
                    %>
                    <td align="center">
                        <a class="btn" href="/jsp/admin/updateUser.jsp">修改</a>
                        <a class="btn" href="/jsp/admin/${user.userId}/deleteUser" onclick='return confirm("确定要删除吗？")'>删除用户</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
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
