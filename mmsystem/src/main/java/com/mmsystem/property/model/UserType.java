package com.mmsystem.property.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity  
@Table(name="usertypes")
public class UserType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int userTypeId;
	private String userTypeCode;
	private String usertypeDesc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userType")
	private List<User> user = new ArrayList<>();
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTypeCode() {
		return userTypeCode;
	}
	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}
	public String getUsertypeDesc() {
		return usertypeDesc;
	}
	public void setUsertypeDesc(String usertypeDesc) {
		this.usertypeDesc = usertypeDesc;
	}
	
	
	
	
	
}
