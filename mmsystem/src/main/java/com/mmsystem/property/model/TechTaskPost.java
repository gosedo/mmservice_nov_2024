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
@Table(name="techtaskposts")
public class TechTaskPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int taskPostId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "techTaskId" , nullable=false)
    private TechTask postToTask;
	
	private String comment;
	private LocalDateTime createdOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId" , nullable=false)
    private User postedBy;

	public int getTaskPostId() {
		return taskPostId;
	}

	public void setTaskPostId(int taskPostId) {
		this.taskPostId = taskPostId;
	}

	public TechTask getPostToTask() {
		return postToTask;
	}

	public void setPostToTask(TechTask postToTask) {
		this.postToTask = postToTask;
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
