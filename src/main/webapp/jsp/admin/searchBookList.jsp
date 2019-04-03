<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>管理员搜索图书列表页</title>
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
            <h2>搜索结果</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>图书名</th>
                    <th>作者</th>
                    <th>类型</th>
                    <th>出版社</th>
                    <th>馆藏数量</th>
                    <th>在馆数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.bookName}</td>
                        <td>${book.bookWriter}</td>
                        <td>${book.bookType}</td>
                        <td>${book.bookPress}</td>
                        <td>${book.bookTotal}</td>
                        <td>${book.bookStock}</td>
                        <td align="center">
                            <a class="btn" href="/jsp/admin/${book.bookId}/bookDetail">查看详情</a>
                            <a class="btn" href="/jsp/admin/${book.bookId}/doDeleteBook"
                               onclick='return confirm("确定要删除此条目吗？")'>删除</a>
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