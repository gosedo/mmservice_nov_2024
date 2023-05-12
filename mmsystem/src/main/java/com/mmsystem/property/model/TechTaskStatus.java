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
@Table(name="techteamstatus")
public class TechTaskStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int taskStatusId;
	private String taskStatusCode;
	private String taskStatusDescr;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "issueStatus")
	private List<TechTask> techTasks = new ArrayList<>();

	public int getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public String getTaskStatusCode() {
		return taskStatusCode;
	}

	public void setTaskStatusCode(String taskStatusCode) {
		this.taskStatusCode = taskStatusCode;
	}

	public String getTaskStatusDescr() {
		return taskStatusDescr;
	}

	public void setTaskStatusDescr(String taskStatusDescr) {
		this.taskStatusDescr = taskStatusDescr;
	}

	public List<TechTask> getTechTasks() {
		return techTasks;
	}

	public void setTechTasks(List<TechTask> techTasks) {
		this.techTasks = techTasks;
	}
	
	
}
