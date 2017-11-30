<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>修改商品信息</title>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
</head>
<body>
	<form id="itemForm" action="/updateItems" method="post" >
		<input type="hidden" name="id" value="${items.id}">
		修改商品信息++：
		<table class="table table-bordered table-hover">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${items.name}"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${items.price}"></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" name="createtime"
					value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd"/>" />
				</td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><c:if test="${itemsCustomer.pic}!=null">
						<img src="/pic/${itemsCustomer.pic}" width="100" height="100">
					</c:if> <input type="file" name="items_pic"></td>
			</tr>

			<tr>
				<td>商品简介</td>
				<td><input type="text" name="detail" value="${items.detail}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"
					class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</body>
</html>
