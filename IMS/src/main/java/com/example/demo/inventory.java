package com.example.demo;

public class inventory {
  
	 private String category;
	 private int p_id;
	 private String p_name;
	 private int p_mrp;
	 private int discount;
	 private float discounted_price;
	 private int quantity;
	 
	 public inventory(String a,int b,String c,int d,int e,float f,int g) {
		 category=a;
		 p_id=b;
		 p_name=c;
		 p_mrp=d;
		 discount=e;
		 discounted_price=f;
		 quantity=g;
	 }
	 
	  public String getcategory() {
		 return category;
	 }
	  
	  public void setcategory(String category) {
			 this.category=category;
		 }
	  
	  
	  public int getp_id() {
			 return p_id ;
		 }
		  
     public void set_category(int p_id) {
				 this.p_id=p_id;
			 }
		  
		  
		  
		  public String getp_name() {
				 return p_name;
			 }
			  
			  public void setp_name(String p_name) {
					 this.p_name=p_name;
				 }
			  
			  
			  
			  public int getp_mrp() {
					 return p_mrp;
				 }
				  
				  public void setp_mrp(int p_mrp) {
						 this.p_mrp=p_mrp;
					 }
				  
				  
				  
				  public int getdiscount() {
						 return discount;
					 }
					  
					  public void setdiscount(int discount) {
							 this.discount=discount;
						 }
					  
					  
					  
					  public float getdiscounted_price() {
							 return discounted_price;
						 }
						  
						  public void setdiscounted_price(float discounted_price) {
								 this.discounted_price=discounted_price;
							 }
						  
						  
						  
						  public int getquantity() {
								 return quantity;
							 }
							  
							  public void setquantity(int quantity) {
									 this.quantity=quantity;
								 }
}
