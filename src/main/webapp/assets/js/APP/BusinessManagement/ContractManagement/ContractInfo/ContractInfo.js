$(document).ready(function () {


	/*$("#tblContractInfo").datagrid({
        url: "/ContractInfo/QueryByPage",
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
		contractNo,signingDate,contractCost,contractViolate,remarks, customerNo,customerName,contact,address,area,homeType, projectNo,projectManager, shouldDeposit, periodLotNo,shouldFinishTheTask,periodHomeworlkDate,periodMoney,,,,,,,
		{ field: "contractNo", title: "合同编号", width: "10%", align: "center" },
		{ field: "signingDate", title: "签订日期", width: "10%", align: "center" },
		{ field: "contractCost", title: "合同造价", width: "10%", align: "center" },
		{ field: "contractViolate", title: "违约说明", width: "10%", align: "center" },
		{ field: "remarks", title: "备注", width: "10%", align: "center" },

		{ field: "customerNo", title: "客户编号", width: "10%", align: "center" },
		{ field: "customerName", title: "客户姓名", width: "10%", align: "center" },
		{ field: "contact", title: "联系方式", width: "10%", align: "center" },
		{ field: "address", title: "工程地址", width: "10%", align: "center" },
		{ field: "area", title: "工程面积", width: "10%", align: "center" },
		{ field: "homeType", title: "住户类型", width: "10%", align: "center" },

		{ field: "projectNo", title: "工程编号", width: "10%", align: "center" },
		{ field: "projectManager", title: "工程负责人", width: "10%", align: "center" },
		{ field: "projectDepartment", title: "所属部门", width: "10%", align: "center" },

		{ field: "shouldDeposit", title: "量房定金", width: "10%", align: "center" },

		{ field: "periodLotNo", title: "第几期", width: "10%", align: "center" },
		{ field: "shouldFinishTheTask", title: "工程任务", width: "10%", align: "center" },
		{ field: "periodHomeworlkDate", title: "交付时间", width: "10%", align: "center" },
		{ field: "periodMoney", title: "交付金额", width: "10%", align: "center" }

        ]]
    });*/

	$("#tblContractInfo").datagrid({
		url: "/ContractInfo/Query",
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
		           { field: "id", title: "合同id", width: "10%", align: "center" },
		           { field: "contractNo", title: "合同编号", width: "10%", align: "center" },
		           { field: "signingDate", title: "签订日期", width: "10%", align: "center" },
		           { field: "contractCost", title: "合同造价", width: "10%", align: "center" },
		           { field: "privilege", title: "会员等级", width: "10%", align: "center" },
		           { field: "contractViolate", title: "违约说明", width: "10%", align: "center" },
		           { field: " remarks", title: "备注", width: "10%", align: "center" },
		           { field: "state", title: "数据状态", width: "10%", align: "center" },
		           { field: "customsNo", title: "客户编号", width: "10%", align: "center" },
		           { field: "customerName", title: "客户姓名", width: "10%", align: "center" }
		           ]]
	});
	//查询
	$("#btnSearch").on("click", function () {
		var tblContractInfo = $('#tblContractInfo');  
		var options = tblContractInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		var rows = options.pageSize; 
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);contractNo customerName projectNo projectManager
		var contractNo = $("#contractNo").val().trim();
		var customerName = $("#customerName").val().trim();
		var projectNo = $("#projectNo").val().trim();
		var projectManager = $("#projectManager").val().trim();

		$('#tblContractInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			contractNo: contractNo,
			customerName: customerName,
			projectNo: projectNo,
			projectManager: projectManager
		};
		$('#tblContractInfo').datagrid("load");
	})

	$("#newModal").window({
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
        title: "合同信息"
    });
    //打开新增窗口
    $("#AddNew").click(function () {
        $("#addForm").form('reset');
        $("#tblPlusOrMinusInfoTable  tr").eq(1).nextAll().remove();
        $("#newModal").window("open");
    });
	
    //取消新增
    $("#CancelNew").click(function () {
        var $trProductPartsTable1 = $("#tblPlusOrMinusInfoTable thead tr").slice(0, 1);
        var $trProductPartsTable2 = $("#tblPlusOrMinusInfoTable tbody tr").slice(0, 1);
        $("#tblPlusOrMinusInfoTable").children().remove();
        $("#tblPlusOrMinusInfoTable").append($trProductPartsTable1);
        $("#tblPlusOrMinusInfoTable").append($trProductPartsTable2);
        $("#newModal").window("close");
    });
    
  //新增时 在界面增添一条
    $("#newModalAdd").on("click", function () {
        var $table = $("#tblPlusOrMinusInfoTable");
        var id = parseInt($("#newPlusOrMinus").val());
        var item = "<tr>" +    /*txtProjectNo, txtContractNo, txtContractPeriod, txtPlusOrMinusContent, txtPlusOrMinusMoney,txtPlusOrMinusDate, txtCustomerName, txtProjectManager*/
            "<td>" +
            "<input id='txtProjectNo" + id + "' name='list[" + id + "].periodLotNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
            "</td>" +
            "<td>" +
            "<input id='txtContractNo" + id + "' name='list[" + id + "].shouldFinishTheTask' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtContractPeriod" + id + "' name='list[" + id + "].periodHomeworlkDate' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtPlusOrMinusContent" + id + "' name='list[" + id + "].periodMoney' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
            "</td>" +
            	"<td>" +
	            "<input id='txtprojectNo" + id + "' name='list2[" + id + "].projectNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
	            "</td>" +
	            "<td>" +
	            "<input id='txtprojectManager" + id + "' name='list2[" + id + "].projectManager' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
	            "</td>" +
	            "<td>" +
	            "<input id='txtprojectDepartment" + id + "' name='list2[" + id + "].projectDepartment' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
	            "</td>" +
            "</tr>";
        $table.append(item);
        id = id + 1;
        $("#newPlusOrMinus").val(id);
    });

    //新增时 清空第一条目录信息
    $("#btnClearPlusOrMinus").on("click", function () {
    	/*txtProjectNo, txtContractNo, txtContractPeriod, txtPlusOrMinusContent, txtPlusOrMinusMoney,txtPlusOrMinusDate, txtCustomerName, txtProjectManager*/
        $("#txtProjectNo0").val("");
        $("#txtContractNo0").val("");
        $("#txtContractPeriod0").val("");
        $("#txtPlusOrMinusContent0").val("");
        $("#txtPlusOrMinusMoney0").val("");
        $("#txtPlusOrMinusDate0").val("");
    });

    //新增时 在界面删除一条目录信息
    $("#tblPlusOrMinusInfoTable").on("click", ".removePlusOrMinus", function () {
        var tr = $(this).parent().parent();
        tr.remove();
    });
    
	
})