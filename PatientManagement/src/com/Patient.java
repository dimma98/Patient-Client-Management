package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


public class Patient {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/health?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertPatient(String name, String address, String email, String date, String nic, String pno)  
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{return "Error while connecting to the database for inserting."; } 
	 
			// create a prepared statement 
			String query = " insert into register1(`pID`,`pName`,`pAddress`,`pEmail`,`pDate`,`nic`,`pno`)"
					 + " values (?, ?, ?, ?, ?, ?, ?)";
	 
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, name);
			 preparedStmt.setString(3, address);
			 preparedStmt.setString(4, email);
			 preparedStmt.setString(5, date);
			 preparedStmt.setString(6, nic);
			 preparedStmt.setString(7, pno);
			
			// execute the statement    
			preparedStmt.execute();    
			con.close(); 
	   
			String newPatients = readPatients(); 
			output =  "{\"status\":\"success\", \"data\": \"" + newPatients + "\"}";    
		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the Patient.\"}";  
			System.err.println(e.getMessage());   
		} 
		
	  return output;  
	} 
	
	
	public String readPatients()  
	{   
		String output = ""; 
	
		try   
		{    
			Connection con = connect(); 
		
			if (con == null)    
			{
				return "Error while connecting to the database for reading."; 
			} 
	 
			// Prepare the html table to be displayed    
			output = "<table border=\'1\'><tr><th>Patient Name</th><th>Address</th><th>Email</th><th>Date</th><th>NIC</th><th>Phone No</th><th>Update</th><th>Remove</th></tr>";
	 
			String query = "select * from register1";    
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
	 
			// iterate through the rows in the result set    
			while (rs.next())    
			{     
				String pID = Integer.toString(rs.getInt("pID"));
				 String pName = rs.getString("pName");
				 String pAddress = rs.getString("pAddress");
				 String pEmail = rs.getString("pEmail");
				 String pDate = rs.getString("pDate");
				 String nic = rs.getString("nic");
				 String pno = rs.getString("pno"); 
			
	 
				// Add into the html table 
				output += "<tr><td><input id=\'hidPatientIDUpdate\' name=\'hidPatientIDUpdate\' type=\'hidden\' value=\'" + pID + "'>" 
							+ pName + "</td>"; 
				output += "<td>" + pAddress + "</td>";
				output += "<td>" + pEmail + "</td>";
				output += "<td>" + pDate + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + pno + "</td>";
				 
	 
				// buttons     
				output +="<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"       
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-patientid='" + pID + "'>" + "</td></tr>"; 
			
			}
			con.close(); 
	 
			// Complete the html table    
			output += "</table>";   
		}   
		catch (Exception e)   
		{    
			output = "Error while reading the patient.";    
			System.err.println(e.getMessage());   
		} 
	 
		return output;  
	}
	
	public String updatePatient(String ID, String name, String address, String email, String date, String nic, String pno)  
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{return "Error while connecting to the database for updating."; } 
	 
			// create a prepared statement    
			String query = "UPDATE register1 SET pName=?,pAddress=?,pEmail=?,pDate=?,nic=?,pno=?" 
					   + "WHERE pID=?";  
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			preparedStmt.setString(1, name);
			   preparedStmt.setString(2, address);
			   preparedStmt.setString(3, email);
			   preparedStmt.setString(4, date);
			   preparedStmt.setString(5, nic);
			   preparedStmt.setString(6, pno);
			   preparedStmt.setInt(7, Integer.parseInt(ID)); 
	 
			// execute the statement    
			preparedStmt.execute();    
			con.close(); 
	 
			String newPatients = readPatients();    
			output = "{\"status\":\"success\", \"data\": \"" + newPatients + "\"}";    
		}   
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while updating the patient.\"}";   
			System.err.println(e.getMessage());   
		} 
	 
	  return output;  
	} 
	
	public String deletePatient(String pID)   
	{   
		String output = ""; 
	 
		try   
		{    
			Connection con = connect(); 
	 
			if (con == null)    
			{
				return "Error while connecting to the database for deleting."; 
				
			} 
	 
			// create a prepared statement    
			String query = "delete from register1 where pID=?"; 
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			// binding values    
			preparedStmt.setInt(1, Integer.parseInt(pID)); 
	 
			// execute the statement    
			preparedStmt.execute();    
			con.close(); 
	 
			String newPatients = readPatients();    
			output = "{\"status\":\"success\", \"data\": \"" +  newPatients + "\"}";    
		}   
		catch (Exception e)   
		{    
			output = "Error while deleting the patient.";    
			System.err.println(e.getMessage());   
		} 
	 
		return output;  
	}
	
}
