<%@ page import="org.library.entity.borrowBook" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>已借阅书籍</title>
    <!-- Custom style -->
    <style type="text/css">
        <%@include file="../../css/searchBook.css.jsp"%>
    </style>
</head>
<body>
<%@include file="userBoard.jsp" %>
<%
    Object cancelFlag = session.getAttribute("successfullyReturn");
    if (cancelFlag != null) {
%>
<script type="text/javascript">
    alert("申请还书成功");
</script>
<%
        session.removeAttribute("successfullyReturn");
    }
%>
<div class="container">
    <div class="card">
        <div class="card-header text-center text-success">
            <h2>借阅查询</h2>
        </div>
        <div class="card-body">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>借书时间</th>
                    <th>还书时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="borrowItem" items="${bookList}">
                    <tr>
                        <td name="bookID">${borrowItem.bookId}</td>
                        <td name="bookName">${borrowItem.bookName}</td>
                        <td name="bookWriter">${borrowItem.bookWriter}</td>
                        <td name="borrowTime">${borrowItem.borrowTime}</td>
                        <td name="returnTime">${borrowItem.returnTime}</td>
                        <td align="center">
                            <a class="btn" href="/jsp/user/${borrowItem.bookId}/bookDetail">书籍详情</a>
                            <a class="btn" href="/jsp/user/${borrowItem.bookId}/${borrowItem.borrowTime}/doReturnBook"
                               onclick='return confirm("确定要还书吗？")'>申请还书</a>
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
