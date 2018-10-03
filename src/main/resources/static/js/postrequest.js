$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#customerForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	// PREPARE FORM DATA
    	var formData = {
    			name : $("#name").val(),
    			age : $("#age").val(),
    			address : {
    		    	street : $("#street").val(),
    		    	postcode : $("#postcode").val()
    		    }
    	}
    	
    	console.log("formData before post: " + formData);
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "api/customer/save",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"--> {name: " + result.data.name + 
													", age: " + result.data.age +
													", street: " + result.data.address.street +
													", postcode: " + result.data.address.postcode +"}</p>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#name").val("");
    	$("#age").val("");
    	$("#street").val("");
    	$("#postcode").val("");
    }
})