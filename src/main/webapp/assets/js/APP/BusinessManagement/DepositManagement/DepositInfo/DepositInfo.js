$(document).ready(function () {
	
	
	$("#tblDepositInfo").datagrid({
        url: "/DepositInfo/QueryByPage",
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
		{ field: "customerNo", title: "客户编号", width: "15%", align: "center" },
		{ field: "customerName", title: "客户姓名", width: "15%", align: "center" },
        { field: "shouldDeposit", title: "应收量房定金", width: "15%", align: "center" },
        { field: "area", title: "面积", width: "15%", align: "center", hidden:true},
        { field: "realityDeposit", title: "实收量房定金", width: "15%", align: "center" },
        { field: "privileges", title: "会员等级", width: "15%", align: "center" },
        { field: "remarks", title: "备注", width: "15%", align: "center" },
        { field: "id", title: "量房id", width: "15%", align: "center", hidden:true },
        { field: "state", title: "数据状态", width: "15%", align: "center" , hidden:true},
        ]]
    });
	
	$("#btnSearch").on("click", function () {
		var tblDepositInfo = $('#tblDepositInfo');  
		var options = tblDepositInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		var rows = options.pageSize; 
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);
		var area = $("#area").val().trim();
		var homeType = $("#homeType").val().trim();
		var realityDeposit = $("#realityDeposit").val().trim();
		var privileges = $("#privileges").val().trim();
		 

		$('#tblDepositInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			area: area,
			homeType: homeType,
			realityDeposit: realityDeposit,
			privileges: privileges			
		};
		$('#tblDepositInfo').datagrid("load");
	})
	
})