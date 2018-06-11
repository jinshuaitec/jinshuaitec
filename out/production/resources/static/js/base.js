/**
 * 公用js抽出公共方法
 * Created by xuew on 2017/10/28.
 */

//等待遮罩
function waitMeInit(container) {
    if (!container) {
        container = "body"
    }
    $(container).waitMe({
        effect: 'bounce',
        text: '',
        bg: 'rgba(43,47,59,0.7)',
        color: '#fff',
        maxSize: '',
        textPos: 'vertical',
        fontSize: '',
        source: ''
    });
}
//移除等待加载遮罩
function removeWaitMe(container) {
    if (!container) {
        container = "body"
    }
    $(container).waitMe("hide");
}

//加载i-checks
function loadICheck() {
    $(".i-checks").iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green'
    });
}

//重写序列化方法
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}

function openSweetAlert(title, text, type, callback) {
    swal({
            title: title,
            text: text,
            type: type,//"warning", "error", "success" 和 "info"
            showCancelButton: true,
            closeOnConfirm: true,
            showLoaderOnConfirm: true,
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            imageSize: 40 * 40
        },
        function () {
            callback();
        }
    )
}

Date.prototype.FormatDate = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
