package com.mmsystem.property.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  
@Table(name="mmstechteams")
public class MmsTechTeam {
	
	@Override
	public int hashCode() {
		return Objects.hash(isLead, techTeamDescr, techTeamId);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int techTeamId;
	
	private String techTeamDescr;
			
	private String isLead;
	
	
}
