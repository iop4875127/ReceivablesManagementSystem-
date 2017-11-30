/**
 * 
 */
$(document).ready(function () {
	/********************************
     *          初始化界面          *
     ********************************/

    //初始化主界面表格
    /*$("#tblComponentAssembly").datagrid({
        url: "/ComponentAssemblySettings/Query",
        nowrap: true,
        striped: true,
        border: false,
        collapsible: false,   //是否可折叠  
        fit: true,            //自动大小  
        fitColumns: true,
        remoteSort: false,
        singleSelect: true,   //是否单选  
        pagination: true,     //分页控件  
        rownumbers: true,    //行号  
        pageNumber: 1,        //默认显示第几页   
        pageSize: 10,
        pageList: [10, 20, 30],
        columns: [[

        { field: "ProductName", title: "产品名称", width: "45%", align: "center" },
        { field: "ProductModel", title: "型号", width: "45%", align: "center" }
        ]]
    });*/
    
	/************新增部分**************/
	//创建新增窗口
	/*$("#newModal").window({
		height: 500,
		width: 750,
		top: ($(window).height() - 500) * 0.5,
		left: ($(window).width() - 750) * 0.5,
		modal: true,
		closed: true,
		minimizable: false,
		collapsible: false,
		maximizable: false,
		draggable: true,
		resizable: false,
		title: "组件装配设置"
	});*/
	//打开新增窗口AddNew
	/*$("#AddNew").click(function () {
		$("#addForm").form('reset');
		$("#tblNewComponentPartsTable  tr").eq(1).nextAll().remove();
		$("#newModal").removeAttr("hidden"); 
		$("#newModal").window("open");
	});
	//取消新增
	$("#CancelNew").click(function () {
		var $trProductPartsTable1 = $("#tblNewComponentPartsTable thead tr").slice(0, 1);
		var $trProductPartsTable2 = $("#tblNewComponentPartsTable tbody tr").slice(0, 1);
		$("#tblNewComponentPartsTable").children().remove();
		$("#tblNewComponentPartsTable").append($trProductPartsTable1);
		$("#tblNewComponentPartsTable").append($trProductPartsTable2);
		$("#newModal").window("close");
	});

	//新增时 在界面增添一条
	$("#newModalAddComponentPart").on("click", function () {
		var $table = $("#tblNewComponentPartsTable");
		var id = parseInt($("#newComponentPartItems").val());
		var item = "<tr>" +
		"<td>" +
		"<input id='txtNewComponentpartPartName" + id + "' name='ComponentParts[" + id + "].PartName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
		"</td>" +
		"<td>" +
		"<input id='txtNewComponentPartPartDrawingNumber" + id + "' name='ComponentParts[" + id + "].PartDrawingNumber' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
		"</td>" +
		"<td>" +
		"<input id='txtNewComponentPartPartsQuantity" + id + "' name='ComponentParts[" + id + "].PartsQuantity' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
		"</td>" +
		"<td>" +
		"<a class='button-qx button-bc-width removeComponentPart'>移除</a>" +
		"</td>" +
		"</tr>";
		$table.append(item);
		id = id + 1;
		$("#newComponentPartItems").val(id);
	});

	//新增时 清空第一条目录信息
	$("#btnNewClearComponentPart").on("click", function () {
		$("#txtNewComponentPartPartName0").val("");
		$("#txtNewComponentPartPartDrawingNumber0").val("");
		$("#txtNewComponentPartPartsQuantity0").val("");
	});

	//新增时 在界面删除一条目录信息
	$("#tblNewComponentPartsTable").on("click", ".removeComponentPart", function () {
		var tr = $(this).parent().parent();
		tr.remove();
	});

	//保存新增
	$("#saveNewComponentAssembly").on("click", function () {
		//$("#txtNewIsOut").val("2");
		if (!$("#addForm").valid()) {
			$.messager.alert({
				title: "操作提示",
				msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请正确填写完毕再保存</div>",
				icon: "error"
			});
			return;
		}
		var data = form2js($("#addForm").get(0), ".", true);
		$.ajax({
			url: "/ComponentAssemblySettings/AddComponentAssembly",
			method: "post",
			data: data,
			dataType: "json"
		}).done(function (result) {
			if (result.Success) {
				$("#newModal").window("close");
				$("#tblComponentAssembly").datagrid("gotoPage", 1);
			}
		});
	});*/


});