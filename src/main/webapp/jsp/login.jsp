<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="common/head.jsp" %>

    <title>图书系统登录</title>
    <!-- Custom styles for this template -->
    <style type="text/css">
        <%@include file="../css/login.css.jsp"%>
    </style>
</head>

<body class="text-center">
<%
    Object flag = session.getAttribute("loginResult");
    if (flag != null) {
%>
<script type="text/javascript">
    alert("用户名或密码错误");
</script>
<%
        session.removeAttribute("loginResult");
    }
%>
<form class="form-signin" action="/doLogin" method="post">
    <h1 class="h1 mb-3 font-weight-normal">请登陆</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="用户名" name="userName" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password" required>
    <button class="btn btn-lg btn-primary btn-block input-lg" type="submit">登陆</button>
    <a class="hyperlink" href="/jsp/esterEgg.jsp">忘记密码</a>
</form>
</body>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
