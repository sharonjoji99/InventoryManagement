package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class increaseQuantity {
	public static void addQuantity(int p_id,int quantity) throws ClassNotFoundException, SQLException{
		 

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished to Database ");
             System.out.println("Enetered Details : quantity:"+quantity+"  p_id:"+p_id); 
             PreparedStatement stmt=con.prepareStatement("update ims_inventory set quantity=quantity+? where p_id=?");
             
             stmt.setInt(1,quantity);
        	 stmt.setInt(2,p_id);
        	stmt.executeUpdate();
          System.out.println("Increased Quantity");
            
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        } 
        
      

	}
}
