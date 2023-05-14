package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.PropertyManagement;
import com.mmsystem.property.repo.PropMgmtRepository;


@Service  
@Transactional 
public class PropMgmtService {

	
	@Autowired  
	private PropMgmtRepository mmspPropMgmtRepo; 
	
	
	public boolean savePropMgmt(PropertyManagement pojo) {
		
		return mmspPropMgmtRepo.save(pojo); 
	}

	
	public List<PropertyManagement> getPropMgmt() {
		
		return mmspPropMgmtRepo.get();
	}

	
	public boolean deletePropMgmt(PropertyManagement pojo) {
		
		return mmspPropMgmtRepo.delete(pojo); 
	}

	
	public PropertyManagement getPropMgmtByID(PropertyManagement pojo) {
		
		return mmspPropMgmtRepo.getByID(pojo);
	}

	
	public boolean updatePropMgmt(PropertyManagement pojo) {
		
		return mmspPropMgmtRepo.update(pojo);
	}

}
