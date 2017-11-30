$.validator.setDefaults({
    onfocusout: function (element) { $(element).valid(); },
    errorPlacement: function (error, element) {
        var errorContent = $(error).text();
        if ($(error).text() === "") {
            element.popover("hide");
        }
        else {
            var _popover;
            _popover = $(element).popover({
                trigger: "manual",
                placement: "bottom",
                content: errorContent
            });
            _popover.data("bs.popover").options.content = errorContent;
            _popover.popover("show");
        }
    },
    success: "valid",
    highlight: function (element) {
        $(element).addClass("validate_error");
    },
    unhighlight: function (element) {
        $(element).removeClass("validate_error");
    },
    showErrors: function (errorMap, errorList) {
        if (errorList.length) {
            var firstError = errorList.shift();
            var firstErrorList = [];
            firstErrorList.push(firstError);
            this.errorList = firstErrorList;
        };
        this.defaultShowErrors();
    }
});

// 验证新增核算日期是否存在
$.validator.addMethod("isMonthExist", function (value, element) {
    var Month = value;
    var url = "/SalaryPay/IsExist?Month=" + Month;
    var res;
    $.ajax({
        url: url,
        async: false,
        method: "POST"
    }).done(function (result) {
        if (result.IsExist) {
            res = false;
        } else {
            res = true;
        }

    });
    return res;
}, "该月数据已存在");
// 验证员工工号是否存在
$.validator.addMethod("isUserNoExist", function (value, element) {
    var userNo = value;
    var url = "/BasicInfo/IsExist?userNo=" + userNo;
    var res;
    $.ajax({
        url: url,
        async: false,
        method: "POST"
    }).done(function (result) {
        if (result.IsUserNoExist) {
            res = false;
        } else {
            res = true;
        }

    });
    return res;
}, "该工号已存在");

// 验证员工工号是否存在(结果与上相反)
$.validator.addMethod("UserNoExist", function (value, element) {
    var userNo = value;
    var url = "/BasicInfo/IsExist?userNo=" + userNo;
    var res;
    $.ajax({
        url: url,
        async: false,
        method: "POST"
    }).done(function (result) {
        if (result.IsUserNoExist) {
            res = true;
        } else {
            res = false;
        }
    });
    return res;
}, "该工号不存在");

// 判断整数value是否等于0 
$.validator.addMethod("isIntEqZero", function (value, element) {
    value = parseInt(value);
    return this.optional(element) || value === 0;
}, "整数必须为0");

// 判断整数value是否大于0
$.validator.addMethod("isIntGtZero", function (value, element) {
    value = parseInt(value);
    return this.optional(element) || value > 0;
}, "整数必须大于0");

// 判断整数value是否大于或等于0
$.validator.addMethod("isIntGteZero", function (value, element) {
    value = parseInt(value);
    return this.optional(element) || value >= 0;
}, "整数必须大于或等于0");

// 判断整数value是否不等于0 
$.validator.addMethod("isIntNEqZero", function (value, element) {
    value = parseInt(value);
    return this.optional(element) || value !== 0;
}, "整数必须不等于0");

// 判断整数value是否小于0 
$.validator.addMethod("isIntLtZero", function (value, element) {
    value = parseInt(value);
    return this.optional(element) || value < 0;
}, "整数必须小于0");

// 判断整数value是否小于或等于0 
$.validator.addMethod("isIntLteZero", function (value, element) {
    value = parseInt(value);
    return this.optional(element) || value <= 0;
}, "整数必须小于或等于0");

// 判断整数value是否小于或等于param控件的值
$.validator.addMethod("isIntGteParam", function (value, element, param) {
    return this.optional(element) || parseInt(value) <= parseInt($(param).val());
}, "整数必须小于或等于param的值");

// 判断浮点数value是否等于0 
$.validator.addMethod("isFloatEqZero", function (value, element) {
    value = parseFloat(value);
    return this.optional(element) || value === 0;
}, "浮点数必须为0");

// 判断浮点数value是否大于0
$.validator.addMethod("isFloatGtZero", function (value, element) {
    value = parseFloat(value);
    return this.optional(element) || value > 0;
}, "浮点数必须大于0");

// 判断浮点数value是否大于或等于0
$.validator.addMethod("isFloatGteZero", function (value, element) {
    value = parseFloat(value);
    return this.optional(element) || value >= 0;
}, "浮点数必须大于或等于0");

