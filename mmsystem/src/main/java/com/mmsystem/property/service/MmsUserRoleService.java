package com.mmsystem.property.service;

import java.util.List;
import com.mmsystem.property.model.MmsUserRole;


public interface MmsUserRoleService {

	List<MmsUserRole> getUserRoles();
	 
	MmsUserRole getRoleById(int id);
	 
}