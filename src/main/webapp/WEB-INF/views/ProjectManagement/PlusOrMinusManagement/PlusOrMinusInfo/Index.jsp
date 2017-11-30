<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户基本信息</title>
<link rel="stylesheet" type="text/css" href="/assets/css/easyui.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/right.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/lib.css" />
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/assets/js/menu.js"></script>
<script type="text/javascript" src="/assets/js/easyui-window-fix.js"></script>

<script type="text/javascript" src="/assets/js/form2js.js"></script>
<script type="text/javascript"
	src="/assets/js/APP/ProjectManagement/PlusOrMinusManagement/PlusOrMinusInfo/PlusOrMinusInfoInfo.js"></script>
</head>
<body class="easyui-layout">
	<%@include file="/WEB-INF/Demo.jsp"%>
	<div id="mainPanle" data-options="region:'center'" border="false"> 

		<form action="">
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
							<div class="search_text">合同编号</div>
							<div class="search_input">
								<input type="text" name="textfield" id="contractNo"
									class="input_style input_width input_height">
							</div>
						</div>

						<div class="search_div">
							<div class="search_text">工程编号</div>
							<div class="search_input">
								<input type="text" name="textfield" id="projectNo"
									class="input_style input_width input_height">
							</div>
						</div>

						<div class="search_div">
							<div class="search_text">工程经理</div>
							<div class="search_input">
								<input type="text" name="textfield" id="projectManager"
									class="input_style input_width input_height">
							</div>
						</div>

						<div class="search_div">
							<div class="search_text">客户姓名</div>
							<div class="search_input">
								<input type="text" name="textfield" id="customerName"
									class="input_style input_width input_height">
							</div>
						</div>

						<div class="search_div">
							<div class="search_text">工程地址</div>
							<div class="search_input">
								<input type="text" name="textfield" id="projectAddress"
									class="input_style input_width input_height">
							</div>
						</div>

					</div>
					<div class="tools">
						<ul class="toolbar">
							<li id="AddNew"><a href="#"><span><img
										src="/assets/images/icon/add.png" alt="新增" /></span>新增ssss</a></li>
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
							<input id="reset" name="button" type="button" value="点击重置"
								class="Reset_button" />
							<input id="btnSearch" name="button" type="button" value="点击查询"
								class="buttons" />
						</ul>
						<div class="clearfix"></div>
					</div>

				</div>

			</div>


			<div data-options="region:'center'" border="false"
				class="reginon-margin">
				<table class="easyui-datagrid table" id="tblPlusOrMinusInfo">
					<thead>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
					</thead>
				</table>
			</div>


		</form>

	</div>

	<!----------------------新增窗口---------------------------------->

	<div id="newModal"  >
	 <div class="tip-div" >
			<form id="addForm" action="/PlusOrMinusInfo/AddPlusOrMinus" method="POST" >
			
				<div class="wrap-page common_h2">
					<h2 style="border-top: 0;">增减项信息</h2>
					<div class="input-page table_padding">
						<table class="common_table" id="tblPlusOrMinusInfoTable">
							<thead>
								<tr>
									<th class="text_center"><span class="input-required ">*</span>项目编号</th>
									<th class="text_center"><span class="input-required ">*</span>合同编号</th>
									<th class="text_center"><span class="input-required ">*</span>合同第几期</th>
									<th class="text_center"><span class="input-required ">*</span>增减项说明</th>
									<th class="text_center"><span class="input-required ">*</span>增减项金额</th>
									<th class="text_center"><span class="input-required ">*</span>增减项时间</th>
<!-- 									<th class="text_center"><span class="input-required ">*</span>客户姓名</th>
									<th class="text_center"><span class="input-required ">*</span>工程负责人</th> -->
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input id="txtProjectNo0"
										name="plusOrMinusPoJo[0].projectNo" class="input_style"
										style="width: 100%; height: 100%; text-align: center; border: none" />
									</td>
									<td><input id="txtContractNo0"
										name="plusOrMinusPoJo[0].contractNo" class="input_style"
										style="width: 100%; height: 100%; text-align: center; border: none" />
									</td>
									<td><input id="txtContractPeriod0"
										name="plusOrMinusPoJo[0].contractPeriod" class="input_style"
										style="width: 100%; height: 100%; text-align: center; border: none" />
									</td>
									<td><input id="txtPlusOrMinusContent0"
										name="plusOrMinusPoJo[0].plusOrMinusContent"
										class="input_style"
										style="width: 100%; height: 100%; text-align: center; border: none" />
									</td>
									<td><input id="txtPlusOrMinusMoney0"
										name="plusOrMinusPoJo[0].plusOrMinusMoney"
										class="input_style"
										style="width: 100%; height: 100%; text-align: center; border: none" />
									</td>
									<td><input id="txtPlusOrMinusDate0"
										name="plusOrMinusPoJo[0].plusOrMinusDate"
										class="input_style"
										style="width: 100%; height: 100%; text-align: center; border: none" />
									</td>

									<td><a id="btnClearPlusOrMinus"
										class='button-qx button-bc-width'>清空</a></td>
								</tr>
							</tbody>
						</table>
						<br />
						<div class="text_center">
							<a class="button-qx button-bc-width" id="newModalAdd">增加目录信息</a>
							<input type="hidden" id="newPlusOrMinus" value="1" />
						</div>
					</div>
				</div>

				<div class="wrap-page" style="border-bottom: none;">
					<div class="input-page">
						<div style="text-align: center;">
							<a id="saveNewPlusOrMinus" class="button-bc button-bc-width"><i
								class="fa fa-floppy-o fa-fw"></i>&nbsp;确定保存</a> <a id="CancelNew"
								class="button-qx button-bc-width">取消</a>
						</div>
					</div>
				</div>
				<div class="tip-page">
					<div class="tip-page-info">
						<strong>温馨提示：“<span class="input-required">*</span>”必填项！
						</strong>
					</div>
					<div class="tip_icon">
						<img src="~/images/xiaolian.png" alt="" />
					</div>
				</div>
				<input type="submit" value="提交">
			</form>
		</div>

	</div>
</body>
</html>