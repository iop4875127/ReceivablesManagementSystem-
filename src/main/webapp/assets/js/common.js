/**
 * 
 * 版本日期:2016-12-13
 * 重点修改HY_SerializeJsonStr、HY_SerializeJsonObject序列化方法
 * 重点修改HY_BindDataByJson方法
 * 2016-01-09
 * 添加HY_Tool开始的工具栏操作,主要控制工具栏上按钮的可用状态
 */
$(function () {
    //关闭easyuiwindow对话框
    $(document).on("click", ".hy-easyuiwindow-close", function () {
        $(this).closest(".window-body").window("close");
        $(this).closest("form")[0].reset();
        $(".tooltip").hide();//有可能juqery.validate验证提示信息会显示出来，该语句是隐藏他
    });
    ////禁止输入非数字文本
    //$(".hy-disable-inputnonum").attr("onpaste", "return false");//不允许粘贴
    //$(document).on("keyup", ".hy-disable-inputnonum", function (e) {
    //    var obj = this;
    //    obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符   
    //    obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的   
    //    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
    //    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');//只能输入两个小数   
    //    if (obj.value.indexOf(".") < 0 && obj.value != "") { //以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额  
    //        obj.value = parseFloat(obj.value);
    //    }
    //});
    //$(document).on("keydown", ".hy-disable-inputnonum", function (e) {
    //    e = (e) ? e : window.event;
    //    var keycode = e.keyCode;
    //    var value = $(this).val();
    //    var flag = true;
    //    if (value.indexOf(".") > 0)
    //        flag = false;
    //    if ((keycode <= 57 && keycode >= 48) || (keycode <= 105 && keycode >= 96) || (keycode === 8) || (keycode === 13) || flag) {
    //        return true;
    //    } else {
    //        return false;
    //    }
    //});
    //easyui tree折叠
    $(document).on("click", ".hy-easyuitree-toogle", function () {
        try {
            var treeid = $(this).attr("data-treeid");//获取树的id
            var toogle = $(this).attr("data-toogle");//获取要切换的状态
            $("#" + treeid).tree(toogle);
            //如果默认为展开所有,则切换为关闭所有
            if (toogle === "expandAll") {
                $(this).attr("data-toogle", "collapseAll");
                $(this).html("<span></span>全部折叠");
            } else {
                $(this).attr("data-toogle", "expandAll");
                $(this).html("<span></span>全部展开");
            }
        } catch (ex) { }

    });
});
$.fn.extend({
    /*
     * 将数据绑定到下拉列表框中
     * @param {object} options:参数集合
     * @param callback:回调函数,当数据绑定完成之后触发
     */
    "HY_BindSelect": function (options, callback) {
        var $this = $(this);
        options = $.extend({
            textField: null, //文本值
            valueField: null, //value值
            formatterTextField: function () { },
            formatterValueField: function () { },
            url: null,
            data: null
        }, options);
        $.ajax({
            url: options.url,
            type: "post",
            data: options.data,
            dataType: "json",
            success: function (resultdata) {
                if (resultdata != null) {
                    var html = '<option value="">-</option>';
                    $.each(resultdata, function (index, item) {
                        var value = options.formatterValueField(item);
                        if (value != null)
                            html += '<option value="' + value + '">';
                        else
                            html += '<option value="' + item[options.valueField] + '">';

                        var text = options.formatterTextField(item);
                        if (text != null)
                            html += text + '</option>';
                        else
                            html += item[options.textField] + '</option>';
                    });
                    $this.html(html);
                    //绑定数据成功之后的回掉函数
                    if (typeof callback == 'function') {
                        callback(resultdata);
                    }
                }
            }
        });
    },
    /*
     * 将指定元素下的数据序列化成json字符串
     * @param {object} options:参数集合
     */
    "HY_SerializeJsonStr": function (options) {
        var jsonobj = $(this).HY_SerializeJsonObject(options);
        return JSON.stringify(jsonobj);
    },
    /*
     * 将指定元素下的数据序列化成json对象
     * @param {object} options:参数集合
     */
    "HY_SerializeJsonObject": function (options) {
        var $input = $(this).find(":input:not(:button)");
        //配置参数
        options = $.extend({
            data: null //追加的json数据
        }, options);
        function flag(name) {
            if (name == undefined ||
                name === "__VIEWSTATE" ||
                name === "__VIEWSTATEGENERATOR" ||
                name === "__EVENTVALIDATION")
                return false;
            else
                return true;
        }
        var obj = {};
        $input.each(function () {
            var type = this.type; //获取input控件的类型
            var name = $(this).attr("name"); //获取name属性
            var value = $(this).val(); //获取value值
            if (flag(name)) {
                if (type === "checkbox") {
                    if (this.checked) {
                        //obj[name]初始化肯定为空，找相同的name,原选的值累加起来
                        if (obj[name] != null) {
                            var formatter = $(this).attr("data-checkbox-formatter");
                            formatter = formatter == null ? "" : formatter;
                            obj[name] = obj[name] + formatter + value;
                        } else {
                            obj[name] = value;
                        }
                    }
                }
                else if (type === "radio") {
                    if (this.checked) {
                        obj[name] = value;
                    }
                } else if (type === "select-one") {
                    obj[name] = value;
                }
                else {
                    obj[name] = value;
                }
            }
        });
        //两个对象相加
        var jsonobj = $.extend(obj, options.data);
        return jsonobj;

    },
    /*
     * 将json对象绑定到指定元素的下
     * @param {object} json:json对象
     */
    "HY_BindDataByJson": function (json) {
        console.info(json);
        var $this = $(this);
        if (json == null)
            return;
        var myObject = getMyObject(json);
        var $input = $(this).find(":input:not(:button)");
        $input.each(function () {
            var name = $(this).attr("name");
            if (name != null) {
                var type = this.type;
                //根据元素name获取与其匹配的对象属性
                var obj = myObject[name.toLowerCase()];
                if (obj != null) {
                    if (type === "select-one") {
                        bindSelect($(this), obj);
                    }
                    else if (type === "checkbox") {
                        bindCheckbox($(this), obj);
                    }
                    else if (type === "radio") {
                        bindRadio($(this), obj);
                    }
                    else {
                        $(this).val(obj.value);
                    }
                }

            }
        });
        function bindCheckbox(element, obj) {
            var val = element.val();//获取复选框的值
            var value = obj.value;//获取json中的值
            var formatter = element.attr("data-checkbox-formatter");
            formatter = formatter == null ? "" : formatter;
            var arrayValue = value.split(formatter);//根据复选框的格式将数据分隔
            for (var i = 0; i < arrayValue.length; i++) {
                if (arrayValue[i] === val) {
                    element.attr("checked", "checked");
                }
            }
            
        }
        function bindSelect(element, obj) {
            var value = obj.value;
            $(element).find("option").each(function () {
                if ($(this).val() === value + "") {
                    this.selected = true;
                    return false;
                }
            });
        }
        function bindRadio(element, obj) {
            var val = element.val();
            var value = obj.value;
            if (value === val) {
                element.attr("checked", "checked");
            }
        }
        function getMyObject(json) {
            //将json对象中的数据包装成Object对象;属性名为小写原对象的名称(后面绑定数数据不区分name的大小写)
            var obj = {};
            for (var key in json) {
                if (json.hasOwnProperty(key)) {
                    obj[key.toLowerCase()] = { name: key, value: json[key] };
                }
            }
            return obj;
        }
    },
    /*工具栏中的按钮禁用*/
    "HY_ToolAddDisabled": function () {
        $.each(this, function (i, data) {
            $(data).addClass("tool-disabled"); //工具中的按钮禁用
            var id = $(data).attr("id");//获取操作按钮的编号
            if (id == null) return;
            id = "_" + id + "_";//防止禁用按钮的id名称与hy对象中的系统重复所以添加标识
            hy[id] = false;
        });
    },
    /*工具栏中的启用*/
    "HY_ToolRemoveDisabled": function () {
        $.each(this, function (i, data) {
            $(data).removeClass("tool-disabled"); //工具中的按钮禁用
            var id = $(data).attr("id");//获取操作按钮的编号
            if (id == null) return;
            id = "_" + id + "_";//防止禁用按钮的id名称与hy对象中的系统重复所以添加标识
            hy[id] = true;
        });

    },
    /*验证工具栏中的按钮是否可用*/
    "HY_ToolIsUsed": function () {
        var id = $(this).attr("id");//获取操作按钮的编号
        if (id == null) return true;
        id = "_" + id + "_";//防止禁用按钮的id名称与hy对象中的系统重复所以添加标识
        var flag = hy[id];
        if (flag === false)
            return false;
        else
            return true;
    },
    /*
    * juqery.Ajax处理数据(一般用于保存操作)
    * @param {object} options:参数集合
    * @param {function} fn1:保存成功回调函数
    * @param {function} fn2:保存失败回调函数
    */
    "HY_Save": function (options, fn1, fn2) {
        var $this = $(this);
        options = $.extend({
            url: null,
            type: "post",
            dataType: "json",
            data: null
        }, options);
        //如果无传递的data参数
        if (options.data == null) {
            options.data = $this.closest("form").HY_SerializeJsonObject();
        };
        //=========页面上默认的一些处理============//
        var $inputpage = $this.closest(".input-page");
        var $thisparent = $this.parent();
        $thisparent.hide();//隐藏当前保存按钮的父级元素.input-page(主要为了防止用户频繁的点击保存按钮)
        $("#hy-save-loading").remove();//防止页面上存在id="hy-save-loading"
        $inputpage.append("<p id='hy-save-loading'>正在提交数据,请稍后...</p>");
        //=========页面上默认的一些处理============//
        $.ajax({
            url: options.url,
            type: options.type,
            data: options.data,
            dataType: options.dataType,
            success: function (resultdata) {
                //还原按钮显示状态
                $("#hy-save-loading").remove();
                $thisparent.show();
                var flag = true;
                if (!resultdata.state)
                    return;
                if (resultdata.state === 1) {
                    if (typeof fn1 == 'function')
                        flag = fn1(resultdata);
                    hy.successTip({ content: resultdata.msg});//提示成功信息
                } else {
                    if (typeof fn2 == 'function')
                        flag = fn2(resultdata);
                    else {
                        hy.alert({ content: resultdata.msg });
                        return;
                    }

                }
                //============fn1,fn2回调函数之后要执行的数据===========/
                if (flag !== false) {
                    //关闭easyuiwindow
                    $this.closest(".window-body").window("close");
                    //重置当前按钮所在的表单数据
                    if ($this.closest("form").length > 0)
                        $this.closest("form")[0].reset();
                }
                //============fn1回掉函数======================================/
            },
            error: function (xmlHttpRequest, textStatus, errorThrown) {
                $("#hy-save-loading").remove();
                $thisparent.show();
                hy.alert({
                    content: errorThrown
                });
            }
        });
    }
});
$.fn.extend({
    "HY_OpenWindow": function (options) {
        var $this = $(this);
        //配置参数
        options = $.extend({
            title: "提示",
            width: 960,
            height: 300,
            left: -1,
            top: -1,
            collapsible: false, //easyui默认值true
            minimizable: false, //easyui默认值true
            maximizable: false, //easyui默认值true
            closable: true, //easyui默认值true
            closed: true, //easyui默认值false
            zIndex: 9000, //easyui默认值9000
            draggable: true, //easyui默认值true
            maximized: false, //easyui默认值false
            resizable: true, //easyui默认值true
            shadow: true, //easyui默认值true
            inline: false, //easyui默认值false
            modal: true //easyui默认值true
        }, options);

        //默认居中显示
        var top = options.top;
        var left = options.left;
        if (top < 0)
            top = (document.body.offsetHeight - options.height) / 2 - 15;
        if (left < 0)
            left = (document.body.offsetWidth - options.width) / 2 - 15;
        $this.window({
            width: options.width,
            title: options.title,
            left: left,
            top: top,
            modal: options.modal,
            closed: options.closed,
            minimizable: options.minimizable,
            collapsible: options.collapsible,
            maximizable: options.maximizable,
            onClose: function () {
                $(this).find("form")[0].reset();
            }
        });
        $this.height(options.height);
        $this.width(options.width);
        $this.show();
        $this.window('open');
    },
    //表单验证
    "HY_FormValidate": function () {
        var rules = {}; //全局变量
        var messages = {};
        //遍历页面上的所有表单
        var $form = $(this);
        //rules = new Array(); //初始化rules无内容
        //messages = new Array();
        //通过表单元素绑定数据验证
        $form.find(":input:not(:button)").each(function () {
            //检测需要验证的控件名称是否存在
            var name = $(this).attr("name");
            if (!(name === undefined || name == null || name === "")) {
                createValidate($(this));
            }
        });
        $form.validate({
            rules: rules,
            messages: messages
        });
        function createValidate($obj) {
            var rulesPara = {};//定义参数对象
            var messagesPara = {};//定义参数对象
            //获取元素
            var name = $obj.attr("name");
            var $searchdiv = $obj.closest(".search_div"); //找到父级searchdiv
            var $inputtext = $searchdiv.find(".input_text"); //找到input_text元素
            if ($inputtext != null) {
                var txt = $.trim($inputtext.text());
                //存在必填项
                if (txt !== "" && txt.indexOf("*") > -1) {
                    var msg = "请输入" + $.trim(txt.replace("*", ""));//必填项提示信息
                    if ($obj[0].type != null && ($obj[0].type === "select-one" || $obj[0].type === "radio" || $obj[0].type === "checkbox"))
                        msg = "请选择" + $.trim(txt.replace("*", ""));
                    //创建rules
                    rulesPara.required = true;
                    rules[name] = rulesPara;
                    //创建messages提示信息
                    messagesPara.required = msg;
                    messages[name] = messagesPara;
                }
            }
            //html中有自定义属性
            var datarules = $obj.attr("data-rules");
            if (datarules != null) {
                var data1 = eval('[' + datarules + ']');
                //将上一个rulesPara累加
                rules[name] = $.extend(rulesPara, data1[0]);
            }
            var datamessages = $obj.attr("data-messages");
            if (datamessages != null) {
                //将元素属性data-messages 转成json数组
                var data2 = eval('[' + datamessages + ']');
                //把必填区域的messagesPara累加起来
                messages[name] =$.extend(messagesPara, data2[0]);
            }
        };
    }
});

