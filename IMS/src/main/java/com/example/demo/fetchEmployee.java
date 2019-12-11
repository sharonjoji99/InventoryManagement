package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class fetchEmployee {
public static ArrayList<employeeDetails> fetchAllEmployees() {
		

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        ArrayList<employeeDetails> employeeSet= new ArrayList<employeeDetails>();
		
		
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished for fetch Employees");
            //PreparedStatement stmt=con.prepareStatement("SELECT username,userid FROM ims_employee JOIN emp_shops ON ims_employee.username = emp_shops.userid");
             PreparedStatement stmt=con.prepareStatement("SELECT name,ims_employee.username,password,s_id,email,age,gender,ph_no,salary,points from ims_employee JOIN emp_shops ON ims_employee.username = emp_shops.username");
             ResultSet result = stmt.executeQuery();
            
                           
             while(result.next()) {
            	
            	employeeSet.add(new employeeDetails(result.getString("name"),result.getString("username"),result.getString("password"),result.getInt("s_id"),result.getString("email"),result.getInt("age"),result.getString("gender"),result.getLong("ph_no"),result.getInt("salary"),result.getInt("points")));
             
            
        }
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        }
		fetchEmployee.printValues(employeeSet);
		
		return employeeSet;
	}
	
	
	public static void printValues(ArrayList<employeeDetails> list){ 
    
        System.out.println("size = "+ list.size());
        for (int i = 0; i < list.size(); i++) 
        { 
          
  
            employeeDetails data = list.get(i); 
  
          
            System.out.println(data.getusername()+"  "+data.gets_id()); 
        } 

  }
}
