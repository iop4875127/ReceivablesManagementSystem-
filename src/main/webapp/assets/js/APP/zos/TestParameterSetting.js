$(document).ready(function () {
    /************界面表格数据显示**************/

    //初始化
    $("#ViewTable").datagrid({
        url: "/TestParameterSetting/QueryByPage",
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
          { field: "Id", title: "Id", hidden:true },
          { field: "ProductName", title: "产品名称", width: 80, align: "center" },
          { field: "ProductModel", title: "型号规格", width: 100, align: "center" },
          { field: "IsPressureTestFirst", title: "第一轮是否气压测试",  width: 80, align: "center" }
       
        ]]
    });

    //查询
    $("#search").on("click", function () {
        var queryProductName = $("#queryProductName option:selected").attr("value");
        var queryProductModel = $("#queryProductModel").val().trim();
        var queryIsPressureTestFirst = $("#queryIsPressureTestFirst option:selected").attr("value");
        $("#ViewTable").datagrid("options").queryParams = { ProductName: queryProductName, ProductModel: queryProductModel, IsPressureTestFirst: queryIsPressureTestFirst };
        $("#ViewTable").datagrid("reload");
    });

    /************导出Excel**************/
    //$("#ExportExcel").on("click", function () {
    //    var companyName = $("#queryCompanyName").val().trim();
    //    var department = $("#queryDepartment").val().trim();
    //    var userNo = $("#queryUserNo").val().trim();
    //    var type = $("#queryType option:selected").attr("value");

    //    var url = "/TwoPassDetection/DownLoadTwoPassDetectionExcel?CompanyName=" + companyName + "&Department=" + department + "&UserNo=" + userNo + "&Type=" + type;
    //    window.location = url;
    //});

    /************新增部分**************/
    //创建新增窗口
    $("#newTwoPassDetectionModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 600) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        resizable: false,
        title: "两通检测参数设置"
    });
    //打开新增窗口
    $("#AddTwoPassDetectionNew").click(function () {
        $("#addTwoPassDetectionForm").form('reset');
        $("#newTwoPassDetectionModal").window("open");
    });
    //取消新增
    $("#cancelTwoPassDetectionNew").click(function () {
        $("#newTwoPassDetectionModal").window("close");
    });
    //保存新增
    $("#saveTwoPassDetectionNew").on("click", function () {
        if (!$("#addTwoPassDetectionForm").valid()) return;
        var formData = window.form2js($("#addTwoPassDetectionForm")[0], ".", true);
        $.ajax({
            url: "/TestParameterSetting/Add",
            method: "POST",
            data: formData,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#newTwoPassDetectionModal").window("close");
                $("#ViewTable").datagrid("reload");
            } else {
                for (var i = 0; i < result.Errors.length; i++) {
                    var error = result.Errors[i];
                    $('[name="' + error.Name + '"]').next("span").html(error.ErrorMessage);
                }
            }
        });
        });


    //创建新增窗口
    $("#newThreePassDetectionModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 600) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        resizable: false,
        title: "三通检测参数设置"
    });
    //打开新增窗口
    $("#AddThreePassDetectionNew").click(function () {
        $("#addThreePassDetectionForm").form('reset');
        $("#newThreePassDetectionModal").window("open");
        $("#ThreeProductName").val("三通电磁阀");
    });
    //取消新增
    $("#cancelThreePassDetectionNew").click(function () {
        $("#newThreePassDetectionModal").window("close");
    });
    //保存新增
    $("#saveThreePassDetectionNew").on("click", function () {
        if (!$("#addThreePassDetectionForm").valid()) return;
        var formData = window.form2js($("#addThreePassDetectionForm")[0], ".", true);
        $.ajax({
            url: "/TestParameterSetting/Add",
            method: "POST",
            data: formData,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#newThreePassDetectionModal").window("close");
                $("#ViewTable").datagrid("reload");
            } else {
                for (var i = 0; i < result.Errors.length; i++) {
                    var error = result.Errors[i];
                    $('[name="' + error.Name + '"]').next("span").html(error.ErrorMessage);
                }
            }
        });
    });

    /************删除部分**************/

    //创建删除窗口
    $("#deleteTestParameterSettingModal").window({
        height: 120,
        width: 400,
        top: ($(window).height() - 150) * 0.4,
        left: ($(window).width() - 400) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        title: "删除测试参数设置"
    });

    //打开删除窗口
    $("#Delete").on("click", function () {
        var operatetr = $("#ViewTable").datagrid("getSelected");
        if (operatetr != null) {
            var operateid = operatetr.Id;
            $("#deleteTestParameterSettingId").val(operateid);
            $("#deleteTestParameterSettingModal").window("open");
        }
    });

    //保存删除
    $("#saveDelete").on("click", function () {
        var deleteId = $("#deleteTestParameterSettingId").val();
        $.ajax({
            url: "/TestParameterSetting/Delete",
            method: "post",
            data: { Id: deleteId },
            dataType: "json"
        }).done(function (result) {
            if (result.HandleResult === "Success") {
                $("#deleteTestParameterSettingModal").window("close");
                $("#ViewTable").datagrid("reload");
            } else {
                for (var i = 0; i < result.Errors.length; i++) {
                    var error = result.Errors[i];
                    $('[name="' + error.Name + '"]').next("span").html(error.ErrorMessage);
                }
            }
        });
    });

    //取消删除
    $("#cancelDelete").click(function () {
        $("#deleteDepartmentTrainingModal").window("close");
    });

    /************查看部分**************/

    //创建查看窗口
    $("#viewTwoPassDetectionModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 600) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        title: "查看两通测试参数设置"
    });
    $("#viewThreePassDetectionModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 600) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        title: "查看三通测试参数设置"
    });

    //打开查看窗口
    $("#View").on("click", function () {
        var operatetr = $("#ViewTable").datagrid("getSelected");
        if (operatetr != null) {
            var operateid = operatetr.Id;
            $.ajax({
                url: "/TestParameterSetting/Get",
                method: "post",
                data: { Id: operateid },
                dataType: "json"
            }).done(function (result) {
                if (result.ProductName === "三通电磁阀") {
                    window.js2form($("#viewThreePassDetectionForm")[0], result);
                    $("#viewThreePassDetectionModal").window("open");
                } else if (result.ProductName === "两通电磁阀") {
                    window.js2form($("#viewTwoPassDetectionForm")[0], result);
                    $("#viewTwoPassDetectionModal").window("open");
                }
            });
           
        }
    });

    //关闭查看窗口
    $("#cancelTwoPassDetectionView").click(function () {
        $("#viewTwoPassDetectionModal").window("close");
    });
    $("#cancelThreePassDetectionView").click(function () {
        $("#viewThreePassDetectionModal").window("close");
    });


    /************修改部分**************/

    //创建修改窗口
    $("#editTwoPassDetectionModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 600) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        title: "修改两通测试参数设置"
    });
    $("#editThreePassDetectionModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 600) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        title: "修改三通测试参数设置"
    });


    //打开修改窗口
    $("#Edit").on("click", function () {
        var operatetr = $("#ViewTable").datagrid("getSelected");
        if (operatetr != null) {
            var operateid = operatetr.Id;
         
            $.ajax({
                url: "/TestParameterSetting/Get",
                method: "post",
                data: { Id: operateid },
                dataType: "json"
            }).done(function (result) {
                if (result.ProductName === "三通电磁阀") {
                    window.js2form($("#editThreePassDetectionForm")[0], result);
                    $("#editThreePassDetectionModal").window("open");
                    $(".editTestParameterSettingId").val(operateid);
                } else if (result.ProductName === "两通电磁阀") {
                    window.js2form($("#editTwoPassDetectionForm")[0], result);
                    $("#editTwoPassDetectionModal").window("open");
                    $(".editTestParameterSettingId").val(operateid);
                }
            });
        }
    });

    //保存修改
    $("#saveTwoPassDetectionEdit").on("click", function () {
        var formData = window.form2js($("#editTwoPassDetectionForm")[0], ".", true);
        $.ajax({
            url: "/TestParameterSetting/Update",
            method: "post",
            data:formData,
            dataType: "json"
        }).done(function () {
            $("#editTwoPassDetectionModal").window("close");
            $("#ViewTable").datagrid("reload");
        });
    });
    $("#saveThreePassDetectionEdit").on("click", function () {
        var formData = window.form2js($("#editThreePassDetectionForm")[0], ".", true);
        $.ajax({
            url: "/TestParameterSetting/Update",
            method: "post",
            data: formData,
            dataType: "json"
        }).done(function () {
            $("#editThreePassDetectionModal").window("close");
            $("#ViewTable").datagrid("reload");
        });
    });

    //取消修改
    $("#cancelTwoPassDetectionEdit").click(function () {
        $("#editTwoPassDetectionModal").window("close");
    });
    $("#cancelThreePassDetectionEdit").click(function () {
        $("#editThreePassDetectionModal").window("close");
    });

    //数据有效性验证
    $("#addTwoPassDetectionForm").validate({
        rules: {
            ProductName: {
                required: true
            },
            ProductModel: {
                required: true
            },
            IsPressureTestFirst: {
                required: true
            },
            TwoInitialStartValueLower: {
                required: true
            },
            TwoInitialStartValueUpper: {
                required: true
            },
            InNegativePressureLower: {
                required: true
            },
            InNegativePressureUpper: {
                required: true
            },
            OutNegativePressureLower: {
                required: true
            },
            OutNegativePressureUpper: {
                required: true
            },
            InPositivePressureLower: {
                required: true
            },
            InPositivePressureUpper: {
                required: true
            },
            OutPositivePressureLower: {
                required: true
            },
            OutPositivePressureUpper: {
                required: true
            },
            InPressureLower: {
                required: true
            },
            InPressureUpper: {
                required: true
            },

            OutPressureLower: {
                required: true
            },
            OutPressureUpper: {
                required: true
            }
        },
        messages: {
            ProductName: {
                required: "此为必填项"
            },
            ProductModel: {
                required: "此为必填项"
            },
            IsPressureTestFirst: {
                required: "此为必填项"
            },
            TwoInitialStartValueLower: {
                required: "此为必填项"
            },
            TwoInitialStartValueUpper: {
                required: "此为必填项"
            },
            InNegativePressureLower: {
                required: "此为必填项"
            },
            InNegativePressureUpper: {
                required: "此为必填项"
            },
            OutNegativePressureLower: {
                required: "此为必填项"
            },
            OutNegativePressureUpper: {
                required: "此为必填项"
            },
            InPositivePressureLower: {
                required: "此为必填项"
            },
            InPositivePressureUpper: {
                required: "此为必填项"
            },

            OutPositivePressureLower: {
                required: "此为必填项"
            },
            OutPositivePressureUpper: {
                required: "此为必填项"
            },
            InPressureLower: {
                required: "此为必填项"
            },
            InPressureUpper: {
                required: "此为必填项"
            },

            OutPressureLower: {
                required: "此为必填项"
            },
            OutPressureUpper: {
                required: "此为必填项"
            }
          
        }

    });

    $("#addThreePassDetectionForm").validate({
        rules: {
            ProductName: {
                required: true
            },
            ProductModel: {
                required: true
            },
            IsPressureTestFirst: {
                required: true
            },
            ThreeInitialStartValueLower: {
                required: true
            },
            ThreeInitialStartValueUpper: {
                required: true
            },
            NegativeNccomLower: {
                required: true
            },
            NegativeNccomUpper: {
                required: true
            },
            NegativeComncLower: {
                required: true
            },
            NegativeComncUpper: {
                required: true
            },
            PositiveComncLower: {
                required: true
            },
            PositiveComncUpper: {
                required: true
            },
            PositiveComnoLower: {
                required: true
            },
            PositiveComnoUpper: {
                required: true
            },
            PositiveNccomLower: {
                required: true
            },
            PositiveNccomUpper: {
                required: true
            },

            PositiveNocomLower: {
                required: true
            },
            PositiveNocomUpper: {
                required: true
            },

            PressureComncLower: {
                required: true
            },
            PressureComncUpper: {
                required: true
            },

            PressureComnoLower: {
                required: true
            },
            PressureComnoUpper: {
                required: true
            }
        },
        messages: {
            ProductName: {
                required: "此为必填项"
            },
            ProductModel: {
                required: "此为必填项"
            },
            IsPressureTestFirst: {
                required: "此为必填项"
            },
            ThreeInitialStartValueLower: {
                required: "此为必填项"
            },
            ThreeInitialStartValueUpper: {
                required: "此为必填项"
            },
            NegativeNccomLower: {
                required: "此为必填项"
            },
            NegativeNccomUpper: {
                required: "此为必填项"
            },
            NegativeComncLower: {
                required: "此为必填项"
            },
            NegativeComncUpper: {
                required: "此为必填项"
            },
            PositiveComncLower: {
                required: "此为必填项"
            },
            PositiveComncUpper: {
                required: "此为必填项"
            },

            PositiveComnoLower: {
                required: "此为必填项"
            },
            PositiveComnoUpper: {
                required: "此为必填项"
            },
            PositiveNccomLower: {
                required: "此为必填项"
            },
            PositiveNccomUpper: {
                required: "此为必填项"
            },

            PositiveNocomLower: {
                required: "此为必填项"
            },
            PositiveNocomUpper: {
                required: "此为必填项"
            },
            PressureComncLower: {
                required: "此为必填项"
            },
            PressureComncUpper: {
                required: "此为必填项"
            },

            PressureComnoLower: {
                required: "此为必填项"
            },
            PressureComnoUpper: {
                required: "此为必填项"
            }

        }

    });
});