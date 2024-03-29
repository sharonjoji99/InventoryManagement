package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertToDb {

	
	public static void signupDetails(String usr,String pwd,int age,String name, String email,String gender,boolean ch,long phone) throws ClassNotFoundException, SQLException{
		 

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished to Database ");
            if(ch) {
             PreparedStatement stmt=con.prepareStatement("insert into ims_employee values (?,?,?,?,?,?,?)");
             stmt.setString(1,name);
        	 stmt.setString(2,usr);
        	 stmt.setString(3,pwd);
        	 stmt.setString(4,email);
        	 stmt.setInt(5, age);
        	 stmt.setString(6,gender);
        	 stmt.setLong(7, phone);
             stmt.executeUpdate();
          System.out.println("Values Inserted to employee table");
            }else {
             PreparedStatement stmt=con.prepareStatement("insert into ims_owner values (?,?,?,?,?,?,?)");
             stmt.setString(1,name);
           	 stmt.setString(2,usr);
           	 stmt.setString(3,pwd);
           	 stmt.setString(4,email);
           	 stmt.setInt(5, age);
           	 stmt.setString(6,gender);
           	 stmt.setLong(7, phone);
                stmt.executeUpdate();
             System.out.println("Values Inserted to owner table");
            }
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        } 
        
      

	}
}