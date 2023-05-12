package com.mmsystem.property.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class IssueType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int issueTypeId;
	private String issueTypeCode;
	private String issueTypeDescr;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "issueType")
	private List<MaintenanceIssue> maintenanceIssues = new ArrayList<>();

}
