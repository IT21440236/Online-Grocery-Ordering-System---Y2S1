package com.Model;

public class Employee {
	
	private int eid;
	private String username;
	private String email;
	private String phone;
	private String password;
	public Employee(int eid, String username, String email, String phone, String password) {
		
		this.eid = eid;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public int getEid() {
		return eid;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}

}
