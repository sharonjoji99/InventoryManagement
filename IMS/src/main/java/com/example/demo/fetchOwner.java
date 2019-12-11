package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class fetchOwner {
public static ArrayList<ownerDetails> fetchAllOwners() {
		

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        ArrayList<ownerDetails> ownerSet= new ArrayList<ownerDetails>();
		
		
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished for fetch Employees");
            //PreparedStatement stmt=con.prepareStatement("SELECT username,userid FROM ims_employee JOIN emp_shops ON ims_employee.username = emp_shops.userid");
             PreparedStatement stmt=con.prepareStatement("SELECT name,username,password,email,age,gender,ph_no from ims_owner" );
             ResultSet result = stmt.executeQuery();
            
                           
             while(result.next()) {
            	
            	ownerSet.add(new ownerDetails(result.getString("name"),result.getString("username"),result.getString("password"),result.getString("email"),result.getInt("age"),result.getString("gender"),result.getLong("ph_no")));
             
            
        }
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        }
		fetchOwner.printValues(ownerSet);
		
		return ownerSet;
	}
	
	
	public static void printValues(ArrayList<ownerDetails> list){ 
    
        System.out.println("size = "+ list.size());
        for (int i = 0; i < list.size(); i++) 
        { 
          
  
            ownerDetails data = list.get(i); 
  
          
            System.out.println(data.getusername()+"  "+data.getemail()); 
        } 

  }
}
