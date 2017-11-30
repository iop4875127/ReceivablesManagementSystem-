<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	显示所查询的信息

	<input type="hidden" name="id" value="${itemsCustomer.id}">
	显示商品信息：
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
				value="${items.createtime}" /></td>
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

	</table>
	<form id="itemForm" action="/queryItems" method="post">
		<td colspan="2" align="center"><input type="submit" value="提交"
			class="btn btn-primary"></td>
	</form>
</body>
</html>