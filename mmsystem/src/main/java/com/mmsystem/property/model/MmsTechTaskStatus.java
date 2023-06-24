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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  
@Table(name="mmstechtasktatus")
public class MmsTechTaskStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int taskStatusId;
	private String taskStatusCode;
	private String taskStatusDescr;
	
}
