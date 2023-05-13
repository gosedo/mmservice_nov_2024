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
@Table(name="techteams")
public class TechTeam {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int techTeamId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
	private List<User> teamMembers = new ArrayList<>();
	
	private String isLead;

	public int getTechTeamId() {
		return techTeamId;
	}

	public void setTechTeamId(int techTeamId) {
		this.techTeamId = techTeamId;
	}

	public List<User> getTeamMember() {
		return teamMembers;
	}

	public void setTeamMember(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public String getIsLead() {
		return isLead;
	}

	public void setIsLead(String isLead) {
		this.isLead = isLead;
	}
	
}
