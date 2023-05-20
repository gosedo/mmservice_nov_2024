package com.mmsystem.property.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity  
@Table(name="techteams")
public class TechTeam {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int techTeamId;
	
	private String techTeamDescr;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "memberOf")
	private Set<TechTeamMember> teamMembers ;
	
	private String isLead;

	public int getTechTeamId() {
		return techTeamId;
	}

	public void setTechTeamId(int techTeamId) {
		this.techTeamId = techTeamId;
	}

	

	public String getTechTeamDescr() {
		return techTeamDescr;
	}

	public void setTechTeamDescr(String techTeamDescr) {
		this.techTeamDescr = techTeamDescr;
	}

	public Set<TechTeamMember> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<TechTeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public String getIsLead() {
		return isLead;
	}

	public void setIsLead(String isLead) {
		this.isLead = isLead;
	}
	
}
