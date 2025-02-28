package com.pocv01.model;

import java.sql.Date;

public class User {
	//private Long id;
	private String userId;
	private String password;
	//private String isActive;
	//private java.util.Date creationDate;
	//private java.util.Date modifyDate;
	
	
	/*public User(Long id, String userId, String password, String isActive, java.util.Date date, java.util.Date date2) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.isActive = isActive;
		this.creationDate = date;
		this.modifyDate = date2;
		this.response = "success";
		
		doInsert();
	}
	
	public void doInsert() {
		
	}
	*/
	/*public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Date getCreationDate() {
		return (Date) creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifyDate() {
		return (Date) modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}*/
		
}
