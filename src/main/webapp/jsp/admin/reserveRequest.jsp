<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>预定请求页</title>
    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp" %>
    </style>
</head>
<body>
<%@include file="adminBoard.jsp" %>
<!-- 提示脚本 -->
<%
    Object successfullyAdd = session.getAttribute("successfullyAgreeReserve");
    if (successfullyAdd != null) {
%>
<script type="text/javascript">
    alert("借书成功")
</script>
<% session.removeAttribute("successfullyAgreeReserve");
}%>
<div class="container">
    <div class="card">
        <div class="card-header text-center text-primary">
            <h2>读者预定请求</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>图书ID</th>
                    <th>图书名</th>
                    <th>作者</th>
                    <th>申请时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reserve" items="${reserveList}">
                    <tr>
                        <td name="userId">${reserve.userId}</td>
                        <td name="userName">${reserve.userName}</td>
                        <td name="bookId">${reserve.bookId}</td>
                        <td name="bookName">${reserve.bookName}</td>
                        <td name="bookWriter">${reserve.bookWriter}</td>
                        <td name="createTime">${reserve.createTime}</td>
                        <td align="center">
                            <a class="btn"
                               href="/jsp/admin/${reserve.userId}/${reserve.bookId}/${reserve.createTime}/agreeLendRequest">同意</a>
                        </td>
                    </tr>
                </c:forEach>
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