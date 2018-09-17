var Utils = (function () {

    var getText = function (value){
            return value || value === 'true' ? 'Yes' : 'No';
        },
        formatTime = function (timeInSec, locale){
            if (timeInSec <=0){
                return 'N/A';
            }
            var date = new Date(timeInSec*1000);
            return date.toLocaleString(locale);
        };

    return {
        getText: getText,
        formatTime: formatTime
    };
})();