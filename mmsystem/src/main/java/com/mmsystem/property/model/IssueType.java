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
@Table(name="issuetypes")
public class IssueType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int issueTypeId;
	private String issueTypeCode;
	private String issueTypeDescr;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "issueType")
	private List<MaintenanceIssue> maintenanceIssues = new ArrayList<>();
	
	public int getIssueTypeId() {
		return issueTypeId;
	}
	public void setIssueTypeId(int issueTypeId) {
		this.issueTypeId = issueTypeId;
	}
	public String getIssueTypeCode() {
		return issueTypeCode;
	}
	public void setIssueTypeCode(String issueTypeCode) {
		this.issueTypeCode = issueTypeCode;
	}
	public String getIssueTypeDescr() {
		return issueTypeDescr;
	}
	public void setIssueTypeDescr(String issueTypeDescr) {
		this.issueTypeDescr = issueTypeDescr;
	}
	public List<MaintenanceIssue> getMaintenanceIssues() {
		return maintenanceIssues;
	}
	public void setMaintenanceIssues(List<MaintenanceIssue> maintenanceIssues) {
		this.maintenanceIssues = maintenanceIssues;
	}

	
}
