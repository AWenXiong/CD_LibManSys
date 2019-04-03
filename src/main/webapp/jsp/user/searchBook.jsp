<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="../common/head4.0.jsp" %>

    <title>图书检索</title>

    <!-- Custom styles for this template -->
    <style type="text/css">
        <%@include file="../../css/searchBook.css.jsp"%>
    </style>
</head>

<body>
<%@include file="userBoard.jsp" %>
<div class="text-center h1">
    <h1>图书检索</h1>
    <div class="center-block">
        <form action="/jsp/user/doSearchBook" method="get" class="form-inline my-2 my-md-0">
            <input type="text" placeholder="请输入关键字" name="condition" class="form-control">
            <input class="btn btn-success" type="submit" value="搜索">
        </form>
    </div>
</div>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>