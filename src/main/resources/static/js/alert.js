var Alert = (function ($) {

    function showAlert(type, message, data){
        var openDiv = "<div class='alert alert-dismissible alert-"+type+"' role='alert'>",
            closeButton = "<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>",
            closeDiv = "</div>",
            text = data?message+" "+JSON.stringify(data):message,
            html = openDiv+closeButton+text+closeDiv;
        $(html).appendTo(".header");
    }

    var success = function (message, data) {
            showAlert('success', message, data);
        },
        info = function (message, data){
            showAlert('info', message, data);
        },
        warning = function (message, data){
            showAlert('warning', message, data);
        },
        error = function (message, error){
            showAlert('danger', message, error);
        }

    return {
        success: success,
        info: info,
        warning: warning,
        error: error
    };
})(jQuery);