<%@ page import="com.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.4.1.min.js"></script> 
<script src="Components/patient.js"></script> 
</head>
<body>
<div class="container"> 
	<div class="row">  
		<div class="col-6"> 
			<h1>PATIENT MANAGEMENT</h1>
				<form id="formPatient" name="formPatient" method="post" action="Patients.jsp">  
					Patient Name:   
					<input id="pName" name="pName" type="text"  class="form-control form-control-sm"> 
					<br> Address:   
  					<input id="pAddress" name="pAddress" type="text" class="form-control form-control-sm">   
					<br> Email:   
  					<input id="pEmail" name="pEmail" type="text"  class="form-control form-control-sm">   
					<br> Date:   
  					<input id="pDate" name="pDate" type="date" class="form-control form-control-sm">   
  					<br> NIC:   
  					<input id="nic" name="nic" type="text" class="form-control form-control-sm">
  					<br> Phone Number:   
  					<input id="pno" name="pno" type="text"  class="form-control form-control-sm">
					<br>  
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					<input type="hidden" id="hidPatientIDSave" name="hidPatientIDSave" value=""> 
				</form>
				
				<div id="alertSuccess" class="alert alert-success"> </div>
				
			   <div id="alertError" class="alert alert-danger"></div>
				
			   <br>
				<div id="divPateintsGrid">
					<%
						Patient patientObj = new Patient();
						out.print(patientObj.readPatients());
					%>
				</div>
				
				 
			</div>
		</div>
</div>
 
</body>
</html>