package com.mmsystem.property.model;

import java.util.HashSet;
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

@Entity  
@Table(name="teammembers")
public class TechTeamMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int teamMemberId;
	
	@OneToOne
	@JoinColumn(name ="memberUserId")
	private User memberInfo;
	
	@ManyToMany
	@JoinTable(name = "techmember_MemberOf",
			joinColumns = @JoinColumn(name = "memberID", referencedColumnName = "teamMemberId"), 
		      inverseJoinColumns = @JoinColumn(name = "memberOfTeamId", 
		      referencedColumnName = "techTeamId"))
	private Set<TechTeam> memberOf = new HashSet<>();

	public int getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(int teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public User getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(User memberInfo) {
		this.memberInfo = memberInfo;
	}

	public Set<TechTeam> getMemberOf() {
		return memberOf;
	}

	public void setMemberOf(Set<TechTeam> memberOf) {
		this.memberOf = memberOf;
	}
	
	

}
