package com.example.demo;

public class shopDetails {

	private String s_name;
	private int s_id;
	private String s_loc;
	private long s_phone;
	private String s_manager;
	
	public shopDetails(String x,int a,String y,long b,String z) {
		s_name=x;
		s_id=a;
		s_loc=y;
		s_phone=b;
		s_manager=z;
	}
	public String gets_name() {
	        return s_name;
	    }
	 public void  sets_name(String s_name) {
	        this.s_name=s_name;    }
	    
	    
	 
		public int gets_id() {
	        return s_id;
	        }
	 public void  sets_id(int s_id) {
	        this.s_id=s_id;    }
	    
	 
	 
		public String gets_loc() {
	        return s_loc;
	    }
	 public void  sets_loc(String s_loc) {
	        this.s_loc=s_loc;    }
	    
	 
	 
		public long gets_phone() {
	        return s_phone;
	    }
	 public void  sets_name(long s_phone) {
	        this.s_phone=s_phone;    }
	    
	 
		public String gets_manager() {
	        return s_manager;
	    }
	 public void  sets_manager(String s_manager) {
	        this.s_manager=s_manager;    }
	    
	
}  

	

