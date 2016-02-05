var involve = (function (){
    var pub = {};
    var itemList;

    function includeActivity() {
        if ($(this).is(":checked")) {
            console.log($(this).val());
            if (Cookie.get("cart") !== null) {
                itemList = $.parseJSON(Cookie.get("cart"));
            } else {
                itemList = [];
            }
            itemList.push($(this).val());
            itemList = itemList.uniqueObjects();
            Cookie.set("cart", JSON.stringify(itemList));
        } else if (!$(this).is(":checked")) {
            console.log($(this).val() + " is unchecked");
            //remove social from the cart
            itemList = $.parseJSON(Cookie.get("cart"));

            for (i = 0; i < itemList.length; i++) {
                if (itemList[i] === $(this).val()) {
                    itemList.splice(i, 1);
                    console.log($(this).val() + " has been removed from your involvement");
                }

            }
            Cookie.set("cart", JSON.stringify(itemList));
        }

    }
    
    function getAllActivities(){
        var activities = $.parseJSON(Cookie.get("cart"));
        var allActivities = "";
        for(var i = 0; i < activities.length; i++){
            allActivities += activities[i] + " ";
            
        }
        //console.log(allActivities);
        $(".allActivities").val(allActivities + Cookie.get("child") + " " + Cookie.get("sibling"));
        //$(".child").val(Cookie.get("child"));
        //$(".numSiblings").val(Cookie.get("sibling"));
        Cookie.clear("cart");
        Cookie.clear("child");
        Cookie.clear("sibling");
        
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
        $(".involvement").click(includeActivity);
        $("form").submit(getAllActivities);
        
    };
    return pub;
}());

$(document).ready(involve.setup);