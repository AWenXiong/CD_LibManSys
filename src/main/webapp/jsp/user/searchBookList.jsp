<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>搜索结果</title>
    <!-- Custom styles for this template -->
    <style type="text/css">
        <%@include file="../../css/searchBook.css.jsp"%>
    </style>
</head>
<body>
<%@include file="userBoard.jsp" %>
<div class="container">
    <div class="card">
        <div class="card-header text-center text-success">
            <h2>搜索结果</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover">
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
                            <a class="btn btn-info" href="/jsp/user/${book.bookId}/bookDetail">查看详情</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>