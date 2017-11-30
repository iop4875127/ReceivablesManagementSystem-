/**
 * 
 */
$(document).ready(function () {
	/********************************
	 *          初始化界面          *
	 ********************************/
	$("#tblCustomBaseInfo").datagrid({
		url: "/CustomBaseInfo/QueryByPage",
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
		           { field: "customerName", title: "客户名字", width: "45%", align: "center" },
		           { field: "projectNo", title: "工程编号", width: "45%", align: "center" },
		           { field: "id", title: "客户id", width: "45%", align: "center", hidden:true},
		           { field: "sex", title: "客户性别", width: "45%", align: "center", hidden:true },
		           { field: "contact", title: "联系方式", width: "45%", align: "center", hidden:true },
		           { field: "address", title: "地址", width: "45%", align: "center", hidden:true },
		           { field: "area", title: "装修面积", width: "45%", align: "center", hidden:true },
		           { field: "homeType", title: "房屋类型", width: "45%", align: "center", hidden:true },
		           { field: "state", title: "数据状态", width: "45%", align: "center", hidden:true },
		           { field: "customerNo", title: "客户编号", width: "45%", align: "center", hidden:true },
		           { field: "privileges", title: "会员等级", width: "45%", align: "center", hidden:true }
		           ]]
	});
	//查询客户信息
	//====================================================================
	/*$("#btnSearch").on("click", function () {
		var tblCustomBaseInfo = $('#tblCustomBaseInfo');  
		var options = tblCustomBaseInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);
		var customName = $("#customName").val();
		var projectNo = $("#projectNo").val();
		var privileges = $("#privileges").val();  
		var rows = options.pageSize;  
		$.ajax( {    
			         type : "POST",  //定义方法类型（get，post）  
			         url : "/CustomBaseInfo/QueryByPage",  //对应后台的访问地址：URL  
			         data : {  
				          	page:page,  
				            rows:rows,
							customerName: customName,
							projectNo: projectNo,
							privileges: privileges  
				         },  //往后台传送的参数  
				         dataType : "json",//传参数的类型  
				         success : function(data) {  
					                if(data){  
						                    if(data.flag){  
							                        $.messager.alert('提示', data.msg, 'info', function(){  
								                            $('#t_student').datagrid('reload');  
								                        });  
								                    }else{  
									                        $.messager.alert('提示',data.msg, 'error');  
									                    }  
									                }  
									            },  
									            error : function(data) {  
										                $.messager.alert('警告',"导入Excel数据失败，请检查网络！", 'error');  
										            }  
										        });  
		})
		
	});*/
	//====================================================================
	$("#btnSearch").on("click", function () {
		var tblCustomBaseInfo = $('#tblCustomBaseInfo');  
		var options = tblCustomBaseInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);
		var customName = $("#customName").val().trim();
		var projectNo = $("#projectNo").val().trim();
		var privileges = $("#privileges").val().trim(); 
		var rows = options.pageSize; 

		$('#tblCustomBaseInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			customerName: customName,
			projectNo: projectNo,
			privileges: privileges};
		$('#tblCustomBaseInfo').datagrid("load");
	})
	//====================================================================


});

