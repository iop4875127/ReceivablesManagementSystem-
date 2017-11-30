$(document).ready(function () {
    /************界面表格数据显示**************/

    //初始化
    $("#tblPartDetection").datagrid({
        url: "/PartSizeDetection/Query",
        nowrap: false,
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
        { field: "Id", title: "零件尺寸ID", hidden: true },
        { field: "PartDetectionState", title: "检测状态", width: "12%", align: "center" },
        { field: "PartLot", title: "零件批号", width: "12%", align: "center" },
        { field: "ProductSerialNumber", title: "产品序号", width: "12%", align: "center" },
        { field: "AssemblyFormula", title: "装配公式", width: "0%", hidden: true },
        { field: "AssemblyFactor", title: "装配系数", width: "0%", hidden: true },
        { field: "CoreLength", title: "电磁铁深度/铁芯长度L", width: "12%", align: "center" },
        { field: "CoreHeight", title: "铁芯高度h", width: "12%", align: "center" },
        { field: "CoreDeepHole", title: "铁芯盲孔深H", width: "12%", align: "center" },
        { field: "MatchLimit", title: "压簧选配", width: "12%", align: "center" },
        { field: "AssemblyDimensions", title: "装配尺寸", width: "12%", align: "center" },
        { field: "BlockSize", title: "校块尺寸", width: "12%", align: "center" }

        ]]
    });

    /************导出Excel**************/
    $("#ExportExcel").on("click", function () {
        var companyName = $("#queryCompanyName").val().trim();
        var department = $("#queryDepartment").val().trim();
        var userNo = $("#queryUserNo").val().trim();
        var type = $("#queryType option:selected").attr("value");

        var url = "/TwoPassDetection/DownLoadTwoPassDetectionExcel?CompanyName=" + companyName + "&Department=" + department + "&UserNo=" + userNo + "&Type=" + type;
        window.location = url;
    });

    /************编辑部分**************/
    //创建编辑窗口
    $("#editPartDetectiveModal").window({
        height: 460,
        width: 650,
        top: ($(window).height() - 460) * 0.4,
        left: ($(window).width() - 650) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        resizable: false,
        title: "零件尺寸检测"
    });


    //1.js2form
    //$("#form")JQurey取到该元素，[0]是得到dom对象，data传给前台
    //js2form($("#form")[0],data);
    //2.form2js
    //点前面的是一个对象，点前也可以是数组，这样就可以在控制器哪里直接list接受
    //form2js($("#form")[0],".",true);

    //打开编辑窗口
    $("#Edit").on("click", function () {
        var operatetr = $("#tblPartDetection").datagrid("getSelected");
        //js2form($("#editPartDetectiveForm")[0], operatetr);
        var id = operatetr.Id;
        var partDetectionStatus = operatetr.PartDetectionState;
        var partDetectionState = operatetr.PartDetectionState;
        var partLot = operatetr.PartLot;
        var productSerialNumber = operatetr.ProductSerialNumber;
        var assemblyFormula = operatetr.AssemblyFormula;
        var assemblyFactor = operatetr.AssemblyFactor;
        var coreLength = operatetr.CoreLength;
        var coreHeight = operatetr.CoreHeight;
        var coreDeepHole = operatetr.CoreDeepHole;
        var matchLowerLimit = operatetr.MatchLowerLimit;
        var matchUpperLimit = operatetr.MatchUpperLimit;
        var matchLimit = operatetr.MatchLimit;
        var assemblyDimensions = operatetr.AssemblyDimensions;
        var blockSize = operatetr.BlockSize;

        $("#txtEditId").val(id);
        $("#txtEditPartDetectionStatus").val(partDetectionStatus);
        $("#txtEditPartDetectionState").val(partDetectionState);
        $("#txtEditPartLot").val(partLot);
        $("#txtEditProductSerialNumber").val(productSerialNumber);
        $("#txtEditAssemblyFormula").val(assemblyFormula);
        $("#txtEditAssemblyFactor").val(assemblyFactor);
        $("#txtEditCoreLength").val(coreLength);
        $("#txtEditCoreHeight").val(coreHeight);
        $("#txtEditCoreDeepHole").val(coreDeepHole);
        $("#txtEditMatchLowerLimit").val(matchLowerLimit);
        $("#txtEditMatchUpperLimit").val(matchUpperLimit);
        $("#txtEditMatchLimit").val(matchLimit);
        $("#txtEditAssemblyDimensions").val(assemblyDimensions);
        $("#txtEditBlockSize").val(blockSize);
        document.getElementById("txtEditBlockSize").readOnly = true;

        $("#editPartDetectiveModal").window("open");
    });
    //取消编辑
    $("#cancelEdit").click(function () {
        $("#editPartDetectiveModal").window("close");

    });

    //保存编辑
    $("#saveEdit").on("click", function () {
        if (!$("#editPartDetectiveForm").valid()) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请正确填写完毕再保存</div>",
                icon: "error"
            });
            return;
        }
        
        $.ajax({
            url: "/PartSizeDetection/UpdatePartDetective",
            method: "post",
            data: $('#editPartDetectiveForm').serialize(),// 序列化表单值  
            async: false,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#editPartDetectiveModal").window("close");
                $("#tblPartDetection").datagrid("gotoPage", 1);
            }
        });
    });


    //查询
    $("#btnSearch").on("click", function () {
        var partDetectionState = $("#queryTrainingOrientation").val();
        var partLot = $("#txtSearchPartLot").val();
        var productSerialNumber = $("#txtSearchProductSerialNumber").val();


        $("#tblPartDetection").datagrid("options").queryParams =
        {
            partDetectionState: partDetectionState,
            partLot: partLot,
            productSerialNumber: productSerialNumber
        };
        $("#tblPartDetection").datagrid("gotoPage", 1);


        //$("#tblPartDetection").datagrid("load", {
        //    partDetectionState: partDetectionState,
        //    partLot: partLot,
        //    productSerialNumber: productSerialNumber
        //});
    });

    //创建查看窗口
    $("#viewPartDetectiveModal").window({
        height: 460,
        width: 650,
        top: ($(window).height() - 460) * 0.4,
        left: ($(window).width() - 650) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        resizable: false,
        title: "零件尺寸检测"
    });

    //打开查看窗口
    $("#View").on("click", function () {
        var operatetr = $("#tblPartDetection").datagrid("getSelected");
        var id = operatetr.Id;
        var partDetectionStatus = operatetr.PartDetectionState;
        var partDetectionState = operatetr.PartDetectionState;
        var partLot = operatetr.PartLot;
        var productSerialNumber = operatetr.ProductSerialNumber;
        var assemblyFormula = operatetr.AssemblyFormula;
        var assemblyFactor = operatetr.AssemblyFactor;
        var coreLength = operatetr.CoreLength;
        var coreHeight = operatetr.CoreHeight;
        var coreDeepHole = operatetr.CoreDeepHole;
        var matchLowerLimit = operatetr.MatchLowerLimit;
        var matchUpperLimit = operatetr.MatchUpperLimit;
        var matchLimit = operatetr.MatchLimit;
        var assemblyDimensions = operatetr.AssemblyDimensions;
        var blockSize = operatetr.BlockSize;
        //txtEditId txtEditPartDetectionState txtEditAssemblyFactor txtEditPartLot txtEditProductSerialNumber txtEditAssemblyFormula txtEditCoreLength txtEditCoreHeight txtEditCoreDeepHole txtEditMatchLimit txtEditAssemblyDimensions
        $("#txtViewId").val(id);
        $("#txtViewPartDetectionStatus").val(partDetectionStatus);
        $("#txtViewPartDetectionState").val(partDetectionState);
        $("#txtViewPartLot").val(partLot);
        $("#txtViewProductSerialNumber").val(productSerialNumber);
        $("#txtViewAssemblyFormula").val(assemblyFormula);
        $("#txtViewAssemblyFactor").val(assemblyFactor);
        $("#txtViewCoreLength").val(coreLength);
        $("#txtViewCoreHeight").val(coreHeight);
        $("#txtViewCoreDeepHole").val(coreDeepHole);
        $("#txtViewMatchLowerLimit").val(matchLowerLimit);
        $("#txtViewMatchUpperLimit").val(matchUpperLimit);
        $("#txtViewMatchLimit").val(matchLimit);
        $("#txtViewAssemblyDimensions").val(assemblyDimensions);
        $("#txtViewBlockSize").val(blockSize);

        $("#viewPartDetectiveModal").window("open");
    });

    //取消查看
    $("#cancelView").click(function () {
        $("#viewPartDetectiveModal").window("close");

    });
    //实时更新尺寸
    $("#txtEditCoreLength, #txtEditCoreHeight, #txtEditCoreDeepHole, #txtEditMatchLowerLimit, #txtEditMatchUpperLimit").change(function () {
        

        $.ajax({
            url: "/PartSizeDetection/GetSize",
            method: "post",
            data: $('#editPartDetectiveForm').serialize(),// 序列化表单值  
            async: false,
            dataType: "json"
        }).done(function (result) {
            if (result != null) {

                $("#txtEditAssemblyDimensions").val(result.AssemblyDimensions.toFixed(2));
                
            }
            console.log(result);
        });
    });
    //============================================================


});
    



