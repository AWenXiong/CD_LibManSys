<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">欢迎</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/jsp/user/searchBook.jsp">图书查询<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jsp/user/borrowList">已借阅图书</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jsp/user/reserveList">已预约图书</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">退出登录</a>
            </li>
        </ul>
    </div>
</nav>