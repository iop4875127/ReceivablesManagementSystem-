$(document).ready(function () {
	
	
	$("#tblEmployeeInfo").datagrid({
        url: "/EmployeeInfo/QueryByPage",
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
		{ field: "id", title: "职员ID", width: "25%", align: "center", hidden:true },
		{ field: "employeeNo", title: "职员编号", width: "25%", align: "center" },
        { field: "name", title: "姓名", width: "25%", align: "center" },
        { field: "sex", title: "性别", width: "25%", align: "center", hidden:true},
        { field: "age", title: "年龄", width: "25%", align: "center" , hidden:true},
        { field: "nation", title: "名族", width: "25%", align: "center" , hidden:true},
        { field: "contact", title: "联系方式", width: "25%", align: "center" , hidden:true},
        { field: "address", title: "住址", width: "25%", align: "center", hidden:true },
        { field: "department", title: "部门", width: "25%", align: "center" },
        { field: "position", title: "职位", width: "25%", align: "center" },
        { field: "state", title: "数据状态", width: "25%", align: "center" , hidden:true},
        { field: "idCard", title: "身份证", width: "25%", align: "center" , hidden:true}
        ]]
    });
	
//	查询
	$("#btnSearch").on("click", function () {
		var tblEmployeeInfo = $('#tblEmployeeInfo');  
		var options = tblEmployeeInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);
		var name = $("#name").val().trim();
		var department = $("#department").val().trim();
		var position = $("#position").val().trim();
		var employeeNo = $("#employeeNo").val().trim();
		var rows = options.pageSize; 

		$('#tblEmployeeInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			name: name,
			department: department,
			position: position,
			employeeNo: employeeNo
			};
		$('#tblEmployeeInfo').datagrid("load");
	})

	
})