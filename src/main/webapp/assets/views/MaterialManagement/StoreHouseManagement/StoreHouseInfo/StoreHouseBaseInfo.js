$(document).ready(function () {
	
	
	$("#tblStoreHouseInfo").datagrid({
        url: "/StoreHouseInfo/QueryByPage",
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
		{ field: "id", title: "物料ID", width: "15%", align: "center", hidden:true },
		{ field: "materialNo", title: "物料编号", width: "15%", align: "center" },
        { field: "materialName", title: "物料名称", width: "15%", align: "center" },
        { field: "materialPrice", title: "单价", width: "15%", align: "center"},
        { field: "materialParams", title: "各项参数", width: "15%", align: "center" },
        { field: "state", title: "数据状态", width: "15%", align: "center", hidden:true },
        { field: "priority", title: "紧急状态", width: "15%", align: "center" },
        { field: "materialParts", title: "配件", width: "15%", align: "center" }
        ]]
    });
	
})