
/**
 * 针对panel window dialog三个组件调整大小时会超出父级元素的修正
 * 如果父级元素的overflow属性为hidden，则修复上下左右个方向
 * 如果父级元素的overflow属性为非hidden，则只修复上左两个方向
 * @param width
 * @param height
 * @returns
 */
var easyuiPanelOnResize = function(width, height) {
    if (!$.data(this, 'window') && !$.data(this, 'dialog'))
        return;
    if ($(this).panel('options').maximized == true) {
        $(this).panel('options').fit = false;
    }
    $(this).panel('options').reSizing = true;
    if (!$(this).panel('options').reSizeNum) {
        $(this).panel('options').reSizeNum = 1;
    } else {
        $(this).panel('options').reSizeNum++;
    }
    var parentObj = $(this).panel('panel').parent();
    var left = $(this).panel('panel').position().left;
    var top = $(this).panel('panel').position().top;

    if ($(this).panel('panel').offset().left < 0) {
        $(this).panel('move', {
            left : 0
        });
    }
    if ($(this).panel('panel').offset().top < 0) {
        $(this).panel('move', {
            top : 0
        });
    }

    if (left < 0) {
        $(this).panel('move', {
            left : 0
        }).panel('resize', {
            width : width + left
        });
    }
    if (top < 0) {
        $(this).panel('move', {
            top : 0
        }).panel('resize', {
            height : height + top
        });
    }
    if (parentObj.css("overflow") == "hidden") {
        var inline = $.data(this, "window").options.inline;
        if (inline == false) {
            parentObj = $(window);
        }

        if ((width + left > parentObj.width())
            && $(this).panel('options').reSizeNum > 1) {
            $(this).panel('resize', {
                width : parentObj.width() - left
            });
        }

        if ((height + top > parentObj.height())
            && $(this).panel('options').reSizeNum > 1) {
            $(this).panel('resize', {
                height : parentObj.height() - top
            });
        }
    }
    $(this).panel('options').reSizing = false;
};

/**
 * 针对panel window dialog三个组件拖动时会超出父级元素的修正
 * 如果父级元素的overflow属性为hidden，则修复上下左右个方向
 * 如果父级元素的overflow属性为非hidden，则只修复上左两个方向
 * @param left
 * @param top
 * @returns
 */
var easyuiPanelOnMove = function(left, top) {
    if ($(this).panel('options').reSizing)
        return;
    var parentObj = $(this).panel('panel').parent();
    var width = $(this).panel('options').width;
    var height = $(this).panel('options').height;
    var right = left + width;
    var buttom = top + height;
    var parentWidth = parentObj.width();
    var parentHeight = parentObj.height();

    if (left < 0) {
        $(this).panel('move', {
            left : 0
        });
    }
    if (top < 0) {
        $(this).panel('move', {
            top : 0
        });
    }

    if (parentObj.css("overflow") == "hidden") {
        var inline = $.data(this, "window").options.inline;
        if (inline == false) {
            parentObj = $(window);
        }
        if (left > parentObj.width() - width) {
            $(this).panel('move', {
                "left" : parentObj.width() - width
            });
        }
        if (top > parentObj.height() - height) {
            $(this).panel('move', {
                "top" : parentObj.height() - height
            });
        }
    }
};

$.fn.window.defaults.onResize = easyuiPanelOnResize;
$.fn.dialog.defaults.onResize = easyuiPanelOnResize;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;