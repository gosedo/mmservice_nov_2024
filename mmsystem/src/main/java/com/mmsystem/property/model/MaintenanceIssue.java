package com.mmsystem.property.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity  
@Table(name="maintenanceIssues")
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
	private Unit unitRequested;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
	private List<Post> posts = new ArrayList<>();
	
	private LocalDateTime createdOnDate;
	private LocalDateTime completedOnDate;
	
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public IssueType getIssueType() {
		return issueType;
	}
	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public IssueStatus getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}
	public User getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Unit getUnitRequested() {
		return unitRequested;
	}
	public void setUnitRequested(Unit unitRequested) {
		this.unitRequested = unitRequested;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public LocalDateTime getCreatedOnDate() {
		return createdOnDate;
	}
	public void setCreatedOnDate(LocalDateTime createdOnDate) {
		this.createdOnDate = createdOnDate;
	}
	public LocalDateTime getCompletedOnDate() {
		return completedOnDate;
	}
	public void setCompletedOnDate(LocalDateTime completedOnDate) {
		this.completedOnDate = completedOnDate;
	}
	
	
	
}
