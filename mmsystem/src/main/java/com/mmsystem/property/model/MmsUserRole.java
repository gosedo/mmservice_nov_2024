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
@Table(name="mmsuserroles")
public class MmsUserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int usrRoleId;
	private String usrRoleCode;
	private String usrRoleDescr;
	
	@Override
	public int hashCode() {
		return Objects.hash(usrRoleCode, usrRoleDescr, usrRoleId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MmsUserRole other = (MmsUserRole) obj;
		return Objects.equals(usrRoleCode, other.usrRoleCode) && Objects.equals(usrRoleDescr, other.usrRoleDescr)
				&& usrRoleId == other.usrRoleId;
	}
	
//	@ManyToMany(mappedBy = "userRoles",cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
//	private Set<MmsUser> users = new HashSet<>();
	
}
