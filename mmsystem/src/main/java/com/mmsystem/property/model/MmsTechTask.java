package com.mmsystem.property.model;

import java.time.LocalDateTime;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  
@Table(name="mmstechtasks")
public class MmsTechTask {
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int techTaskId;
	private String taskDescr;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskIssueId" , nullable=false)
	private MmsMaintenanceIssue issueTaskFor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taskStatusId" , nullable=false) 
	private MmsTechTaskStatus taskStatus;
	  
	private LocalDateTime createdOnDate;
	private LocalDateTime closedOnDate; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "techTeamId" , nullable=false) 
	private MmsTechTeam teamAssigned;
	 
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "createdById" , nullable=false) 
	private MmsUser taskCreatedBy;
	  
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taskClosedById" , nullable=false)
	private MmsUser taskCloseddBy;
	 
	 
	/*
	 * public TechTeam getTeamAssigned() { return teamAssigned; }
	 * 
	 * public void setTeamAssigned(TechTeam teamAssigned) { this.teamAssigned =
	 * teamAssigned; }
	 * 
	 * public User getTaskCreatedBy() { return taskCreatedBy; }
	 * 
	 * public void setTaskCreatedBy(User taskCreatedBy) { this.taskCreatedBy =
	 * taskCreatedBy; }
	 * 
	 * public User getTaskCloseddBy() { return taskCloseddBy; }
	 * 
	 * public void setTaskCloseddBy(User taskCloseddBy) { this.taskCloseddBy =
	 * taskCloseddBy; }
	 */
	
	
	
}
