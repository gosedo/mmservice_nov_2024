package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MmsUserRole;
import com.mmsystem.property.repo.MmsUserRoleJPARepository;


@Service  
@Transactional
public class MmsUserRoleServiceImpl implements MmsUserRoleService{
	
	@Autowired  
	private MmsUserRoleJPARepository mmspUserRoleJPARepo; 
	
	
	 public List<MmsUserRole> getUserRoles() {  
	      return mmspUserRoleJPARepo.findAll();  
	 }
	 
	 public MmsUserRole getRoleById(int id) {
		 
		 return mmspUserRoleJPARepo.findById((long) id).get();
	 }
	 
	 
}
