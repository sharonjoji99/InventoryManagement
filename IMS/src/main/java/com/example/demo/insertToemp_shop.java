package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertToemp_shop {
public static void updateEmployee(String username,int  s_id , int salary , int points) {
	 

    String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url
    String user     = "imsdb";
    String password = "imsdb";
    Connection con=null; 
    try
    {   
    	
    	 con = DriverManager.getConnection(url,user,password);
         System.out.println("connection estallished to Database ");
       
         PreparedStatement stmt=con.prepareStatement("insert into emp_shops values (?,?,?,?)");
         stmt.setString(1,username);
    	 stmt.setInt(2,s_id);
    	 stmt.setInt(3,salary);
    	 stmt.setInt(4,points);
    	 
         stmt.executeUpdate();
      System.out.println("Values Inserted to emp_shops table");
      
        
    }
    catch(Exception ex) 
    { 
        System.err.println(ex); 
        
    } 
    
  

}
}