$(document).ready(function() 
{  
	 
		$("#alertSuccess").hide();  
	    $("#alertError").hide(); 
}); 
 
 
// SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 
 
	// Form validation-------------------  
	var status = validatePatientForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 
 
	// If valid------------------------  
	var type = ($("#hidPatientIDSave").val() == "") ? "POST" : "PUT"; 

	$.ajax( 
	{  
			url : "PatientsAPI",  
			type : type,  
			data : $("#formPatient").serialize(),  
			dataType : "text",  
			complete : function(response, status)  
			{   
				onPatientSaveComplete(response.responseText, status);  
			} 
	}); 
}); 


function onPatientSaveComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully saved.");    
			$("#alertSuccess").show(); 

			$("#divPateintsGrid").html(resultSet.data);   
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		} 

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while saving.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while saving..");   
		$("#alertError").show();  
	} 

	$("#hidPatientIDSave").val("");  
	$("#formPatient")[0].reset(); 
} 

 
// UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) 
{     
	$("#hidPatientIDSave").val($(this).closest("tr").find('#hidPatientIDUpdate').val());     
	$("#pName").val($(this).closest("tr").find('td:eq(0)').text());     
	$("#pAddress").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#pEmail").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#pDate").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#nic").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#pno").val($(this).closest("tr").find('td:eq(5)').text()); 
}); 




//REMOVE===========================================
$(document).on("click", ".btnRemove", function(event) 
{  
	$.ajax(  
	{   
		url : "PatientsAPI",   
		type : "DELETE",   
		data : "pID=" + $(this).data("patientid"),   
		dataType : "text",   
		complete : function(response, status)   
		{    
			onPatientDeleteComplete(response.responseText, status);   
		}  
	}); 
}); 

function onPatientDeleteComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			
			$("#alertSuccess").text("Successfully deleted.");    
			$("#alertSuccess").show(); 
		
			$("#divPateintsGrid").html(resultSet.data); 
			
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		}
		

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while deleting.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while deleting..");   
		$("#alertError").show();  
	}
}
 
// CLIENT-MODEL========================================================================= 
function validatePatientForm() 
{  
	// NAME  
	if ($("#pName").val().trim() == "")  
	{   
		return "Insert Patient Name.";  
	} 

	// ADDRESS  
	if ($("#pAddress").val().trim() == "")  
	{   
		return "Insert Address.";  
	} 

	// EMAIL-------------------------------  
	if ($("#pEmail").val().trim() == "")  
	{   
		return "Insert Email.";  
	} 

	// DESCRIPTION------------------------  
	if ($("#pDate").val().trim() == "")  
	{   
		return "Insert Date.";  
	} 
	
	// NIC  
	if ($("#nic").val().trim() == "")  
	{   
		return "Insert NIC.";  
	} 
	
	// PHONE NO 
	//if ($("#pno").val().trim() == "")  
	//{   
	//	return "Insert Phone Number.";  
	//} 
	
	//PHONE-------------------------------
	 var tmpPhone = $("#pno").val().trim();
	if (!$.isNumeric(tmpPhone)) 
	 {
	 return "Insert numeric value for Phone Number.";
	 }

	return true; 
}