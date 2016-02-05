var generateForm = (function(){
	var pub = {};
        var count = 0;
        var numSibling = 0;
        var child = 0;
        
        function showFamily(){
            if($("#subscriptionType").val() === "family"){  
                $("#familyForm").css({display: "block"});
            } else {
               $("#familyForm").css({display: "none"});
            }
            
        }
	
	function generatePartnerForm(){
            var involve = ['basketball', 
                'chineseSchool', 'newsletter', 
                'social', 'fundraising', 
                'cultural', 'other'];
            if(count === 0){
		$("<label>").text("First Name: ").appendTo(".partnerFormGenerate");
		$("<input>").attr({
			id: 'partnerFirstName',
			name: 'partnerFirstName'        
		}).appendTo(".partnerFormGenerate");
                
		$("<label>").text("Last Name: ").appendTo(".partnerFormGenerate");
		$("<input>").attr({
			id: 'partnerLastName',
			name: 'partnerLastName'	
		}).appendTo(".partnerFormGenerate");
                
		$("<label>").text("Address: ").appendTo(".partnerFormGenerate");                
		$("<input>").attr({
			id: 'partnerAddress',
			name: 'partnerAddress'
		}).appendTo(".partnerFormGenerate");
                
		$("<label>").text("Post Code: ").appendTo(".partnerFormGenerate");                
		$("<input>").attr({
			id: 'partnerPostCode',
			name: 'partnerPostCode'
		}).appendTo(".partnerFormGenerate");                
                
 		$("<label>").text("Phone: ").appendTo(".partnerFormGenerate");                
		$("<input>").attr({
			id: 'partnerPhone',
			name: 'partnerPhone'
		}).appendTo(".partnerFormGenerate");
                
		$("<label>").text("Email: ").appendTo(".partnerFormGenerate");                
		$("<input>").attr({
			id: 'partnerEmail',
			name: 'partnerEmail'
		}).appendTo(".partnerFormGenerate");
		$("<label>").text("Activities involved: ").appendTo(".partnerFormGenerate");
                for(i=0; i < involve.length; i++){
                    var activity = involve[i];
                    
                    $("<input>").attr({
                        value: activity,
                        name: 'partnerInvolve',
                        type: 'checkbox'
                    }).appendTo(".partnerFormGenerate");
                    activity = activity.substring(0,1).toUpperCase() + activity.substring(1, activity.length);
                    
                    $("<label>").text(activity + " ").appendTo(".partnerFormGenerate");
                    if(activity === 'Other'){
                        $("<input>").attr({
                            type: 'text',
                            name: 'partnerOtherForm'
                        }).appendTo(".partnerFormGenerate");
                    }
                }
                count++;
            } 
	}

	function generateSiblingForm(){
           var involve = ['basketball', 
                'chineseSchool', 'newsletter', 
                'social', 'fundraising', 
                'cultural', 'other'];
            
		$("<label>").text("First Name: ").appendTo(".siblingFormGenerate");
		$("<input>").attr({
			id: 'siblingFirstName' +numSibling,
			name: 'siblingFirstName'+numSibling        
		}).appendTo(".siblingFormGenerate");
                
		$("<label>").text("Last Name: ").appendTo(".siblingFormGenerate");
		$("<input>").attr({
			id: 'siblingLastName'+numSibling,
			name: 'siblingLastName'+numSibling	
		}).appendTo(".siblingFormGenerate");
                
		$("<label>").text("Address: ").appendTo(".siblingFormGenerate");                
		$("<input>").attr({
			id: 'siblingAddress'+numSibling,
			name: 'siblingAddress'+numSibling
		}).appendTo(".siblingFormGenerate");
                
		$("<label>").text("Post Code: ").appendTo(".siblingFormGenerate");                
		$("<input>").attr({
			id: 'siblingPostCode'+numSibling,
			name: 'siblingPostCode'+numSibling
		}).appendTo(".siblingFormGenerate");                
                
 		$("<label>").text("Phone: ").appendTo(".siblingFormGenerate");                
		$("<input>").attr({
			id: 'siblingPhone'+numSibling,
			name: 'siblingPhone'+numSibling
		}).appendTo(".siblingFormGenerate");
                
		$("<label>").text("Email: ").appendTo(".siblingFormGenerate");                
		$("<input>").attr({
			id: 'siblingEmail'+numSibling,
			name: 'siblingEmail'+numSibling
		}).appendTo(".siblingFormGenerate");
		$("<label>").text("Activities involved: ").appendTo(".siblingFormGenerate");
                for(i=0; i < involve.length; i++){
                    var activity = involve[i];
                    
                    $("<input>").attr({
                        value: activity,
                        name: 'siblingInvolve'+numSibling,
                        type: 'checkbox'
                    }).appendTo(".siblingFormGenerate");
                    activity = activity.substring(0,1).toUpperCase() + activity.substring(1, activity.length);
                    
                    $("<label>").text(activity + " ").appendTo(".siblingFormGenerate");
                    if(activity === 'Other'){
                        $("<input>").attr({
                            type: 'text',
                            name: 'siblingOtherForm'+numSibling
                        }).appendTo(".siblingFormGenerate");
                    }
                }
                numSibling++;
                console.log(numSibling);
                Cookie.set("sibling", numSibling);
                $(".numSiblings").val(numSibling);
                
	}

	function generateChildrenForm(){
           var involve = ['basketball', 
                'chineseSchool', 'newsletter', 
                'social', 'fundraising', 
                'cultural', 'other'];
            
		$("<label>").text("First Name: ").appendTo(".childrenFormGenerate");
		$("<input>").attr({
			id: 'childFirstName' +child,
			name: 'childFirstName'+child        
		}).appendTo(".childrenFormGenerate");
                
		$("<label>").text("Last Name: ").appendTo(".childrenFormGenerate");
		$("<input>").attr({
			id: 'childLastName'+child,
			name: 'childLastName'+child	
		}).appendTo(".childrenFormGenerate");
                
		$("<label>").text("Address: ").appendTo(".childrenFormGenerate");                
		$("<input>").attr({
			id: 'childAddress'+child,
			name: 'childAddress'+child
		}).appendTo(".childrenFormGenerate");
                
		$("<label>").text("Post Code: ").appendTo(".childrenFormGenerate");                
		$("<input>").attr({
			id: 'childPostCode'+child,
			name: 'childPostCode'+child
		}).appendTo(".childrenFormGenerate");                
                
 		$("<label>").text("Phone: ").appendTo(".childrenFormGenerate");                
		$("<input>").attr({
			id: 'childPhone'+child,
			name: 'childPhone'+child
		}).appendTo(".childrenFormGenerate");
                
		$("<label>").text("Email: ").appendTo(".childrenFormGenerate");                
		$("<input>").attr({
			id: 'childEmail'+child,
			name: 'childEmail'+child
		}).appendTo(".childrenFormGenerate");
		$("<label>").text("Activities involved: ").appendTo(".childrenFormGenerate");
                for(i=0; i < involve.length; i++){
                    var activity = involve[i];
                    
                    $("<input>").attr({
                        value: activity,
                        name: 'childInvolve'+child,
                        type: 'checkbox'
                    }).appendTo(".childrenFormGenerate");
                    activity = activity.substring(0,1).toUpperCase() + activity.substring(1, activity.length);
                    
                    $("<label>").text(activity + " ").appendTo(".childrenFormGenerate");
                    if(activity === 'Other'){
                        $("<input>").attr({
                            type: 'text',
                            name: 'childOtherForm'+child
                        }).appendTo(".childrenFormGenerate");
                    }
                }
                child++;
                Cookie.set("child", child);
                console.log(child);
                
	}
        
        function deletePartner(){
            $(".partnerFormGenerate").empty();
            count = 0;
        }
        
        function deleteSibling(){
            $(".siblingFormGenerate").empty();
            numSibling = 0;
        }
        
        function deleteChildren(){
            $(".childrenFormGenerate").empty();
            child = 0;
            
        }
        

	pub.setup = function(){
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