// 判断浮点数value是否不等于0 
$.validator.addMethod("isFloatNEqZero", function (value, element) {
    value = parseFloat(value);
    return this.optional(element) || value !== 0;
}, "浮点数必须不等于0");

// 判断浮点数value是否小于0 
$.validator.addMethod("isFloatLtZero", function (value, element) {
    value = parseFloat(value);
    return this.optional(element) || value < 0;
}, "浮点数必须小于0");

// 判断浮点数value是否小于或等于0 
$.validator.addMethod("isFloatLteZero", function (value, element) {
    value = parseFloat(value);
    return this.optional(element) || value <= 0;
}, "浮点数必须小于或等于0");

// 判断浮点型  
$.validator.addMethod("isFloat", function (value, element) {
    return this.optional(element) || /^[-\+]?\d+(\.\d+)?$/.test(value);
}, "只能包含数字、小数点等字符");

// 匹配integer
$.validator.addMethod("isInteger", function (value, element) {
    return this.optional(element) || (/^[-\+]?\d+$/.test(value) && parseInt(value) >= 0);
}, "匹配integer");

// 判断数值类型，包括整数和浮点数
$.validator.addMethod("isNumber", function (value, element) {
    return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);
}, "匹配数值类型，包括整数和浮点数");

// 只能输入[0-9]数字
$.validator.addMethod("isDigits", function (value, element) {
    return this.optional(element) || /^\d+$/.test(value);
}, "只能输入0-9数字");

// 手机号码验证    
$.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    return this.optional(element) || (length === 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));
}, "请正确填写您的手机号码。");

// 电话号码验证    
$.validator.addMethod("isPhone", function (value, element) {
    var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
    return this.optional(element) || (tel.test(value));
}, "请正确填写您的电话号码。");

// 联系电话(手机/电话皆可)验证   
$.validator.addMethod("isTel", function (value, element) {
    var length = value.length;
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var tel = /^(\d{3,4}-?)?\d{7,9}$/g;
    return this.optional(element) || tel.test(value) || (length === 11 && mobile.test(value));
}, "请正确填写您的联系方式");

// 匹配qq      
$.validator.addMethod("isQq", function (value, element) {
    return this.optional(element) || /^[1-9]\d{4,12}$/;
}, "匹配QQ");

// 邮政编码验证    
$.validator.addMethod("isZipCode", function (value, element) {
    var zip = /^[0-9]{6}$/;
    return this.optional(element) || (zip.test(value));
}, "请正确填写您的邮政编码。");

// 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。      
$.validator.addMethod("isPwd", function (value, element) {
    return this.optional(element) || /^[a-zA-Z]\\w{6,12}$/.test(value);
}, "以字母开头，长度在6-12之间，只能包含字符、数字和下划线。");

// 身份证号码验证
$.validator.addMethod("isIdCardNo", function (value, element) {
    return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
}, "请输入正确的身份证号码。");

