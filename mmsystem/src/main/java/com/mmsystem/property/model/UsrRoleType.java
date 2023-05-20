package com.mmsystem.property.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name="usrroletypes")
public class UsrRoleType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int usrRoleId;
	private String usrRoleCode;
	private String usrRoleDescr;
	
	public int getUsrRoleId() {
		return usrRoleId;
	}

	public void setUsrRoleId(int usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	public String getUsrRoleCode() {
		return usrRoleCode;
	}

	public void setUsrRoleCode(String usrRoleCode) {
		this.usrRoleCode = usrRoleCode;
	}

	public String getUsrRoleDescr() {
		return usrRoleDescr;
	}

	public void setUsrRoleDescr(String usrRoleDescr) {
		this.usrRoleDescr = usrRoleDescr;
	}


	
}