HY_IsNullOrEmpty = function (str) {
    if (str === undefined || str == null || str === "") {
        return true;
    } else {
        return false;
    }
};

var hy = {};
; (function () {
    var obj = hy;
    obj.alert = function (options, fn) {
        options = $.extend({
            title: "提示",
            width: 500,
            height: 300,
            left: -1,
            top: -1,
            collapsible: false, //easyui默认值true
            minimizable: false, //easyui默认值true
            maximizable: false, //easyui默认值true
            closable: true,//easyui默认值true
            closed: true,//easyui默认值false
            zIndex: 9000,//easyui默认值9000
            draggable: true,//easyui默认值true
            maximized: false,//easyui默认值false
            resizable: true,//easyui默认值true
            shadow: true,//easyui默认值true
            inline: false,//easyui默认值false
            modal: true//easyui默认值true
        }, options);
        if ($("#hy-alert").length > 0)
            $("#hy-alert").remove();
        var html = '<div id="hy-alert" class="tip-content"> ';
        html += '<div class="tip-div">';
        html += '<img src="../images/tip_icon.png" />';
        html += ' <span>' + options.content + '</span>';
        html += '<div class="clearfix"></div>';
        html += '</div>';
        html += '<div class="tip-button">';
        html += ' <input name="ok" type="button" value="我知道了"  class="buttons" />';
        html += ' </div>';
        html += '</div>';
        $("body").append(html);
        //默认居中显示
        var top = options.top;
        var left = options.left;
        if (top < 0)
            top = (document.body.offsetHeight - options.height) / 2;
        if (left < 0)
            left = (document.body.offsetWidth - options.width) / 2;
        $('#hy-alert').window({
            width: options.width,
            title: options.title,
            left: left,
            top: top,
            modal: options.modal,
            closed: options.closed,
            minimizable: options.minimizable,
            collapsible: options.collapsible,
            maximizable: options.maximizable
        });
        $('#hy-alert').window("open");
        $("#hy-alert input[name=ok]").click(function () {
            var flag = true;
            if (typeof fn == 'function' && fn() === false) {
                flag = false;
            }
            if (flag) {
                $('#hy-alert').window("close");
                $('#hy-alert').remove();
            }
        });
    };
    obj.successTip = function (options) {
        options = $.extend({
            content:"操作成功!"
        }, options);
        if ($("#hy-success-tip").length > 0)
            $("#hy-success-tip").remove();
        var style = 'position: absolute;background-color: #000;color: white;font-family: "微软雅黑";padding: 15px 20px;text-align: center;border-radius: 1pxmargin: 0px auto;opacity: 0.8;left: 50%;top: 50%;z-index:9999999';
        var html = "<div id='hy-success-tip' style='" + style + "'>";
        html += options.content;
        html += "</div>";
        $("body").append(html);
        setTimeout(function () {
            $("#hy-success-tip").fadeOut(800, function () {
                 $("#hy-success-tip").remove();
             });
         }, 2000);//2秒自动关闭
    }
    obj.confirm = function (options, fn1, fn2) {
        options = $.extend({
            title: "提示",
            width: 500,
            height: 300,
            left: -1,
            top: -1,
            collapsible: false, //easyui默认值true
            minimizable: false, //easyui默认值true
            maximizable: false, //easyui默认值true
            closable: true, //easyui默认值true
            closed: true, //easyui默认值false
            zIndex: 9000, //easyui默认值9000
            draggable: true, //easyui默认值true
            maximized: false, //easyui默认值false
            resizable: true, //easyui默认值true
            shadow: true, //easyui默认值true
            inline: false, //easyui默认值false
            modal: true //easyui默认值true
        },
            options);
        if ($("#hy-confirm").length > 0)
            $("#hy-confirm").remove();
        var html = '<div id="hy-confirm" class="tip-content"> ';
        html += '<div class="tip-div">';
        html += '<img src="../images/tip_icon.png" />';
        html += ' <span>' + options.content + '</span>';
        html += '<div class="clearfix"></div>';
        html += '</div>';
        html += '<div class="tip-button">';
        html += ' <input name="yes" type="button" value="确认"  class="buttons" />';
        html += ' <input name="no" type="button" value="取消"  class="buttons" />';
        html += ' </div>';
        html += '</div>';

        $("body").append(html);
        //默认居中显示
        var top = options.top;
        var left = options.left;
        if (top < 0)
            top = (document.body.offsetHeight - options.height) / 2;
        if (left < 0)
            left = (document.body.offsetWidth - options.width) / 2;
        $('#hy-confirm')
            .window({
                width: options.width,
                title: options.title,
                left: left,
                top: top,
                modal: options.modal,
                closed: options.closed,
                minimizable: options.minimizable,
                collapsible: options.collapsible,
                maximizable: options.maximizable
            });
        $('#hy-confirm').window("open");
        $("#hy-confirm input[name=yes]").click(function () {
            if (typeof fn1 == 'function') {
                fn1();
            }
        });
        $("#hy-confirm input[name=no]").click(function () {
            var flag = true;
            if (typeof fn2 == 'function' && fn2() === false) {
                flag = false;
            }
            if (flag) {
                $('#hy-confirm').window("close");
                $('#hy-confirm').remove();
            }
        });
    };
    obj.close_alert_confirm = function () {
        $('#hy-confirm,hy-alert').window("close");
        $('#hy-confirm,hy-alert').remove();
    };
    obj.openwindow = function (options) {
        //配置参数
        options = $.extend({
            title: "提示",
            width: 960,
            height: 300,
            src: "",
            id: "ww",
            left: -1,
            top: -1,
            wintype: window.self, //默认为当前窗体 可以为 window.top,window.parent
            collapsible: false, //easyui默认值true
            minimizable: false, //easyui默认值true
            maximizable: false, //easyui默认值true
            closable: true,//easyui默认值true
            closed: false,//easyui默认值false
            zIndex: 9000,//easyui默认值9000
            draggable: true,//easyui默认值true
            maximized: false,//easyui默认值false
            resizable: true,//easyui默认值true
            shadow: true,//easyui默认值true
            inline: false,//easyui默认值false
            modal: true//easyui默认值true
        }, options);
        //默认居中显示
        var top = options.top;
        var left = options.left;
        if (top < 0) {
            top = (document.body.offsetHeight - options.height) / 4;
        }
           
        if (left < 0) {
            left = (document.body.offsetWidth - options.width) / 2;
        }
            
        //iframe的名称
        var iframeId = "#" + options.id;
        //移除生成的iframe
        options.wintype.$(iframeId).remove();
        var iframe = '<iframe src="" id="' + iframeId.substr(1) + '" width="100%"  style="display: none;" frameborder="0"></iframe>';
        options.wintype.$("body").append(iframe);
        //配置弹出框参数
        options.wintype.$(iframeId).window({
            title: options.title,
            width: options.width,
            height: options.height,
      		left:left,
			top:top,
            collapsible: options.collapsible, //easyui默认值true
            minimizable: options.minimizable, //easyui默认值true
            maximizable: options.maximizable, //easyui默认值true
            closable: options.closable,//easyui默认值true
            closed: options.closed,//easyui默认值false
            zIndex: options.zIndex,//easyui默认值9000
            draggable: options.draggable,//easyui默认值true
            maximized: options.maximizable,//easyui默认值false
            resizable: options.resizable,//easyui默认值true
            shadow: options.shadow,//easyui默认值true
            inline: options.inline,//easyui默认值false
            modal: options.modal,//easyui默认值true
			onMove:function (left, top) { // popwindow拖动时触发，限制弹出框拖动范围  
                var parentObj = $(this).panel('panel').parent();
                var width = $(this).panel('options').width;
                var height = $(this).panel('options').height;
                var parentWidth = $("body").width();
                var parentHeight = $("body").height();
                var scrollLeft = document.body.scrollLeft;
                var scrollTop = document.body.scrollTop;
                // 当弹出框被拖动到浏览器外时，将弹出框定位至浏览器边缘  
               // alert(top);
                //alert(scrollTop);
                if (left < scrollLeft) {
                    $(this).window('move', {
                        left: scrollLeft
                    });
                }
                if (top < scrollTop) {
                    $(this).window('move', {
                        top: scrollTop
                    });
                }
                if (left > scrollLeft && left > parentWidth - width + scrollLeft) {
                    $(this).window('move', {
                        left: parentWidth - width + scrollLeft
                    });
                }
                if (top > scrollTop && top > parentHeight - height + scrollTop) {
                    $(this).window('move', {
                        top: parentHeight - height + scrollTop
                    });
                }
            }
        });
        options.wintype.$(iframeId).height(options.height);//改变高度
        options.wintype.$(iframeId).width(options.width);//改变宽度
        options.wintype.$(iframeId).attr("src", options.src);//改变路径
        options.wintype.$(iframeId).show();
    };
    /*日期类*/
    obj.date = {
        /**sDate1-sDate2
         * 两个日期相减获取天数
         * @param {yyyy-MM-dd类型日期} sDate1 
         * @param {yyyy-MM-dd类型日期} sDate2 
         * @returns {int}相差天 
         */
        dateDiff: function (sDate1, sDate2) {    //sDate1和sDate2是2006-12-18格式  
            var aDate;
            aDate = sDate1.split("-");
            var oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);    //转换为12-18-2006格式  
            aDate = sDate2.split("-");
            var oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
            var iDays = parseInt((oDate1 - oDate2) / 1000 / 60 / 60 / 24);    //把相差的毫秒数转换为天数  
            return iDays;
        },
        /**
         * 日期添加天数得到一个新日期
         * @param {date} date:日期
         * @param {int} days:天数
         * @returns {date} 返回yyyy-MM-dd日期
         */
        dateAddDays: function (date, days) {
            var d = new Date(date);
            d.setDate(d.getDate() + Number(days));
            var month = d.getMonth() + 1;
            var day = d.getDate();
            if (month < 10) {
                month = "0" + month;
            }
            if (day < 10) {
                day = "0" + day;
            }
            var val = d.getFullYear() + "-" + month + "-" + day;
            return val;
        }
    };

})();


