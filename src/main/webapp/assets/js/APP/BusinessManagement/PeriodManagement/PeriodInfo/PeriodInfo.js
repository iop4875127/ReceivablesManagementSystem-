$(document).ready(function () {


	$("#tblPeriodInfo").datagrid({
		url: "/PeriodInfo/QueryByPage",
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
		           { field: "periodLotNo", title: "第几期", width: "15%", align: "center" },
		           { field: "shouldFinishTheTask", title: "分期任务量", width: "15%", align: "center" },
		           { field: "periodHomeworlkDate", title: "分期工程应完成时间", width: "15%", align: "center" },
		           { field: "periodMoney", title: "期款", width: "15%", align: "center" },
		           { field: "periodPayableDate", title: "期款最迟上交时间", width: "15%", align: "center", hidden:true},
		           { field: "state", title: "数据状态", width: "15%", align: "center" , hidden:true},
		           { field: "realityFinishTheTask", title: "工程进度描述", width: "15%", align: "center" },
		           { field: "periodPayRealityDate", title: "期款收款时间", width: "15%", align: "center" },
		           { field: "contractNo", title: "合同编号", width: "15%", align: "center" },
		           { field: "id", title: "分期ID", width: "15%", align: "center", hidden:true }
		           ]]
	});
//查询
	$("#btnSearch").on("click", function () {
		var tblPeriodInfo = $('#tblPeriodInfo');  
		var options = tblPeriodInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		var rows = options.pageSize; 
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);
		var periodLotNo = $("#periodLotNo").val().trim();
		var contractNo = $("#contractNo").val().trim();

		$('#tblPeriodInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			periodLotNo: periodLotNo,
			contractNo: contractNo
			};
		$('#tblPeriodInfo').datagrid("load");
	})
	
})