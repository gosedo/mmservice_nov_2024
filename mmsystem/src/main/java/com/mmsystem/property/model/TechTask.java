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

@Entity  
@Table(name="techtasks")
public class TechTask {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int techTaskId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId" , nullable=false)
	private MaintenanceIssue issueTaskFor;
	
	private String taskDescr;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId" , nullable=false)
	private TechTaskStatus taskStatus;
	
	private LocalDateTime createdOnDate;
	private LocalDateTime closedOnDate; 
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "techTeamId" , nullable=false)
	private TechTeam teamAssigned;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unitId" , nullable=false)
	private User taskCreatedBy;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unitId" , nullable=false)
	private User taskCloseddBy;

	public int getTechTaskId() {
		return techTaskId;
	}

	public void setTechTaskId(int techTaskId) {
		this.techTaskId = techTaskId;
	}

	public MaintenanceIssue getIssueTaskFor() {
		return issueTaskFor;
	}

	public void setIssueTaskFor(MaintenanceIssue issueTaskFor) {
		this.issueTaskFor = issueTaskFor;
	}

	public String getTaskDescr() {
		return taskDescr;
	}

	public void setTaskDescr(String taskDescr) {
		this.taskDescr = taskDescr;
	}

	public TechTaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TechTaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LocalDateTime getCreatedOnDate() {
		return createdOnDate;
	}

	public void setCreatedOnDate(LocalDateTime createdOnDate) {
		this.createdOnDate = createdOnDate;
	}

	public LocalDateTime getClosedOnDate() {
		return closedOnDate;
	}

	public void setClosedOnDate(LocalDateTime closedOnDate) {
		this.closedOnDate = closedOnDate;
	}

	public TechTeam getTeamAssigned() {
		return teamAssigned;
	}

	public void setTeamAssigned(TechTeam teamAssigned) {
		this.teamAssigned = teamAssigned;
	}

	public User getTaskCreatedBy() {
		return taskCreatedBy;
	}

	public void setTaskCreatedBy(User taskCreatedBy) {
		this.taskCreatedBy = taskCreatedBy;
	}

	public User getTaskCloseddBy() {
		return taskCloseddBy;
	}

	public void setTaskCloseddBy(User taskCloseddBy) {
		this.taskCloseddBy = taskCloseddBy;
	}
	
	
	
}
