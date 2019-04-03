<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="#">欢迎</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample01"
            aria-controls="navbarsExample01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown00" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">图书管理</a>
                <div class="dropdown-menu" aria-labelledby="dropdown00">
                    <a class="dropdown-item" href="/jsp/admin/searchBook.jsp">图书搜索</a>
                    <a class="dropdown-item" href="/jsp/admin/addBook.jsp">新增图书</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">用户管理</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/jsp/admin/searchUser.jsp">搜索用户</a>
                    <a class="dropdown-item" href="/jsp/admin/addUser.jsp">新增用户</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jsp/admin/reserveRequest">预定列表</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/jsp/admin/returnRequest">还书列表</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">退出登录</a>
            </li>

        </ul>
    </div>
</nav>