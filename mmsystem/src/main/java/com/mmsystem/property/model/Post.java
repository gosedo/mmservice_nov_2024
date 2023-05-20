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
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int postId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId" , nullable=false)
    private MaintenanceIssue postToIssue;
	
	private String comment;
	private LocalDateTime createdOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postUserId" , nullable=false)
    private User postedBy;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public MaintenanceIssue getPostToIssue() {
		return postToIssue;
	}

	public void setPostToIssue(MaintenanceIssue postToIssue) {
		this.postToIssue = postToIssue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}
	
	

}
