package com.mmsystem.property.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="mmsuserroles")
public class MmsUserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int usrRoleId;
	private String usrRoleCode;
	private String usrRoleDescr;
	
//	@ManyToMany(mappedBy = "userRoles",cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
//	private Set<MmsUser> users = new HashSet<>();
	
}
