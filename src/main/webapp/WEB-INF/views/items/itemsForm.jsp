<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/24
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息提交</title>
    <link rel="stylesheet" type="text/css" href="asset/css/bootstrap.css">
</head>
<body>
<form action="/insertItems" method="post">
    <table class="table table-bordered">
    <tr>
        <td>商品名称</td>
        <td><input type="text" name="name" ></td>
    </tr>
    <tr>
        <td>商品价格</td>
        <td><input type="text" name="price" ></td>
    </tr>
    <tr>
        <td>商品简介</td>
        <td><input type="text" name="detail" ></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="提交" class="btn btn-primary">
        </td>
    </tr>
    </table>
</form>
</body>
</html>
