<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>增加图书</title>

    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp"%>
    </style>

</head>
<body>
<!-- 导入导航栏 -->
<%@include file="adminBoard.jsp" %>
<!-- 提示脚本 -->
<%
    Object successfullyAdd = session.getAttribute("successfullyAddBook");
    if (successfullyAdd != null) {
%>
<script type="text/javascript">
    alert("新增图书成功")
</script>
<% session.removeAttribute("successfullyAddBook");
}%>
<!-- 界面表单 每个div是一个输入框 -->
<form class="form-horizontal" action="doAddBook" method="post">
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="bookName">图书名：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="bookName" name="bookName">
        </div>
    </div>

    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="writer">作者：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="writer" name="bookWriter">
        </div>
    </div>

    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="totalBook">馆藏数量：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="totalBook" name="totalBook">
        </div>
    </div>

    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="bookType">图书类型：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="bookType" name="bookType">
        </div>
    </div>

    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="press">出版社：</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="press" name="bookPress">
        </div>
    </div>

    <input class="btn btn-success" type="submit" value="提交">
</form>
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
