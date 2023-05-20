package com.mmsystem.property.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity  
@Table(name="userstatus") 
public class UserStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int userStatusId;
	private String userStatusCode;
	private String userStatusDescr;
	
	public int getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(int userStatusId) {
		this.userStatusId = userStatusId;
	}

	public String getUserStatusCode() {
		return userStatusCode;
	}

	public void setUserStatusCode(String userStatusCode) {
		this.userStatusCode = userStatusCode;
	}

	public String getUserStatusDescr() {
		return userStatusDescr;
	}

	public void setUserStatusDescr(String userStatusDescr) {
		this.userStatusDescr = userStatusDescr;
	}

	
}
