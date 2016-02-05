/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var MemberValidation = (function () {
    "use strict";
    var pub = {};

    function checkLength(textValue, min, max) {
        var length = textValue.length;
        if (max === undefined) {
            max = min;
        }
        return (length >= min && length <= max && length !== "");

    }

    function validateMember() {
        var message;
        message = 0;

        if ($("#phone").val() !== "") {
            if (checkLength($("#phone").val(), 7, 11) !== true) {
                $("#error").html("Phone number is not valid");
                message++;
            } else {
                $("#error").html("");
                //return true;
            }
        }
        //partner's phone checker
        if ($("#partnerFirstName").val() !== undefined) {
            if ($("#partnerPhone").val() !== "") {
                if (checkLength($("#partnerPhone").val(), 7, 11) !== true) {
                    $("#error").html("Phone number is not valid");
                    message++;
                } else {
                    $("#error").html("");
                    //return true;
                }
            }
        }
        var s = true;
        var numS = 1;
        while (s !== false) {
            if ($("#siblingPhone" + numS).val() !== undefined) {
                if ($("#siblingPhone" + numS).val() !== "") {
                    if (checkLength($("#siblingPhone" + numS).val(), 7, 11) !== true) {
                        $("#error").html("Phone number is not valid");
                        message++;
                    } else {
                        $("#error").html("");
                    }

                }
                numS++;
            } else {
                s = false;
            }
        }
        
        var c = true;
        var numC = 1;
        while(c !== false){
            if($("#childPhone" + numC).val() !== undefined){
                if($("#childPhone" + numC).val() !== ""){
                    if(checkLength($("#childPhone" + numC).val(), 7, 11) !== true){
                        $("#error").html("Phone number is not valid");
                        message++;
                    } else {
                        $("#error").html("");
                    }
                }
                numC++;
            } else {
                c = false;
            }
        }
        //console.log(message);
        if (message !== 0) {
            return false;
        } else {
            return true;
        }
    }
    pub.setup = function () {
        $("form").submit(validateMember);
    };
    return pub;

}());

$(document).ready(MemberValidation.setup);