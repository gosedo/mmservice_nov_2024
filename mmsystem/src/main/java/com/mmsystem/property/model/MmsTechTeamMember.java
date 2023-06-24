package com.mmsystem.property.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  
@Table(name="mmstechteammembers")
public class MmsTechTeamMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int teamMemberId;
	
	@OneToOne
	@JoinColumn(name ="memberUserId")
	private MmsUser memberInfo;
	
	@ManyToMany
	@JoinTable(
			joinColumns = @JoinColumn(name = "memberID", referencedColumnName = "teamMemberId"), 
		      inverseJoinColumns = @JoinColumn(name = "memberOfTeamId", 
		      referencedColumnName = "techTeamId"))
	private Set<MmsTechTeam> memberOf = new HashSet<>();

	
}
