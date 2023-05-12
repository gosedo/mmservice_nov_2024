package com.mmsystem.property.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class IssueStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int issueStatusId;
	private String issueStatusCode;
	private String issueStatusDescr;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "issueStatus")
	private List<MaintenanceIssue> maintenanceIssues = new ArrayList<>();

}
