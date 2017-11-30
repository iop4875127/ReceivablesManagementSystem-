$(document).ready(function () {

    //查询
    $("#btnSearch").on("click", function () {
        var userNo = $("#txtSearchUserNo").val();
        var userName = $("#txtSearchUserName").val();
        var companyNo = $("#txtSearchCompanyNo").val();
        var inDate = $("#cldSearchInDate").val();

        $("#tblArchivesInfo").datagrid("options").queryParams =
        {
            userNo: userNo,
            userName: userName,
            companyNo: companyNo,
            inDate: inDate
        };
        $("#tblArchivesInfo").datagrid("gotoPage", 1);
    });

    //打开选择 搜索 单位窗口
    $("#txtSearchCompany").on("click", function () {
        window.initSelectTree(1, 1);
        $("#SaveSelect").addClass("SelectSearchOrg");
    });

    //确定选择 搜索 单位
    $(document).on("click", ".SelectSearchOrg", function () {
        var tr = $("#targetTable tbody tr");
        var orgName = tr.find("td:last").text();
        var orgNo = tr.find("td:first").text();
        if (orgName.length > 0 && orgNo.length > 0) {
            $("#txtSearchCompanyNo").val(orgNo);
            $("#txtSearchCompany").val(orgName);
        }
        else {
            $("#txtSearchCompanyNo").val("");
            $("#txtSearchCompany").val("");
        }
        $("#SaveSelect").removeClass("SelectSearchOrg");
        $("#SelectModal").window("close");
    });

    //打开新增窗口
    $("#new").click(function () {
        $("#newForm").validate().resetForm();
        $("#newArchivesModal input").val("");
        $("#newArchivesModal").window("open");
    });

    //保存新增
    $("#saveNewArchivesInfo").on("click", function () {
        $("#txtNewIsOut").val("2");
        if (!$("#newForm").valid()) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请正确填写完毕再保存</div>",
                icon: "error"
            });
            return;
        }
        var data = form2js($("#newForm").get(0), ".", true);
        $.ajax({
            url: "/ArchivesManagement/AddArchives",
            method: "post",
            data: data,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#newArchivesModal").window("close");
                $("#tblArchivesInfo").datagrid("gotoPage", 1);
            }
        });
    });

    //取消新增
    $("#cancelNewArchivesInfo").click(function () {
        $("#newArchivesModal").window("close");
    });

    //打开编辑窗口
    $("#edit").click(function () {
        $("#editForm").validate().resetForm();

        var $trCatalog = $("#tblEditCatalogInfo tr").slice(0, 1);
        $("#tblEditCatalogInfo").children().remove();
        $("#tblEditCatalogInfo").append($trCatalog);
        var $trBorrowInfo = $("#tblEditBorrowInfo tr").slice(0, 1);
        $("#tblEditBorrowInfo").children().remove();
        $("#tblEditBorrowInfo").append($trBorrowInfo);
        var operatetr = $("#tblArchivesInfo").datagrid("getSelected");
        if (operatetr == null) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请选择需要编辑的员工档案</div>",
                icon: "error"
            });
        } else {
            var operateno = operatetr.UserNo;
            $("#txtEditUserName").val(operatetr.UserName);
            $.ajax({
                url: "/ArchivesManagement/Get",
                method: "POST",
                data: { UserNo: operateno },
                dataType: "json"
            }).done(function (result) {
                //目录信息
                var $tableCatalog = $("#tblEditCatalogInfo");
                $("#editCatalogItems").val(result.catalogs.length);
                for (var i = 0; i < result.catalogs.length; i++) {
                    var itemCatalog = "<tr>" +
                        "<td style='height: 30px;'>" +
                        "<input id='txtEditCatalogNo" + i + "' name='catalogs[" + i + "].CatalogNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;'>" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtEditCatalogName" + i + "' name='catalogs[" + i + "].CatalogName' class='input_style' style='width: 90%; height: 100%; text-align: center; border: none;'>" +
                        "<a class='button-qx button-bc-width removeCatalog'>移除</a>" +
                        "</td>" +
                        "</tr>";
                    $tableCatalog.append(itemCatalog);
                }
                //借阅信息
                var $tableBorrow = $("#tblEditBorrowInfo");
                var borrowNature = "<option value=''></option>";
                if (result.borrowNatures != null) {
                    for (var k = 0; k < result.borrowNatures.length; k++) {
                        borrowNature += "<option value='" + result.borrowNatures[k].Id + "'>" + result.borrowNatures[k].ItemName + "</option>";
                    }
                }
                for (var j = 0; j < result.archivesBorrowModels.length; j++) {
                    var itemBorrow = "<tr class='borrow'>" +
                        "<td>" +
                        "<input id='ddlEditBorrowDate" + j + "' name='archivesBorrowModels[" + j + "].BorrowDate' class='input_style' style='height:22px;text-indent: 3px' type='date'/>" +
                        "</td>" +
                        "<td>" +
                        "<input id='txtEditBorrowPerson" + j + "' name='archivesBorrowModels[" + j + "].BorrowPerson' class='input_style'/>" +
                        "</td>" +
                        "<td>" +
                        "<input id='txtEditBorrowReason" + j + "' name='archivesBorrowModels[" + j + "].BorrowReason' class='input_style'/>" +
                        "</td>" +
                        "<td>" +
                        "<select id='ddlEditBorrowNature" + j + "' name='archivesBorrowModels[" + j + "].BorrowNature' class='input_style'>" +
                        borrowNature +
                        "</select>" +
                        "</td>" +
                        "<td>" +
                        "<textarea id='txtEditBorrowContent" + j + "' name='archivesBorrowModels[" + j + "].BorrowContent' class='textarea_style'/>" +
                        "</td>" +
                        "</tr>";
                    $tableBorrow.append(itemBorrow);
                    $("#ddlEditBorrowDate" + j).rules("add", { required: true, isRangeDate: [600, 0], messages: { required: "请填写借阅时间", isRangeDate: "请正确填写借阅时间" } });
                    $("#txtEditBorrowPerson" + j).rules("add", { required: true, messages: { required: "请填写借阅人" } });
                    $("#txtEditBorrowContent" + j).rules("add", { required: true, maxlength: 100, messages: { required: "请填写借阅内容", maxlength: "借阅内容长度不应超过100字" } });
                }
                js2form($("#editForm").get(0), result);
                isCancel($("#ddlEditIsOut"), $("#cldEditOutDate"));
            });
            $("#editArchivesModal").window("open");
        }
    });

    //保存编辑
    $("#saveEditArchivesInfo").on("click", function () {
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
            url: "/ArchivesManagement/Update",
            method: "post",
            data: data,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#editArchivesModal").window("close");
                $("#tblArchivesInfo").datagrid("gotoPage", 1);
            }
        });
    });

    //取消编辑
    $("#cancelEditArchivesInfo").click(function () {
        $("#editArchivesModal").window("close");
    });

    //打开查看窗口
    $("#view").click(function () {
        var $trCatalog = $("#tblViewCatalogInfo tr").slice(0, 1);
        $("#tblViewCatalogInfo").children().remove();
        $("#tblViewCatalogInfo").append($trCatalog);
        var $trBorrowInfo = $("#tblViewBorrowInfo tr").slice(0, 1);
        $("#tblViewBorrowInfo").children().remove();
        $("#tblViewBorrowInfo").append($trBorrowInfo);
        var operatetr = $("#tblArchivesInfo").datagrid("getSelected");
        if (operatetr == null) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请选择需要查看的员工档案</div>",
                icon: "error"
            });
        } else {
            var operateno = operatetr.UserNo;
            $("#txtViewUserName").val(operatetr.UserName);
            $.ajax({
                url: "/ArchivesManagement/Get",
                method: "POST",
                data: { UserNo: operateno },
                dataType: "json"
            }).done(function (result) {
                //目录信息
                var $tableCatalog = $("#tblViewCatalogInfo");
                for (var i = 0; i < result.catalogs.length; i++) {
                    var itemCatalog = "<tr>" +
                        "<td style='height: 30px;'>" +
                        "<input id='txtViewCatalogNo" + i + "' name='catalogs[" + i + "].CatalogNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;' readonly>" +
                        "</td>" +
                        "<td style='text-align: left;'>" +
                        "<input id='txtViewCatalogName" + i + "' name='catalogs[" + i + "].CatalogName' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;'readonly>" +
                        "</td>" +
                        "</tr>";
                    $tableCatalog.append(itemCatalog);
                }
                //借阅信息
                var borrowNature = "<option value=''></option>";
                if (result.borrowNatures != null) {
                    for (var k = 0; k < result.borrowNatures.length; k++) {
                        borrowNature += "<option value='" + result.borrowNatures[k].Id + "'>" + result.borrowNatures[k].ItemName + "</option>";
                    }
                }
                var $tableBorrow = $("#tblViewBorrowInfo");
                for (var j = 0; j < result.archivesBorrowModels.length; j++) {
                    var itemBorrow = "<tr>" +
                        "<td id='tdViewBorrowDate" + j + "' style='padding:6px;'></td>" +
                        "<td id='tdViewBorrowPerson" + j + "' style='padding:6px;'></td>" +
                        "<td id='tdViewBorrowReason" + j + "' style='padding:6px;'></td>" +
                        "<td>" +
                        "<select id='ddlViewBorrowNature" + j + "' name='archivesBorrowModels[" + j + "].BorrowNature' class='input_style' disabled>" +
                        borrowNature +
                        "</select>" +
                        "</td>" +
                        "<td id='tdViewBorrowContent" + j + "' style='padding:6px;'></td>" +
                        "</tr>";
                    $tableBorrow.append(itemBorrow);
                    $("#tdViewBorrowDate" + j).html(result.archivesBorrowModels[j].BorrowDate);
                    $("#tdViewBorrowPerson" + j).html(result.archivesBorrowModels[j].BorrowPerson);
                    $("#tdViewBorrowReason" + j).html(result.archivesBorrowModels[j].BorrowReason);
                    $("#ddlViewBorrowNature" + j).val(result.archivesBorrowModels[j].BorrowNature);
                    $("#tdViewBorrowContent" + j).html(result.archivesBorrowModels[j].BorrowContent);
                }

                js2form($("#viewForm").get(0), result);
                isCancel($("#ddlViewIsOut"), $("#txtViewOutDate"));
                $("#viewArchivesModal").window("open");
            });
        }
    });

    //取消查看
    $("#cancelViewArchivesInfo").click(function () {
        $("#viewArchivesModal").window("close");
    });

    //打开借阅窗口
    $("#borrow").click(function () {
        $("#borrowForm").validate().resetForm();
        $("#borrowArchivesModal input").val("");
        $("#borrowArchivesModal textarea").val("");
        var operatetr = $("#tblArchivesInfo").datagrid("getSelected");
        if (operatetr != null) {
            $("#txtBorrowUserNo").val(operatetr.UserNo);
            $("#txtBorrowUserName").val(operatetr.UserName);
            $("#borrowArchivesModal").window("open");
        } else {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请选择需要借阅的员工档案</div>",
                icon: "error"
            });
        }
    });

    //保存借阅
    $("#saveBorrowArchives").on("click", function () {
        if (!$("#borrowForm").valid()) {
            $.messager.alert({
                title: "操作提示",
                msg: "<div style='text-align: center; padding-right: 40px;font-size:13px;'><strong>操作失败!</strong><br/>请正确填写完毕再保存</div>",
                icon: "error"
            });
            return;
        }
        var data = form2js($("#borrowForm").get(0), ".", true);
        $.ajax({
            url: "/ArchivesManagement/AddArchivesBorrow",
            method: "post",
            data: data,
            dataType: "json"
        }).done(function (result) {
            if (result.Success) {
                $("#borrowArchivesModal").window("close");
                $("#tblArchivesInfo").datagrid("gotoPage", 1);
            }
        });
    });

    //取消借阅
    $("#cancelBorrowArchives").click(function () {
        $("#borrowArchivesModal").window("close");
    });

    //导出Excel
    $("#export").on("click", function () {
        var userNo = $("#txtSearchUserNo").val();
        var userName = $("#txtSearchUserName").val();
        var companyNo = $("#txtSearchCompanyNo").val();
        var inDate = $("#cldSearchInDate").val();
        var url = "/ArchivesManagement/DownLoadArchivesInfoExcel?userNo=" + userNo + "&userName=" + userName + "&companyNo=" + companyNo + "&inDate=" + inDate;
        window.location = url;
    });

    //新增时 在界面增添一条目录信息
    $("#newModalAddCatalogInfo").on("click", function () {
        var $table = $("#tblNewCatalogInfoTable");
        var id = parseInt($("#newCatalogItems").val());
        var item = "<tr>" +
            "<td>" +
            "<input id='txtNewCatalogNo" + id + "' name='catalogs[" + id + "].CatalogNo' class='input_style' >" +
            "</td>" +
            "<td>" +
            "<input id='txtNewCatalogName" + id + "' name='catalogs[" + id + "].CatalogName' class='input_style input_90' >" +
            "<a class='button-qx button-bc-width removeCatalog'>移除</a>" +
            "</td>" +
            "</tr>";
        $table.append(item);
        id = id + 1;
        $("#newCatalogItems").val(id);
    });

    //新增时 在界面删除一条目录信息
    $("#tblNewCatalogInfoTable").on("click", ".removeCatalog", function () {
        var tr = $(this).parent().parent();
        tr.remove();
    });

    //新增时 清空第一条目录信息
    $("#btnNewClearCatalog").on("click", function () {
        $("#txtNewCatalogNo0").val("");
        $("#txtNewCatalogName0").val("");
    });

    //编辑时 在界面增添一条目录信息
    $("#editModalAddCatalogInfo").on("click", function () {
        var $table = $("#tblEditCatalogInfo");
        var id = parseInt($("#editCatalogItems").val());
        var item = "<tr>" +
            "<td style='height: 30px;'>" +
            "<input id='txtEditCatalogNo" + id + "' name='catalogs[" + id + "].CatalogNo' class='input_style' style='width: 100%; height: 100%; text-align: center; border: none;'>" +
            "</td>" +
            "<td style='text-align: left;'>" +
            "<input id='txtEditCatalogName" + id + "' name='catalogs[" + id + "].CatalogName' class='input_style' style='width: 90%; height: 100%; text-align: center; border: none;'>" +
            "<a class='button-qx button-bc-width removeCatalog'>移除</a>" +
            "</td>" +
            "</tr>";
        $table.append(item);
        id = id + 1;
        $("#editCatalogItems").val(id);
    });

    //编辑时 在界面删除一条目录信息
    $("#tblEditCatalogInfo").on("click", ".removeCatalog", function () {
        var tr = $(this).parent().parent();
        tr.remove();
    });

    //编辑时选择是否转出
    $("#ddlEditIsOut").change(function () {
        isCancel($("#ddlEditIsOut"), $("#cldEditOutDate"));
    });

    //填写工号自动填充姓名
    $("#txtNewUserNo").change(function () {
        var userNo = $("#txtNewUserNo").val();
        $.ajax({
            url: "/BasicInfo/GetUserInfo",
            method: "POST",
            data: { UserNo: userNo },
            dataType: "json"
        }).done(function (result) {
            if (!$("#txtNewUserNo").valid()) {
                $("#txtNewUserName").val("");
                return;
            }
            if (result.UserInfo != null) {
                $("#txtNewUserName").val(result.UserInfo.UserName);
            }
        });
    });

    //选择显示转出档案各项字段
    function isCancel($ddlIsOut, $OutDate) {
        if ($ddlIsOut.val() === "2") {
            $OutDate.parent().parent().hide();
        }
        if ($ddlIsOut.val() === "1") {
            $OutDate.parent().parent().show();
        }

    }


    /********************************
     *          初始化界面          *
     ********************************/

    //初始化主界面表格
    $("#tblArchivesInfo").datagrid({
        url: "/ArchivesManagement/Query",
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
        { field: "UserNo", title: "工号", width: "8%", align: "center" },
        { field: "UserName", title: "姓名", width: "8%", align: "center" },
        { field: "CompanyNo", title: "单位", width: "15%", align: "center" },
        { field: "NowPlace", title: "当前档案所在地", width: "22%", align: "center" },
        { field: "InPlace", title: "转入来源", width: "22%", align: "center" },
        { field: "InDate", title: "转入时间", width: "9%", align: "center" },
        { field: "IsOut", title: "是否转出", width: "7%", align: "center" },
        { field: "OutDate", title: "转出时间", width: "9%", align: "center" }
        ]]
    });


    //创建新增窗口
    $("#newArchivesModal").window({
        height: 500,
        width: 700,
        top: ($(window).height() - 500) * 0.5,
        left: ($(window).width() - 700) * 0.5,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        draggable: true,
        resizable: false,
        title: "添加员工档案信息"
    });

    //创建编辑窗口
    $("#editArchivesModal").window({
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

    //创建查看窗口
    $("#viewArchivesModal").window({
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
        title: "查看员工档案信息"
    });

    //创建借阅窗口
    $("#borrowArchivesModal").window({
        height: 500,
        width: 600,
        top: ($(window).height() - 500) * 0.5,
        left: ($(window).width() - 600) * 0.5,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        draggable: true,
        resizable: false,
        title: "借阅档案信息"
    });

    /********************************
     *          数据验证            *
     ********************************/
    $("#newForm").validate({
        ignore: ".ignore",
        rules: {
            "archivesInfoModel.UserNo": {
                required: true,
                isUserNo: true,
                //请求远程服务器验证工号是否存在
                remote: {
                    type: "POST",
                    url: "/ArchivesManagement/IsExist",
                    data: {
                        userNo: function () {
                            return $("#txtNewUserNo").val();
                        }
                    },
                    dataType: "json",
                    dataFilter: function (data) {
                        var jsonData = jQuery.parseJSON(data);
                        return !jsonData.isExist && jsonData.isExistInUserInfo;
                    }
                }
            },
            "archivesInfoModel.InDate": { required: true, isRangeDate: [600, 0] }
            //"archivesInfoModel.IsOut": { required: true }
        },
        messages: {
            "archivesInfoModel.UserNo": { required: "请填写工号", isUserNo: "请正确填写工号", remote: "无此员工或档案已存在" },
            "archivesInfoModel.InDate": { required: "请填写转入时间", isRangeDate: "请正确填写转入时间" }
            //"archivesInfoModel.IsOut": { required: "请选择是否转出" }
        }
    });

    $("#editForm").validate({
        ignore: ".ignore",
        rules: {
            "archivesInfoModel.InDate": { required: true, isRangeDate: [600, 0] },
            "archivesInfoModel.IsOut": { required: true }
        },
        messages: {
            "archivesInfoModel.InDate": { required: "请填写转入时间", isRangeDate: "请正确填写转入时间" },
            "archivesInfoModel.IsOut": { required: "请选择是否转出" }
        }
    });

    $("#borrowForm").validate({
        ignore: ".ignore",
        rules: {
            "archivesBorrowModel.BorrowDate": { required: true, isRangeDate: [600, 0] },
            "archivesBorrowModel.BorrowPerson": { required: true },
            "archivesBorrowModel.BorrowContent": { required: true, maxlength: 100 }
        },
        messages: {
            "archivesBorrowModel.BorrowDate": { required: "请填写借阅时间", isRangeDate: "请正确填写借阅时间" },
            "archivesBorrowModel.BorrowPerson": { required: "请填写借阅人" },
            "archivesBorrowModel.BorrowContent": { required: "请填写借阅内容", maxlength: "借阅内容长度不应超过100字" }
        }
    });
});