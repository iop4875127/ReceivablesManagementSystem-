/**
 * 
 */
$(document).ready(function () {
	/********************************
	 *          初始化界面          *
	 ********************************/
	$("#tblCkeckMoneyInfo").datagrid({
		url: "/CheckMoneyInfo/QueryByPage",
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
		           { field: "contractNo", title: "合同编号", width: "20%", align: "center" },
		           { field: "projectNo", title: "工程编号", width: "20%", align: "center" },
		           { field: "cost", title: "支出", width: "20%", align: "center"},
		           { field: "receipt", title: "进账", width: "20%", align: "center" },
		           { field: "hasMoney", title: "利润", width: "20%", align: "center" }
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
		var tblReceiptInfo = $('#tblReceiptInfo');  
		var options = tblReceiptInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);
		var payName = $("#payName").val().trim();
		var projectNo = $("#projectNo").val().trim();
		var rows = options.pageSize; 

		$('#tblReceiptInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			payName: payName,
			projectNo: projectNo};
		$('#tblReceiptInfo').datagrid("load");
	})
	//====================================================================


});

