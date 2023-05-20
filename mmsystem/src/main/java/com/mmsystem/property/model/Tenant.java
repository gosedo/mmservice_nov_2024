package com.mmsystem.property.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity  
@Table(name="Tenants")
public class Tenant {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "tenantId")
    private int tenantId;
	@ManyToOne(cascade = CascadeType.ALL)
	private User tenantInfo;
	@ManyToOne(cascade = CascadeType.ALL)
	private Unit tenantUnit;
	private boolean isCurrent;
	private LocalDateTime createdOnDate;
	private LocalDateTime statusModifiedDate;
	
	
	public int getTenantId() {
		return tenantId;
	}
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	
	public User getTenantInfo() {
		return tenantInfo;
	}
	public void setTenantInfo(User tenantInfo) {
		this.tenantInfo = tenantInfo;
	}
	public Unit getTenantUnit() {
		return tenantUnit;
	}
	public void setTenantUnit(Unit tenantUnit) {
		this.tenantUnit = tenantUnit;
	}
	public boolean isCurrent() {
		return isCurrent;
	}
	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	public LocalDateTime getCreatedOnDate() {
		return createdOnDate;
	}
	public void setCreatedOnDate(LocalDateTime createdOnDate) {
		this.createdOnDate = createdOnDate;
	}
	public LocalDateTime getStatusModifiedDate() {
		return statusModifiedDate;
	}
	public void setStatusModifiedDate(LocalDateTime statusModifiedDate) {
		this.statusModifiedDate = statusModifiedDate;
	}
		
}