//身份证号码的验证规则
var idCardNoUtil = {

    provinceAndCitys: {
        11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江",
        31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东",
        45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏",
        65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
    },

    powers: ["7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"],

    parityBit: ["1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"],

    checkAddressCode: function (addressCode) {
        var check = /^[1-9]\d{5}$/.test(addressCode);
        if (!check) return false;
        if (idCardNoUtil.provinceAndCitys[parseInt(addressCode.substring(0, 2))]) {
            return true;
        } else {
            return false;
        }
    },
    checkBirthDayCode: function (birDayCode) {
        var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birDayCode);
        if (!check) return false;
        var yyyy = parseInt(birDayCode.substring(0, 4), 10);
        var mm = parseInt(birDayCode.substring(4, 6), 10);
        var dd = parseInt(birDayCode.substring(6), 10);
        var xdata = new Date(yyyy, mm - 1, dd);
        if (xdata > new Date()) {
            return false;//生日不能大于当前日期
        } else if ((xdata.getFullYear() === yyyy) && (xdata.getMonth() === mm - 1) && (xdata.getDate() === dd)) {
            return true;
        } else {
            return false;
        }
    },
    getParityBit: function (idCardNo) {
        var id17 = idCardNo.substring(0, 17);
        var power = 0;
        for (var i = 0; i < 17; i++) {
            power += parseInt(id17.charAt(i), 10) * parseInt(idCardNoUtil.powers[i]);
        }
        var mod = power % 11;
        return idCardNoUtil.parityBit[mod];
    },

    checkParityBit: function (idCardNo) {
        var parityBit = idCardNo.charAt(17).toUpperCase();
        if (idCardNoUtil.getParityBit(idCardNo) === parityBit) {
            return true;
        } else {
            return false;
        }
    },
    checkIdCardNo: function (idCardNo) {
        //15位和18位身份证号码的基本校验
        var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
        if (!check) return false;
        //判断长度为15位或18位
        if (idCardNo.length === 15) {
            return idCardNoUtil.check15IdCardNo(idCardNo);
        } else if (idCardNo.length === 18) {
            return idCardNoUtil.check18IdCardNo(idCardNo);
        } else {
            return false;
        }
    },
    //校验15位的身份证号码
    check15IdCardNo: function (idCardNo) {
        //15位身份证号码的基本校验
        var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/.test(idCardNo);
        if (!check) return false;
        //校验地址码
        var addressCode = idCardNo.substring(0, 6);
        check = idCardNoUtil.checkAddressCode(addressCode);
        if (!check) return false;
        var birDayCode = "19" + idCardNo.substring(6, 12);
        //校验日期码
        return idCardNoUtil.checkBirthDayCode(birDayCode);
    },
    //校验18位的身份证号码
    check18IdCardNo: function (idCardNo) {
        //18位身份证号码的基本格式校验
        var check = /^[1-9]\d{5}[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/.test(idCardNo);
        if (!check) return false;
        //校验地址码
        var addressCode = idCardNo.substring(0, 6);
        check = idCardNoUtil.checkAddressCode(addressCode);
        if (!check) return false;
        //校验日期码
        var birDayCode = idCardNo.substring(6, 14);
        check = idCardNoUtil.checkBirthDayCode(birDayCode);
        if (!check) return false;
        //验证校检码
        return idCardNoUtil.checkParityBit(idCardNo);
    }
}

// IP地址验证   
$.validator.addMethod("ip", function (value, element) {
    return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);
}, "请填写正确的IP地址。");

// 字符验证，只能包含中文、英文、数字、下划线等字符。    
$.validator.addMethod("stringCheck", function (value, element) {
    return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5-_]+$/.test(value);
}, "只能包含中文、英文、数字、下划线等字符");

// 匹配english  
$.validator.addMethod("isEnglish", function (value, element) {
    return this.optional(element) || /^[A-Za-z]+$/.test(value);
}, "匹配english");

// 匹配汉字  
$.validator.addMethod("isChinese", function (value, element) {
    return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);
}, "匹配汉字");

// 匹配中文(包括汉字和字符) 
$.validator.addMethod("isChineseChar", function (value, element) {
    return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);
}, "匹配中文(包括汉字和字符) ");

// 判断是否为合法字符(a-zA-Z0-9-_)
$.validator.addMethod("isRightfulString", function (value, element) {
    return this.optional(element) || /^[A-Za-z0-9_-]+$/.test(value);
}, "不是合法字符(a-zA-Z0-9-_)");

// 判断是否包含中英文特殊字符，除英文"-_"字符外
$.validator.addMethod("isContainsSpecialChar", function (value, element) {
    var reg = RegExp(/[(\ )(\`)(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\|)(\{)(\})(\')(\:)(\;)(\')(',)(\[)(\])(\.)(\<)(\>)(\/)(\?)(\~)(\！)(\@)(\#)(\￥)(\%)(\…)(\&)(\*)(\（)(\）)(\—)(\+)(\|)(\{)(\})(\【)(\】)(\‘)(\；)(\：)(\”)(\“)(\’)(\。)(\，)(\、)(\？)]+/);
    return this.optional(element) || !reg.test(value);
}, "含有中英文特殊字符");

// 判断日期是否在合理范围（当前日期前后n个月）
$.validator.addMethod("isRangeDate", function (value, element, param) {
    var valueDate = new Date(value);
    var startDate = new Date();
    var endDate = new Date();
    startDate.setMonth(startDate.getMonth() - param[0]);
    endDate.setMonth(endDate.getMonth() + param[1]);

    return this.optional(element) || valueDate >= startDate && valueDate <= endDate;
}, "日期不在合理日期范围");

/*
*360度测部分评所需要的验证规则（BEGIN）
*/

//验证 测评问卷名称是否存在

/*
*360度测部分评所需要的验证规则（END）
*/


