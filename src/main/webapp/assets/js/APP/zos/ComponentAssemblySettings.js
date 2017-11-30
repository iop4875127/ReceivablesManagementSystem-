$(document).ready(function () {
    /************界面表格数据显示**************/


    /************导出Excel**************/
    $("#ExportExcel").on("click", function () {
        var productName = $("#txtSearchProductName").val().trim();
        var productModel = $("#txtSearchProductModel").val().trim();
        var url = "/ComponentAssemblySettings/DownLoadComponentAssemblyExcel?productName=" + productName + "&productModel=" + productModel;
        window.location = url;
    });

    /************新增部分**************/
    //创建新增窗口
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
        title: "组件装配设置"
    });
    //打开新增窗口
    $("#AddNew").click(function () {
        $("#addForm").form('reset');
        $("#tblNewComponentPartsTable  tr").eq(1).nextAll().remove();
        $("#newModal").window("open");
    });
    //取消新增
    $("#CancelNew").click(function () {
        var $trProductPartsTable1 = $("#tblNewComponentPartsTable thead tr").slice(0, 1);
        var $trProductPartsTable2 = $("#tblNewComponentPartsTable tbody tr").slice(0, 1);
        $("#tblNewComponentPartsTable").children().remove();
        $("#tblNewComponentPartsTable").append($trProductPartsTable1);
        $("#tblNewComponentPartsTable").append($trProductPartsTable2);
        $("#newModal").window("close");
    });

    //新增时 在界面增添一条
    $("#newModalAddComponentPart").on("click", function () {
        var $table = $("#tblNewComponentPartsTable");
        var id = parseInt($("#newComponentPartItems").val());
        var item = "<tr>" +
            "<td>" +
            "<input id='txtNewComponentpartPartName" + id + "' name='ComponentParts[" + id + "].PartName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none'>" +
            "</td>" +
            "<td>" +
            "<input id='txtNewComponentPartPartDrawingNumber" + id + "' name='ComponentParts[" + id + "].PartDrawingNumber' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<input id='txtNewComponentPartPartsQuantity" + id + "' name='ComponentParts[" + id + "].PartsQuantity' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none' >" +
            "</td>" +
            "<td>" +
            "<a class='button-qx button-bc-width removeComponentPart'>移除</a>" +
            "</td>" +
            "</tr>";
        $table.append(item);
        id = id + 1;
        $("#newComponentPartItems").val(id);
    });

    //新增时 清空第一条目录信息
    $("#btnNewClearComponentPart").on("click", function () {
        $("#txtNewComponentPartPartName0").val("");
        $("#txtNewComponentPartPartDrawingNumber0").val("");
        $("#txtNewComponentPartPartsQuantity0").val("");
    });

    //新增时 在界面删除一条目录信息
    $("#tblNewComponentPartsTable").on("click", ".removeComponentPart", function () {
        var tr = $(this).parent().parent();
        tr.remove();
    });

    //保存新增
    $("#saveNewComponentAssembly").on("click", function () {
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
        $.ajax({
            url: "/ComponentAssemblySettings/AddComponentAssembly",
            method: "post",
            data: data,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#newModal").window("close");
                $("#tblComponentAssembly").datagrid("gotoPage", 1);
            }
        });
    });

    /********************************
     *          初始化界面          *
     ********************************/

    //初始化主界面表格
    $("#tblComponentAssembly").datagrid({
        url: "/ComponentAssemblySettings/Query",
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

        { field: "ProductName", title: "产品名称", width: "45%", align: "center" },
        { field: "ProductModel", title: "型号", width: "45%", align: "center" }
        ]]
    });

    //查询
    $("#btnSearch").on("click", function () {
        var productName = $("#txtSearchProductName").val();
        var productModel = $("#txtSearchProductModel").val();

        $("#tblComponentAssembly").datagrid("options").queryParams =
        {
            productName: productName,
            productModel: productModel
        };
        $("#tblComponentAssembly").datagrid("gotoPage", 1);
    });
    /************查看部分**************/


    //打开查看窗口
    $("#View").click(function () {
        var $trProductParts = $("#tblViewComponentParts tr").slice(0, 1);
        $("#tblViewComponentParts").children().remove();
        $("#tblViewComponentParts").append($trProductParts);

        var operatetr = $("#tblComponentAssembly").datagrid("getSelected");
        if (operatetr == null) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请选择需要查看的产品</div>",
                icon: "error"
            });
        } else {
            var operatProductName = operatetr.ProductName;
            var operatProductModel = operatetr.ProductModel;
            $("#txtViewProductName").val(operatetr.ProductName);
            $("#txtViewProductModel").val(operatetr.ProductModel);

            $.ajax({
                url: "/ComponentAssemblySettings/Get",
                method: "POST",
                data: { ProductName: operatProductName, ProductModel: operatProductModel },
                dataType: "json"
            }).done(function (result) {
                //目录信息
                var $tableCatalog = $("#tblViewComponentParts");
                for (var i = 0; i < result.componentParts.length; i++) {
                    var itemComponentParts = "<tr>" +
                        "<td style='height: 30px;' hidden>" +
                        "<input id='txtViewComponentpartId" + i + "' name='componentParts[" + i + "].Id' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' readonly>" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtViewComponentpartPartName" + i + "' name='componentParts[" + i + "].PartName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' readonly >" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtViewComponentPartPartDrawingNumber" + i + "' name='componentParts[" + i + "].PartDrawingNumber' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' readonly >" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtViewComponentPartPartsQuantity" + i + "' name='componentParts[" + i + "].PartsQuantity' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' readonly >" +
                        "</td>" +
                        "</tr>";
                    $tableCatalog.append(itemComponentParts);
                }


                js2form($("#viewForm").get(0), result);
                $("#ViewComponentAssemblyModal").window("open");
            });
        }
    });
    //创建查看窗口
    $("#ViewComponentAssemblyModal").window({
        height: 500,
        width: 900,
        top: ($(window).height() - 500) * 0.4,
        left: ($(window).width() - 900) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        title: "查看组件配置"
    });
    //关闭查看窗口
    $("#CancelView").click(function () {
        $("#ViewComponentAssemblyModal").window("close");
    });

    //创建编辑窗口
    $("#editComponentAssemblyModal").window({
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
        title: "编辑员工档案信息"
    });

    //打开编辑窗口
    $("#Edit").click(function () {
        $("#editForm").validate().resetForm();
        var $trProductParts = $("#tblEditComponentParts tr").slice(0, 1);
        $("#tblEditComponentParts").children().remove();
        $("#tblEditComponentParts").append($trProductParts);
        var operatetr = $("#tblComponentAssembly").datagrid("getSelected");
        if (operatetr == null) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请选择需要编辑的组件配置信息</div>",
                icon: "error"
            });
        } else {

            var operatProductName = operatetr.ProductName;
            var operatProductModel = operatetr.ProductModel;
            $("#txtEditProductName").val(operatetr.ProductName);
            $("#txtEditProductModel").val(operatetr.ProductModel);

            $.ajax({
                url: "/ComponentAssemblySettings/Get",
                method: "POST",
                data: { ProductName: operatProductName, ProductModel: operatProductModel },
                dataType: "json"
            }).done(function (result) {
                var $tableComponentParts = $("#tblEditComponentParts");
                $("#editcomponentPartsItems").val(result.componentParts.length);
                for (var i = 0; i < result.componentParts.length; i++) {
                    var itemComponentParts = "<tr>" +
                        "<td  style='height: 30px;' hidden>" +
                        "<input id='txtEditComponentpartId" + i + "' name='componentParts[" + i + "].Id' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td >" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditComponentpartPartName" + i + "' name='componentParts[" + i + "].PartName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditComponentPartPartDrawingNumber" + i + "' name='componentParts[" + i + "].PartDrawingNumber' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditComponentPartPartsQuantity" + i + "' name='componentParts[" + i + "].PartsQuantity' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td>" +
                        "<td>" +
                        "<a class='button-qx button-bc-width removeComponentPart'>移除</a>" +
                        "</td>" +
                        "</tr>";
                    $tableComponentParts.append(itemComponentParts);
                }

                js2form($("#editForm").get(0), result);
            });
            $("#editComponentAssemblyModal").window("open");
        }
    });

    //编辑时清空一条目录信息
    $("#tblEditComponentParts").on("click", ".removeComponentPart", function () {
        var tr = $(this).parent().parent();
        tr.remove();
    });

    //编辑时 在界面增添一条零件信息
    $("#editModalEditComponentParts").on("click", function () {
        var $table = $("#tblEditComponentParts");
        var id = parseInt($("#editComponentPartsItems").val());
        var item = "<tr>" +
                        "<td  style='height: 30px;' hidden>" +
                        "<input id='txtEditComponentpartId" + id + "' name='componentParts[" + id + "].Id' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td >" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditComponentpartPartName" + id + "' name='componentParts[" + id + "].PartName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditComponentPartPartDrawingNumber" + id + "' name='componentParts[" + id + "].PartDrawingNumber' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditComponentPartPartsQuantity" + id + "' name='componentParts[" + id + "].PartsQuantity' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' >" +
                        "</td>" +
                        "<td>" +
                        "<a class='button-qx button-bc-width removeComponentPart'>移除</a>" +
                        "</td>" +
                        "</tr>";
        $table.append(item);
        id = id + 1;
        $("#editcomponentPartsItems").val(id);
    });

    //保存编辑
    $("#SaveEditComponentAssembly").on("click", function () {
        if (!$("#editForm").valid()) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请正确填写完毕再保存</div>",
                icon: "error"
            });
            return;
        }
        var data = form2js($("#editForm").get(0), ".", true);
        $.ajax({
            url: "/ComponentAssemblySettings/UpdateComponentAssembly",
            method: "post",
            data: data,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#editComponentAssemblyModal").window("close");
                $("#tblComponentAssembly").datagrid("gotoPage", 1);
            }
        });
    });

    //取消编辑
    $("#CancelEditComponentAssembly").click(function () {
        $("#editComponentAssemblyModal").window("close");
    });
    //删除信息
    $("#Delete").on("click", function () {
        var operatetr = $("#tblComponentAssembly").datagrid("getSelected");
        var operatProductName = operatetr.ProductName;
        var operatProductModel = operatetr.ProductModel;
        $.ajax({
            url: "/ComponentAssemblySettings/DeleteComponentAssembly",
            method: "post",
            data: { ProductName: operatProductName, ProductModel: operatProductModel },
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#tblComponentAssembly").datagrid("gotoPage", 1);
            }
        });
    });
});