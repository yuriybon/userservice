var Timer = (function ($) {

    var intervals = [];

    var start = function (time, address, callback) {
            function checkTransaction(address,callback){
                $.get("/api/transaction/"+address, function(data){
                    if(data) callback(data);
                });
            }

            var interval = setInterval(function(){
                checkTransaction(address,callback);
            },time);
            return intervals.push(interval);
        },
        stop = function(index){
            if(intervals[index]) clearInterval(intervals[index]);
        },

        reset = function(){
            $.each(intervals, function(index, interval){
                clearInterval(interval);
            });
            intervals = [];
        }

    return {
        start: start,
        stop: stop,
        reset: reset
    };
})(jQuery);