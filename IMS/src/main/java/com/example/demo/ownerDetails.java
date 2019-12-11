package com.example.demo;

public class ownerDetails {
	private String name;
	private String username;
	private String password;

	private String email;
	private int age;
	private long ph_no;
	private String gender;
	
	
	public ownerDetails(String name,String username,String password,String email,int age,String gender,long ph_no){
		this.name=name;
		this.username=username;
		this.password=password;
		this.email=email;
		this.age=age;
		this.ph_no=ph_no;
		
		this.gender=gender;
		
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getusername() {
		return username;
	}
	
	public void setusername(String username) {
		this.username=username;
	}
	public String getpassword() {
		return password;
	}
	
	
	
	public void setpassword(String password) {
		this.password=password;
	}
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	
	public void setage(int age) {
		this.age=age;
	}
	public int getage() {
		return age;
	}
	
	public void setph_no(long ph_no) {
		this.ph_no=ph_no;
		
	}
	public long getph_no() {
		return ph_no;
	}
	public String getgender() {
		return gender;
	}
	
	public void setgender(String gender) {
		this.gender=gender;
	}

}



