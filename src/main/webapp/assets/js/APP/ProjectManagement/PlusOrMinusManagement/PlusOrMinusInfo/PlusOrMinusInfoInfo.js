$(document).ready(function () {


	$("#tblPlusOrMinusInfo").datagrid({
		url: "/PlusOrMinusInfo/QueryByPage",
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
		           { field: "id", title: "增减项编号", width: "15%", align: "center", hidden:true },
		           { field: "projectNo", title: "工程编号", width: "15%", align: "center" },
		           { field: "contractNo", title: "合同编号", width: "15%", align: "center" },
		           { field: "contractPeriod", title: "第几期", width: "15%", align: "center" },
		           { field: "plusOrMinusContent", title: "增减项说明", width: "15%", align: "center" },
		           { field: "plusOrMinusMoney", title: "增减项金额", width: "15%", align: "center" },
		           { field: "state", title: "数据状态", width: "15%", align: "center" },
		           { field: "plusOrMinusDate", title: "增减项时间", width: "15%", align: "center" },
		           { field: "customerName", title: "客户姓名", width: "15%", align: "center" },
		           { field: "projectManager", title: "工程负责人ss", width: "15%", align: "center" }
		           ]]
	});

//	查询
	$("#btnSearch").on("click", function () {
		var tblPlusOrMinusInfo = $('#tblPlusOrMinusInfo');  
		var options = tblPlusOrMinusInfo.datagrid('getPager').data("pagination").options;  
		var page = options.pageNumber;  
		var rows = options.pageSize; 
		//var total = options.total;  
		//var max = Math.ceil(total/options.pageSize);contractNo, projectNo, projectManager, customerName, projectAddress
		var contractNo = $("#contractNo").val().trim();
		var projectNo = $("#projectNo").val().trim();
		var projectManager = $("#projectManager").val().trim();
		var customerName = $("#customerName").val().trim();
		var projectAddress = $("#projectAddress").val().trim();

		$('#tblPlusOrMinusInfo').datagrid("options").queryParams = {	
			page:page,  
			rows:rows,
			contractNo: contractNo,
			projectNo: projectNo,
			projectManager: projectManager,
			customerName: customerName,
			projectAddress: projectAddress
			};
		$('#tblPlusOrMinusInfo').datagrid("load");
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
        title: "增减项信息"
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
            "<input id='txtProjectNo" + id + "' name='plusOrMinusPoJo[" + id + "].projectNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
            "</td>" +
            "<td>" +
            "<input id='txtContractNo" + id + "' name='plusOrMinusPoJo[" + id + "].contractNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtContractPeriod" + id + "' name='plusOrMinusPoJo[" + id + "].contractPeriod' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtPlusOrMinusContent" + id + "' name='plusOrMinusPoJo[" + id + "].plusOrMinusContent' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
            "</td>" +
            "<td>" +
            "<input id='txtPlusOrMinusMoney" + id + "' name='plusOrMinusPoJo[" + id + "].plusOrMinusMoney' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtPlusOrMinusDate" + id + "' name='plusOrMinusPoJo[" + id + "].plusOrMinusDate' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +     
            /*"<td>" +
            "<input id='txtCustomerName" + id + "' name='plusOrMinusPoJo.plusOrMinus[" + id + "].CustomerName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtProjectManager" + id + "' name='plusOrMinusPoJo.plusOrMinus[" + id + "].ProjectManager' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +*/
            "<td>" +
            "<a class='button-qx button-bc-width removePlusOrMinus'>移除</a>" +
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
//        $("#txtCustomerName0").val("");
//        $("#txtProjectManager0").val("");
    });

    //新增时 在界面删除一条目录信息
    $("#tblPlusOrMinusInfoTable").on("click", ".removePlusOrMinus", function () {
        var tr = $(this).parent().parent();
        tr.remove();
    });
    
/*  //保存新增
    $("#saveNewPlusOrMinus").on("click", function () {
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
        console.log(data);
        $.ajax({
            url: "/PlusOrMinusInfo/AddPlusOrMinus",
            method: "post",
            data: data,
            dataType: "json",
            success : function(data) {  
                if(data.success){  
                    alert("设置成功！");  
                    $("#newModal").window("close");
                    $("#tblPlusOrMinusInfo").datagrid("gotoPage", 1);
                }  
                else{  
                    alert("设置失败！");  
                }  
            }
        }).done(function (result) {
            if (result.success) {
                $("#newModal").window("close");
                $("#tblPlusOrMinusInfo").datagrid("gotoPage", 1);
            }
        })
    });
*/
    
})