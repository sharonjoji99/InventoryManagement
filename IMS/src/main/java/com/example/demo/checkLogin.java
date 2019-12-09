package com.example.demo;
import java.sql.*;

public class checkLogin {
 
	public static boolean flag=false;
	public static void verifyPwd(String u,String p,char role) throws ClassNotFoundException, SQLException{
		 

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished to Database ");
             if(role=='o') {
             PreparedStatement stmt=con.prepareStatement("SELECT username,password from ims_owner where username=?");
        	 stmt.setString(1,u);
             ResultSet result = stmt.executeQuery();
             while (result.next()) {
            	  String usr =result.getString("username");
            	  String pwd =result.getString("password");
            	  System.out.println("Database Credentials : usr= "+usr +"  pwd=" +pwd+ "\n");
            	  
            	  if(pwd.equals(p)) {
            		  flag=true;
            		  System.out.println(flag);
            		  break;
            		  }
            		  else {
            			  flag=false;
            			  System.out.println(flag+"faaak");
            			  
            			  }
            	  }
        
        }else {
        	PreparedStatement stmt=con.prepareStatement("SELECT username,password from ims_employee where username=?");
       	    stmt.setString(1,u);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
           	 
           	  String pwd =result.getString("password");
           	  String usr =result.getString("username");
           	  System.out.println("Database Credentials : usr= "+usr +"  pwd=" +pwd+ "\n");
           	  
           	  
           	  if(pwd.equals(p)) {
           		  flag=true;
           		  System.out.println(flag);
           		  }
           		  else {
           			  flag=false;
           			  System.out.println(flag+"faaak");
           			  }
           	  }
        	
        }
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        } 
        
      

	}
}
       
        



