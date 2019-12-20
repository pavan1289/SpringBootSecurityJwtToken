package com.example.demo.model;

public class JWTUser {

	String userName;
	long setID;
	String role;
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setID(long setID) {
		this.setID=setID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getSetID() {
		return setID;
	}
	public void setSetID(long setID) {
		this.setID = setID;
	}
	public String getUserName() {
		return userName;
	}
	
	

}
