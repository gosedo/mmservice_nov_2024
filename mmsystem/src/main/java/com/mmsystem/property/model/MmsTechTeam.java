package com.mmsystem.property.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
		return Objects.hash(techTeamDescr, techTeamId);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int techTeamId;
	
	private String techTeamDescr;
	
	
}
