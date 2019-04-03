<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>还书请求页</title>
    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp" %>
    </style>
</head>
<body>
<%@include file="adminBoard.jsp" %>
<!-- 提示脚本 -->
<%
    Object successfullyAdd = session.getAttribute("successfullyAgreeReturn");
    if (successfullyAdd != null) {
%>
<script type="text/javascript">
    alert("还书成功")
</script>
<% session.removeAttribute("successfullyAgreeReturn");
}%>
<div class="container">
    <div class="card">
        <div class="card-header text-center text-primary">
            <h2>读者还书请求</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>图书ID</th>
                    <th>用户姓名</th>
                    <th>图书名</th>
                    <th>申请时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rtn" items="${returnList}">
                    <tr>
                        <td name="userId">${rtn.userId}</td>
                        <td name="bookId">${rtn.bookId}</td>
                        <td name="userName">${rtn.userName}</td>
                        <td name="bookName">${rtn.bookName}</td>
                        <td name="createTime">${rtn.createTime}</td>
                        <td align="center">
                            <a class="btn"
                               href="/jsp/admin/${rtn.userId}/${rtn.bookId}/${rtn.createTime}/agreeReturnRequest">同意</a>
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