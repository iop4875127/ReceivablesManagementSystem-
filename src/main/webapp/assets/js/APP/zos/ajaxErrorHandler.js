$(document).ready(function () {

    $("#form-alerts").window({
        height: 150,
        width: 610,
        top: ($(window).height() - 150) * 0.2,
        left: ($(window).width() - 610) * 0.4,
        modal: true,
        closed: true,
        minimizable: false,
        collapsible: false,
        maximizable: false,
        resizable: false,
        title: "系统错误"
    });

    $("#closeError").click(function () {
        $("#form-alerts").window("close");
    });

    $.ajaxSetup({
        cache: false,
        error: function (xhr, status, e) {
            var $alerts = $('#form-alerts');
            $alerts.find('.danger').empty();
            var validationErrors = $alerts.find('.danger');
            if (xhr) {
                $(validationErrors).append("<strong>" + jQuery.parseJSON(xhr.responseText).Message + "</strong>，请联系管理员");
            }
            $("#form-alerts").window("open");
        }
    });
});