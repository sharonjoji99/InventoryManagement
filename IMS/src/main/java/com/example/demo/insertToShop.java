package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertToShop {
	public static void shopDetails(String s_name,int s_id,String s_loc,String s_manager, long s_phone) throws ClassNotFoundException, SQLException{
		 

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished to Database ");
           
             PreparedStatement stmt=con.prepareStatement("insert into ims_shops values (?,?,?,?,?)");
             stmt.setString(1,s_name);
        	 stmt.setInt(2,s_id);
        	 stmt.setString(3,s_loc);
        	 stmt.setLong(4,s_phone);
        	 stmt.setString(5, s_manager);
        	
             stmt.executeUpdate();
          System.out.println("Values Inserted to shops table");
          
            
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        } 
        
      

	}

}
