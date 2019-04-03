<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>用户书籍详情页</title>
    <!-- custom style -->
    <style type="text/css">
        <%@include file="../../css/searchBook.css.jsp" %>
    </style>
</head>
<body>
<%@include file="userBoard.jsp" %>
<div class="container">
    <div class="card text-center">
        <div class="card-header text-success">
            <h2>图书详情</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>类型</th>
                    <th>馆藏数量</th>
                    <th>在馆数量</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${book.bookName}</td>
                    <td>${book.bookWriter}</td>
                    <td>${book.bookPress}</td>
                    <td>${book.bookType}</td>
                    <td>${book.bookTotal}</td>
                    <td>${book.bookStock}</td>
                    <td align="center">
                        <a class="btn" href="/jsp/user/doReserve" onclick='return confirm("确定要借书吗？")'
                           style="border-radius:4px">申请借书</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
