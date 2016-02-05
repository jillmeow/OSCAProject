var involve = (function (){
    var pub = {};
    
    function getAllActivities(){
        $(".allActivities").val(Cookie.get("cart"));
        Cookie.clear("cart");
    }

    Array.prototype.uniqueObjects = function () {
        function compare(a, b) {
            for (var prop in a) {
                if (a[prop] !== b[prop]) {
                    return false;
                }
            }
            return true;
        }
        return this.filter(function (item, index, list) {
            for (var i = 0; i < index; i++) {
                if (compare(item, list[i])) {
                    return false;
                }
            }
            return true;
        });

    };
    
    pub.setup = function(){
        $("form").submit(getAllActivities);
        
    };
    return pub;
}());

$(document).ready(involve.setup);