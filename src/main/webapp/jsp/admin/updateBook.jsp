<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head4.0.jsp" %>
    <title>更新图书信息</title>
    <!-- dashboard style -->
    <style type="text/css">
        <%@include file="../../css/adminDashBoard.css.jsp"%>
    </style>
</head>
<body>
<%@include file="adminBoard.jsp" %>
<!-- 提示脚本 -->
<%
    Object successfullyAdd = session.getAttribute("successfullyUpdateBook");
    if (successfullyAdd != null) {
%>
<script type="text/javascript">
    alert("更新书籍信息成功")
</script>
<% session.removeAttribute("successfullyUpdateBook");
}%>
<div>
    <form class="form-horizontal" action="doUpdateBook" method="post">
        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="bookId">图书Id：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="bookId" name="bookId"
                       value="<%=session.getAttribute("specialBookId")%>">
            </div>
        </div>

        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="bookName">图书名：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="bookName" name="bookName"
                       value="<%=session.getAttribute("specialBookName")%>">
            </div>
        </div>

        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="totalBook">馆藏数量：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="totalBook" name="totalBook"
                       value="<%=session.getAttribute("specialBookTotal")%>">
            </div>
        </div>

        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="stockBook">在馆数量：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="stockBook" name="stockBook"
                       value="<%=session.getAttribute("specialBookStock")%>">
            </div>
        </div>

        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="writer">作者：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="writer" name="bookWriter"
                       value="<%=session.getAttribute("specialBookWriter")%>">
            </div>
        </div>

        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="press">出版社：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="press" name="bookPress"
                       value="<%=session.getAttribute("specialBookPress")%>">
            </div>
        </div>

        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label" for="bookType">图书类型：</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" id="bookType" name="bookType"
                       value="<%=session.getAttribute("specialBookType")%>">
            </div>
        </div>

        <input class="btn btn-success" type="submit" value="保存">
    </form>
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
