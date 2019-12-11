package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class fetchItems {
public static ArrayList<inventory> fetchAllItems(int ch,boolean b) {
		

        String url      = "jdbc:oracle:thin:@127.0.0.1:1521:XE";   //database specific url.
        String user     = "imsdb";
        String password = "imsdb";
        Connection con=null; 
        ArrayList<inventory> itemSet= new ArrayList<inventory>();
		
		
        try
        {   
        	
        	con = DriverManager.getConnection(url,user,password);
            System.out.println("connection estallished for fetch Items");
        	if(b==true) {
        		PreparedStatement stmt=con.prepareStatement("SELECT category,s_id,p_id,p_name,p_mrp,discount,discounted_price,quantity from ims_inventory where s_id=?");
        		stmt.setInt(1,ch);
        		 ResultSet result = stmt.executeQuery();
        		 while(result.next()) {
                 	
                 	itemSet.add(new inventory(result.getString("category"),result.getInt("p_id"),result.getString("p_name"),result.getInt("p_mrp"),result.getInt("discount"),result.getFloat("discounted_price"),result.getInt("quantity"),result.getInt("s_id")));
                  
                 
             }
        		
        	}
        	 
        	else {
             PreparedStatement stmt=con.prepareStatement("SELECT * from ims_inventory");
             ResultSet result = stmt.executeQuery();
             
             while(result.next()) {
            	
            	 itemSet.add(new inventory(result.getString("category"),result.getInt("p_id"),result.getString("p_name"),result.getInt("p_mrp"),result.getInt("discount"),result.getFloat("discounted_price"),result.getInt("quantity"),result.getInt("s_id")));
                 
             
         }
        	}
                           
           
        }
        catch(Exception ex) 
        { 
            System.err.println(ex); 
            
        }
		fetchItems.printValues(itemSet);
		
		return itemSet;
	}
	
	
	public static void printValues(ArrayList<inventory> list){ 
    
        System.out.println("size = "+ list.size());
        for (int i = 0; i < list.size(); i++) 
        { 
          
  
            inventory data = list.get(i); 
  
          
            System.out.println(data.getp_id()+"  "+data.getp_name()); 
        } 

  }
}
