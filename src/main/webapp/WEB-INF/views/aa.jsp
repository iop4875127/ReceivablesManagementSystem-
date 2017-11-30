
 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户基本信息</title>
<link rel="stylesheet" type="text/css" href="/assets/css/easyui.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/right.css" />

<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/assets/js/menu.js"></script>
<script type="text/javascript" src="/assets/js/CustomBaseInfo.js"></script>
<script type="text/javascript" src="/assets/js/easyui-window-fix.js"></script>
<script type="text/javascript"
	src="/assets/js/APP/CustomerServiceManagement/CustomInfo/CustomBaseInfo/CustomBaseInfo.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/Demo.jsp"%>
	<div id="mainPanle"  data-options="region:'center'" border="false">
		
			<div id="cc" data-options="region:'north'" border="false"
				class="search">
				<div class="search-page">
					<!--搜索区域-->
					<div class="warp-from">

						<div class="search_div">
							<div class="search_text">禁止修改</div>
							<div class="search_input">
								<input type="text" name="textfield" value="16101703"
									id="textfield" class="bottom_style input_width input_height"
									disabled>
							</div>
						</div>
						<div class="clearfix"></div>
						<!--搜索分区线 start-->
						<div class="input-page search_line"></div>
						<!--搜索分区线 end-->
						<div class="search_div">
							<div class="search_text">客户姓名</div>
							<div class="search_input">
								<input type="text" name="textfield" id="textfield"
									class="input_style input_width input_height">
							</div>
						</div>

						<div class="search_div">
							<div class="search_text">工程编号</div>
							<div class="search_input">
								<input type="text" name="textfield" id="textfield"
									class="input_style input_width input_height">
							</div>
						</div>

						<div class="search_div">
							<div class="search_text">工程负责人</div>
							<div class="search_input">
								<input type="text" name="textfield" id="textfield"
									class="input_style input_width input_height">
							</div>
						</div>

					</div>
					<div class="tools">
						<ul class="toolbar">
							<li id="AddNew"><a href="#"><span><img
										src="/assets/images/icon/add.png" alt="新s增" /></span>新增ssss</a></li>
							<li id="View"><a href="#"><span><img
										src="/assets/images/icon/search.png" alt="查看" /></span>查看</a></li>
							<li id="Edit"><a href="#"><span><img
										src="/assets/images/icon/edit.png" alt="修改" /></span>修改</a></li>
							<li id="Delete"><a href="#"><span><img
										src="/assets/images/icon/delete.png" alt="删除" /></span>删除</a></li>
							<li id="ExportExcel"><a href="#"><span><img
										src="/assets/images/icon/export.png" alt="导出excel" /></span>导出excel</a></li>
						</ul>

						<ul class="toolbar1">
							<input name="button" type="button" value="点击重置"
								class="Reset_button" />
							<input name="button" type="button" value="点击查询" class="buttons" />
						</ul>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div style="height: 98%;width: 90%; background: red" >
		dsafafdas
		<div data-options="region:'center'" border="false" >
				<table class="easyui-datagrid" id="tblCustomBaseInfo" >
				</table>
		</div> 
		</div>
	</div>
	<!-- 新增窗口 -->
</body>
</html>