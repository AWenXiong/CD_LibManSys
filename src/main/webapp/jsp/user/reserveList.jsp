<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>预定列表</title>
    <!-- custom style -->
    <style type="text/css">
        <%@include file="../../css/searchBook.css.jsp"%>
    </style>
</head>
<body>
<%@include file="userBoard.jsp" %>
<%
    Object flag = session.getAttribute("successfullyReserve");
    if (flag != null) {
%>
<script type="text/javascript">
    alert("预定成功");
</script>
<%
        session.removeAttribute("successfullyReserve");
    }
%>
<%
    Object cancelFlag = session.getAttribute("successfullyCancelReserve");
    if (cancelFlag != null) {
%>
<script type="text/javascript">
    alert("取消预定成功");
</script>
<%
        session.removeAttribute("successfullyCancelReserve");
    }
%>
<div class="container">
    <div class="card text-center">
        <div class="card-header text-success">
            <h2>已预定图书列表</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>图书ID</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>申请时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="reserveItem" items="${bookList}">
                    <tr>
                        <td>${reserveItem.userId}</td>
                        <td>${reserveItem.bookId}</td>
                        <td>${reserveItem.bookName}</td>
                        <td>${reserveItem.bookWriter}</td>
                        <td>${reserveItem.createTime}</td>
                        <td align="center">
                            <a class="btn" href="/jsp/user/${reserveItem.bookId}/bookDetail">书籍详情</a>
                            <a class="btn"
                               href="/jsp/user/${reserveItem.bookId}/${reserveItem.createTime}/doCancelReserve"
                               onclick='return confirm("确定要取消吗？")'>取消预定</a>
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
