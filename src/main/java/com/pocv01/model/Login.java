package com.pocv01.model;

public class Login {
	private String userId;
	private String password;
	private String response;
	
	
	
	public Login(String userId, String Password) {
		super();
		this.userId = userId;
		this.password = Password;
		this.response = "success";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/*public String getPassword() {
		return password;
	}*/
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
