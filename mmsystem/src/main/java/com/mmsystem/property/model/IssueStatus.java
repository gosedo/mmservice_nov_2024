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
@Table(name="issuestatus")
public class IssueStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int issueStatusId;
	private String issueStatusCode;
	private String issueStatusDescr;
	
	public int getIssueStatusId() {
		return issueStatusId;
	}
	public void setIssueStatusId(int issueStatusId) {
		this.issueStatusId = issueStatusId;
	}
	public String getIssueStatusCode() {
		return issueStatusCode;
	}
	public void setIssueStatusCode(String issueStatusCode) {
		this.issueStatusCode = issueStatusCode;
	}
	public String getIssueStatusDescr() {
		return issueStatusDescr;
	}
	public void setIssueStatusDescr(String issueStatusDescr) {
		this.issueStatusDescr = issueStatusDescr;
	}
	
	
}
