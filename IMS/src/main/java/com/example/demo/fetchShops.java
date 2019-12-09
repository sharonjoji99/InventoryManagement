package com.example.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class fetchShops {
	
	public static ArrayList<shopDetails> fetchAllShops() {
		

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        ArrayList<shopDetails> shopsSet= new ArrayList<shopDetails>();
		
		
        try
        {   
        	
        	 con = DriverManager.getConnection(url,user,password);
             System.out.println("connection estallished for fetch Shops ");
             PreparedStatement stmt=con.prepareStatement("SELECT * from ims_shops");
             ResultSet result = stmt.executeQuery();
            
                           
             while(result.next()) {
            	
            	shopsSet.add(new shopDetails(result.getString("s_name"),result.getInt("s_id"),result.getString("s_loc"),result.getLong("s_phone"),result.getString("s_manager")));

             }
             
             
             fetchShops.printValues(shopsSet);
             
            
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        }
		
		
		return shopsSet;
	}
	
	
	public static void printValues(ArrayList<shopDetails> list){ 
    
        System.out.println("size = "+ list.size());
        for (int i = 0; i < list.size(); i++) 
        { 
          
  
            shopDetails data = list.get(i); 
  
          
            System.out.println(data.gets_id()+"  "+data.gets_name()); 
        } 

  }
}
