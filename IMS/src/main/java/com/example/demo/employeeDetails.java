package com.example.demo;

public class employeeDetails {
	private String name;
	private String username;
	private String password;
	private int s_id;
	private String email;
	private int age;
	private long ph_no;
	private String gender;
	private int salary;
	private int points;
	
	public employeeDetails(String name,String username,String password,int s_id,String email,int age,String gender,long ph_no,int salary,int points){
		this.name=name;
		this.username=username;
		this.password=password;
		this.email=email;
		this.age=age;
		this.ph_no=ph_no;
		this.s_id=s_id;
		this.gender=gender;
		this.points=points;
		this.salary=salary;
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
	
	
	public int gets_id() {
		return s_id;
	}
	
	public void sets_id(int s_id) {
		this.s_id=s_id;
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
	public int getsalary() {
		return salary;
	}
	
	public void setsalary(int salary) {
		this.salary=salary;
	}
	
	public int getpoints() {
		return points;
	}
	
	public void setpoints(int points) {
		this.points=points;
		
	}
}



