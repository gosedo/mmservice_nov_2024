package com.mmsystem.property.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity  
@Table(name="mmsproperties")
public class MmsProperty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int propertyId;
	private String proCode;
	private String proName;
	private String proAddrLine1;
	private String proAddrLine2;
	private String proAddrLine3;
	private String proCity;
	private String proState;
	private String proZipcode5;
	private String proZipcodeExt;
	private String proPhone;
	private String proEmail;
	private String proFax;
	private String contact;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proMgmtID" , nullable=false)
	private PropertyManagement proManagement;

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProAddrLine1() {
		return proAddrLine1;
	}

	public void setProAddrLine1(String proAddrLine1) {
		this.proAddrLine1 = proAddrLine1;
	}

	public String getProAddrLine2() {
		return proAddrLine2;
	}

	public void setProAddrLine2(String proAddrLine2) {
		this.proAddrLine2 = proAddrLine2;
	}

	public String getProAddrLine3() {
		return proAddrLine3;
	}

	public void setProAddrLine3(String proAddrLine3) {
		this.proAddrLine3 = proAddrLine3;
	}

	public String getProCity() {
		return proCity;
	}

	public void setProCity(String proCity) {
		this.proCity = proCity;
	}

	public String getProState() {
		return proState;
	}

	public void setProState(String proState) {
		this.proState = proState;
	}

	public String getProZipcode5() {
		return proZipcode5;
	}

	public void setProZipcode5(String proZipcode5) {
		this.proZipcode5 = proZipcode5;
	}

	public String getProZipcodeExt() {
		return proZipcodeExt;
	}

	public void setProZipcodeExt(String proZipcodeExt) {
		this.proZipcodeExt = proZipcodeExt;
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	public String getProEmail() {
		return proEmail;
	}

	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}

	public String getProFax() {
		return proFax;
	}

	public void setProFax(String proFax) {
		this.proFax = proFax;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public PropertyManagement getProManagement() {
		return proManagement;
	}

	public void setProManagement(PropertyManagement proManagement) {
		this.proManagement = proManagement;
	}
	
	
	
}
