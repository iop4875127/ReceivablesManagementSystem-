$(document).ready(function () {


	$("#tblProjectInfo").datagrid({
		url: "/ProjectInfo/QueryByPage",
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
		           { field: "id", title: "工程编号", width: "15%", align: "center", hidden:true },
		           { field: "projectNo", title: "工程编号", width: "15%", align: "center" },
		           { field: "projectManager", title: "工程负责人", width: "15%", align: "center" },
		           { field: "projectDepartment", title: "所属部门", width: "15%", align: "center" },
		           { field: "state", title: "数据状态", width: "15%", align: "center" , hidden:true},
		           { field: "completeDate", title: "工程规定时间", width: "15%", align: "center" },
		           { field: "completionDate", title: "工程竣工时间", width: "15%", align: "center", hidden:true},
		           { field: "contractNo", title: "合同编号", width: "15%", align: "center" },
		           { field: "commission", title: "佣金提成", width: "15%", align: "center" },
		           { field: "projectAddress", title: "工程地址", width: "15%", align: "center" },
		           { field: "contractPeriod", title: "合同第几期", width: "15%", align: "center" }
		           ]]
	});
	
//	查询
	$("#btnSearch").on("click", function () {
		var tblProjectInfo = $('#tblProjectInfo');  
		var options = tblProjectInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		var rows = options.pageSize; 
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);contractNo, projectNo, projectManager, customerName, projectAddress
		var contractNo = $("#contractNo").val().trim();
		var projectNo = $("#projectNo").val().trim();
		var projectManager = $("#projectManager").val().trim();
		var customerName = $("#customerName").val().trim();
		var projectAddress = $("#projectAddress").val().trim();

		$('#tblProjectInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			contractNo: contractNo,
			projectNo: projectNo,
			projectManager: projectManager,
			customerName: customerName,
			projectAddress: projectAddress
			};
		$('#tblProjectInfo').datagrid("load");
	})


})