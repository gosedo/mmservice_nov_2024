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
@Table(name="techtasktatus")
public class TechTaskStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int taskStatusId;
	private String taskStatusCode;
	private String taskStatusDescr;
	
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

	
}
