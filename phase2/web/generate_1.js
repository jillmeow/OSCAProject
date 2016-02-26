/**
 * 
 * This script generates either partner, siblings, or child form 
 * if the user selects family subscription.
 * 
 * Made by INFO312 Students
 * Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid, and Hans To'o
 * 
 */

var generateForm = (function () {
    var pub = {};
    var count = 0;
    var numSibling = 1;
    var child = 1;
    var itemList;
    function showFamily() {
        if ($("#subscriptionType").val() === "family") {
            $("#familyForm").css({display: "block"});
        } else {
            $("#familyForm").css({display: "none"});
        }

    }

    function generatePartnerForm() {
        var involve = ['Basketball',
            'Chinese School', 'Newsletter',
            'Social', 'Fundraising',
            'Cultural', 'Other'];
        if (count === 0) {
            $("<h2>").text("Partner").appendTo('.partnerFormGenerate');

            $("<div>").attr({id: 'pF', class: 'columnone', display: 'block'}).appendTo('.partnerFormGenerate');
            $("<h3>").text("Contact Details: ").appendTo('#pF');
            $("<div>").attr({id: 'pD', class: 'details'}).appendTo('#pF');
            $("<label>").attr({id: 'pFN', class: 'member'}).text("First Name: ").appendTo('#pD');
            $("<input>").attr({
                id: 'partnerFirstName',
                name: 'partnerFirstName'
            }).appendTo("#pFN");

            $("<label>").attr({id: 'pLN', class: 'member'}).text("Last Name: ").appendTo("#pD");
            $("<input>").attr({
                id: 'partnerLastName',
                name: 'partnerLastName'
            }).appendTo("#pLN");

            $("<label>").attr({id: 'pA', class: 'member'}).text("Address: ").appendTo("#pD");
            $("<input>").attr({
                id: 'partnerAddress',
                name: 'partnerAddress'
            }).appendTo("#pA");

            $("<label>").attr({id: 'pP', class: 'member'}).text("Phone: ").appendTo("#pD");
            $("<input>").attr({
                id: 'partnerPhone',
                name: 'partnerPhone'
            }).appendTo("#pP");

            $("<label>").attr({id: 'pE', class: 'member'}).text("Email: ").appendTo("#pD");
            $("<input>").attr({
                id: 'partnerEmail',
                name: 'partnerEmail',
                type: 'email'
            }).appendTo("#pE");

            $("<label>").attr({
                id: 'pEl',
                class: 'member'
            }).text("Are you Chinese: ").appendTo("#pD");

            $("<select></select>").attr({
                name: 'pEligibility',
                id: 'pEligibility'
            }).appendTo("#pEl");
            $("<option>").attr({
                value: 'Yes'
            }).text("Yes").appendTo("#pEligibility");
            $("<option>").attr({
                value: 'No'
            }).text("No").appendTo("#pEligibility");

            $("<div>").attr({id: 'pAct', class: 'column', display: 'block'}).appendTo('.partnerFormGenerate');

            $("<h3>").text("Activities involved: ").appendTo("#pAct");
            $("<ul>").attr({
                class: 'activities',
                id: 'pActivity'
            }).appendTo("#pAct");
            for (i = 0; i < involve.length; i++) {
                var activity = involve[i];
                $("<li>").attr({
                    class: 'involvement',
                    id: activity.toLowerCase()
                }).appendTo("#pActivity").append($("<input>").attr({
                    class: 'partnerInvolve',
                    value: activity,
                    name: 'partnerInvolve',
                    type: 'checkbox'
                })).append($("<span>").text(activity + " "));



            }
            $("<input>").attr({
                class: 'partnerActivities',
                type: 'hidden',
                name: 'partnerActivities'
            }).appendTo("#pAct");


            count++;
        }
    }

    function generateSiblingForm() {
        var involve = ['Basketball',
            'Chinese School', 'Newsletter',
            'Social', 'Fundraising',
            'Cultural', 'Other'];

        $("<h2>").text("Sibling " + numSibling).appendTo('.siblingFormGenerate');

        $("<div>").attr({id: 'sF' + numSibling, class: 'columnone', display: 'block'}).appendTo('.siblingFormGenerate');
        $("<h3>").text("Contact Details: ").appendTo('#sF' + numSibling);
        $("<div>").attr({id: 'sD' + numSibling, class: 'details'}).appendTo('#sF' + numSibling);
        $("<label>").attr({id: 'sFN' + numSibling, class: 'member'}).text("First Name: ").appendTo('#sD' + numSibling);
        $("<input>").attr({
            id: 'siblingFirstName' + numSibling,
            name: 'siblingFirstName' + numSibling
        }).appendTo('#sFN' + numSibling);

        $("<label>").attr({id: 'sLN' + numSibling, class: 'member'}).text("Last Name: ").appendTo('#sD' + numSibling);
        $("<input>").attr({
            id: 'siblingLastName' + numSibling,
            name: 'siblingLastName' + numSibling
        }).appendTo('#sLN' + numSibling);

        $("<label>").attr({id: 'sA' + numSibling, class: 'member'}).text("Address: ").appendTo('#sD' + numSibling);
        $("<input>").attr({
            id: 'siblingAddress' + numSibling,
            name: 'siblingAddress' + numSibling
        }).appendTo('#sA' + numSibling);



        $("<label>").attr({id: 'sP' + numSibling, class: 'member'}).text("Phone: ").appendTo('#sD' + numSibling);
        $("<input>").attr({
            id: 'siblingPhone' + numSibling,
            name: 'siblingPhone' + numSibling
        }).appendTo('#sP' + numSibling);

        $("<label>").attr({id: 'sE' + numSibling, class: 'member'}).text("Email: ").appendTo('#sD' + numSibling);
        $("<input>").attr({
            id: 'siblingEmail' + numSibling,
            name: 'siblingEmail' + numSibling,
            type: 'email'
        }).appendTo('#sE' + numSibling);

        $("<label>").attr({
            id: 'sEl' + numSibling,
            class: 'member'
        }).text("Are you Chinese: ").appendTo("#sD" + numSibling);

        $("<select></select>").attr({
            name: 'sEligibility' + numSibling,
            id: 'sEligibility' + numSibling
        }).appendTo("#sEl" + numSibling);
        $("<option>").attr({
            value: 'Yes'
        }).text("Yes").appendTo("#sEligibility" + numSibling);
        $("<option>").attr({
            value: 'No'
        }).text("No").appendTo("#sEligibility" + numSibling);

        $("<div>").attr({id: 'sAct' + numSibling, class: 'column', display: 'block'}).appendTo('.siblingFormGenerate');

        $("<h3>").text("Activities involved: ").appendTo('#sAct' + numSibling);
        for (i = 0; i < involve.length; i++) {
            var activity = involve[i];

            $("<label>").attr({
                class: 'involvement'}).text(activity + " ").appendTo('#sAct' + numSibling).append($("<input>").attr({
                class: 'involvement',
                id: activity.toLowerCase(),
                value: activity,
                name: 'siblingInvolve' + numSibling,
                type: 'checkbox'
            }));

        }
        if (Cookie.get("cart") !== null) {
            itemList = $.parseJSON(Cookie.get("cart"));
            itemList.push("siblings: " + numSibling);
            for (var i = 0; i < itemList.length; i++) {
                if (itemList[i].slice(0, 8) === "siblings") {
                    itemList[i] = "siblings: " + numSibling;
                }
            }

        } else {
            itemList = [];
            itemList.push("siblings: " + numSibling);
        }
        itemList = itemList.uniqueObjects();
        Cookie.set("cart", JSON.stringify(itemList));
        numSibling++;
        console.log(numSibling);
    }

    function generateChildrenForm() {
        var involve = ['Basketball',
            'Chinese School', 'Newsletter',
            'Social', 'Fundraising',
            'Cultural', 'Other'];

        $("<h2>").text("Child " + child).appendTo('.childrenFormGenerate');

        $("<div>").attr({id: 'cF' + child, class: 'columnone', display: 'block'}).appendTo(".childrenFormGenerate");
        $("<h3>").text("Contact Details: ").appendTo('#cF' + child);
        $("<div>").attr({id: 'cD' + child, class: 'details'}).appendTo('#cF' + child);
        $("<label>").attr({id: 'cFN' + child, class: 'member'}).text("First Name: ").appendTo('#cD' + child);
        $("<input>").attr({
            id: 'childFirstName' + child,
            name: 'childFirstName' + child
        }).appendTo('#cFN' + child);

        $("<label>").attr({id: 'cLN' + child, class: 'member'}).text("Last Name: ").appendTo('#cD' + child);
        $("<input>").attr({
            id: 'childLastName' + child,
            name: 'childLastName' + child
        }).appendTo('#cLN' + child);

        $("<label>").attr({id: 'cA' + child, class: 'member'}).text("Address: ").appendTo('#cD' + child);
        $("<input>").attr({
            id: 'childAddress' + child,
            name: 'childAddress' + child
        }).appendTo('#cA' + child);

        $("<label>").attr({id: 'cP' + child, class: 'member'}).text("Phone: ").appendTo('#cD' + child);
        $("<input>").attr({
            id: 'childPhone' + child,
            name: 'childPhone' + child
        }).appendTo('#cP' + child);

        $("<label>").attr({id: 'cE' + child, class: 'member'}).text("Email: ").appendTo('#cD' + child);
        $("<input>").attr({
            id: 'childEmail' + child,
            name: 'childEmail' + child,
            type: 'email'
        }).appendTo('#cE' + child);
        
        $("<label>").attr({
            id: 'cEl' + child,
            class: 'member'
        }).text("Are you Chinese: ").appendTo("#cD" + child);

        $("<select></select>").attr({
            name: 'cEligibility' + child,
            id: 'cEligibility' + child
        }).appendTo("#cEl" + child);
        $("<option>").attr({
            value: 'Yes'
        }).text("Yes").appendTo("#cEligibility" + child);
        $("<option>").attr({
            value: 'No'
        }).text("No").appendTo("#cEligibility" + child);

        $("<div>").attr({id: 'cAct' + child, class: 'column', display: 'block'}).appendTo(".childrenFormGenerate");
        $("<h3>").text("Activities involved: ").appendTo('#cAct' + child);

        for (i = 0; i < involve.length; i++) {
            var activity = involve[i];

            $("<label>").attr({
                class: 'involvement'}).text(activity + " ").appendTo('#cAct' + child).append($("<input>").attr({
                class: 'involvement',
                value: activity,
                name: 'childrenInvolve' + child,
                type: 'checkbox'
            }));

        }
        if (Cookie.get("cart") !== null) {
            itemList = $.parseJSON(Cookie.get("cart"));
            itemList.push("child: " + child);
            for (var i = 0; i < itemList.length; i++) {
                if (itemList[i].slice(0, 5) === "child") {
                    itemList[i] = "child: " + child;
                }

            }

        } else {
            itemList = [];
            itemList.push("child: " + child);
        }
        itemList = itemList.uniqueObjects();
        Cookie.set("cart", JSON.stringify(itemList));
        child++;
        console.log(child);
    }

    function deletePartner() {
        $(".partnerFormGenerate").empty();
        count = 0;
    }

    function deleteSibling() {
        $(".siblingFormGenerate").empty();
        numSibling = 1;
    }

    function deleteChildren() {
        $(".childrenFormGenerate").empty();
        child = 1;

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

    pub.setup = function () {
        $("#partnerButton").click(generatePartnerForm);
        $("#siblingButton").click(generateSiblingForm);
        $("#childrenButton").click(generateChildrenForm);

        $("#noPartner").click(deletePartner);
        $("#noSibling").click(deleteSibling);
        $("#noChildren").click(deleteChildren);

        $("#subscriptionType").change(showFamily);


    };

    return pub;
}());

$(document).ready(generateForm.setup);