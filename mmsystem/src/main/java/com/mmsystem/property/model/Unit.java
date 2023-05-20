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
@Table(name="units")
public class Unit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int unitId;
	private String unitCode;
	private String unitType;
	private String unitName;
	private String unitAddrLine1;
	private String unitAddrLine2;
	private String unitAddrLine3;
	private String unitCity;
	private String unitState;
	private String unitZipcode5;
	private String unitZipcodeExt;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "belongToPropId" , nullable=false)
	private MmsProperty unitBelongToProp ;
	
		public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitAddrLine1() {
		return unitAddrLine1;
	}

	public void setUnitAddrLine1(String unitAddrLine1) {
		this.unitAddrLine1 = unitAddrLine1;
	}

	public String getUnitAddrLine2() {
		return unitAddrLine2;
	}

	public void setUnitAddrLine2(String unitAddrLine2) {
		this.unitAddrLine2 = unitAddrLine2;
	}

	public String getUnitAddrLine3() {
		return unitAddrLine3;
	}

	public void setUnitAddrLine3(String unitAddrLine3) {
		this.unitAddrLine3 = unitAddrLine3;
	}

	public String getUnitCity() {
		return unitCity;
	}

	public void setUnitCity(String unitCity) {
		this.unitCity = unitCity;
	}

	public String getUnitState() {
		return unitState;
	}

	public void setUnitState(String unitState) {
		this.unitState = unitState;
	}

	public String getUnitZipcode5() {
		return unitZipcode5;
	}

	public void setUnitZipcode5(String unitZipcode5) {
		this.unitZipcode5 = unitZipcode5;
	}

	public String getUnitZipcodeExt() {
		return unitZipcodeExt;
	}

	public void setUnitZipcodeExt(String unitZipcodeExt) {
		this.unitZipcodeExt = unitZipcodeExt;
	}

	public MmsProperty getUnitBelongToProp() {
		return unitBelongToProp;
	}

	public void setUnitBelongToProp(MmsProperty unitBelongToProp) {
		this.unitBelongToProp = unitBelongToProp;
	}

		
}
