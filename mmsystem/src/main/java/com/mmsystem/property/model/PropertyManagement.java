package com.mmsystem.property.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name="propertymanagements")
public class PropertyManagement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int pMgmtId;
	private String pMgmtCode;
	private String pMgmtName;
	private String pMgmtAddrLine1;
	private String pMgmtAddrLine2;
	private String pMgmtAddrLine3;
	private String pMgmtCity;
	private String pMgmtState;
	private String pMgmtZipcode5;
	private String pMgmtZipcodeExt;
	private String pMgmtPhone;
	private String pMgmtEmail;
	private String pMgmtFax;
	private String PMgmtcontact;
	
	public int getpMgmtId() {
		return pMgmtId;
	}
	public void setpMgmtId(int pMgmtId) {
		this.pMgmtId = pMgmtId;
	}
	public String getpMgmtCode() {
		return pMgmtCode;
	}
	public void setpMgmtCode(String pMgmtCode) {
		this.pMgmtCode = pMgmtCode;
	}
	public String getpMgmtName() {
		return pMgmtName;
	}
	public void setpMgmtName(String pMgmtName) {
		this.pMgmtName = pMgmtName;
	}
	public String getpMgmtAddrLine1() {
		return pMgmtAddrLine1;
	}
	public void setpMgmtAddrLine1(String pMgmtAddrLine1) {
		this.pMgmtAddrLine1 = pMgmtAddrLine1;
	}
	public String getpMgmtAddrLine2() {
		return pMgmtAddrLine2;
	}
	public void setpMgmtAddrLine2(String pMgmtAddrLine2) {
		this.pMgmtAddrLine2 = pMgmtAddrLine2;
	}
	public String getpMgmtAddrLine3() {
		return pMgmtAddrLine3;
	}
	public void setpMgmtAddrLine3(String pMgmtAddrLine3) {
		this.pMgmtAddrLine3 = pMgmtAddrLine3;
	}
	public String getpMgmtCity() {
		return pMgmtCity;
	}
	public void setpMgmtCity(String pMgmtCity) {
		this.pMgmtCity = pMgmtCity;
	}
	public String getpMgmtState() {
		return pMgmtState;
	}
	public void setpMgmtState(String pMgmtState) {
		this.pMgmtState = pMgmtState;
	}
	public String getpMgmtZipcode5() {
		return pMgmtZipcode5;
	}
	public void setpMgmtZipcode5(String pMgmtZipcode5) {
		this.pMgmtZipcode5 = pMgmtZipcode5;
	}
	public String getpMgmtZipcodeExt() {
		return pMgmtZipcodeExt;
	}
	public void setpMgmtZipcodeExt(String pMgmtZipcodeExt) {
		this.pMgmtZipcodeExt = pMgmtZipcodeExt;
	}
	public String getpMgmtPhone() {
		return pMgmtPhone;
	}
	public void setpMgmtPhone(String pMgmtPhone) {
		this.pMgmtPhone = pMgmtPhone;
	}
	public String getpMgmtEmail() {
		return pMgmtEmail;
	}
	public void setpMgmtEmail(String pMgmtEmail) {
		this.pMgmtEmail = pMgmtEmail;
	}
	public String getpMgmtFax() {
		return pMgmtFax;
	}
	public void setpMgmtFax(String pMgmtFax) {
		this.pMgmtFax = pMgmtFax;
	}
	public String getPMgmtcontact() {
		return PMgmtcontact;
	}
	public void setPMgmtcontact(String pMgmtcontact) {
		PMgmtcontact = pMgmtcontact;
	}
	
	
}
