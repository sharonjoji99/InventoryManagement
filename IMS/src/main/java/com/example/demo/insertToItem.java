package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertToItem {
	public static void insertItem(String p_name,int p_id,String category,int quantity, int p_mrp,int discount, float discounted_price) throws ClassNotFoundException, SQLException{
		 

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished to Database ");
           
             PreparedStatement stmt=con.prepareStatement("insert into ims_inventory values (?,?,?,?,?,?)");
             stmt.setString(1,category);
        	 stmt.setInt(2,p_id);
        	 stmt.setString(3,p_name);
        	 stmt.setInt(4,p_mrp);
        	 stmt.setInt(5,discount);
        	 stmt.setFloat(6, discounted_price);
        	 stmt.setInt(7, quantity);
             stmt.executeUpdate();
          System.out.println("Values Inserted to items table");
          
            
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        } 
        
      

	}

}
