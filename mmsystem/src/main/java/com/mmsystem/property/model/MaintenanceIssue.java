package com.mmsystem.property.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MaintenanceIssue{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int issueId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueTypeId" , nullable=false)
    private IssueType issueType;
	
	private String issueDescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueStatusId" , nullable=false)
	private IssueStatus issueStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId" , nullable=false)
	private User requestedBy;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unitId" , nullable=false)
	private User unitRequested;
	
	
	private LocalDateTime createdDate;
	private LocalDateTime completedDate;
	

}
