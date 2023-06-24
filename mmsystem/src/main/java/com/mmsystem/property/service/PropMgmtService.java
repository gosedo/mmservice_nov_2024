package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MmsPropertyManagement;
import com.mmsystem.property.repo.PropMgmtsRepository;


@Service  
@Transactional 
public class PropMgmtService {

	
	@Autowired  
	private PropMgmtsRepository mmspPropMgmtRepo; 
	
	
	public boolean savePropMgmt(MmsPropertyManagement pojo) {
		
		return mmspPropMgmtRepo.save(pojo); 
	}

	
	public List<MmsPropertyManagement> getPropMgmt() {
		
		return mmspPropMgmtRepo.get();
	}

	
	public boolean deletePropMgmt(MmsPropertyManagement pojo) {
		
		return mmspPropMgmtRepo.delete(pojo); 
	}

	
	public MmsPropertyManagement getPropMgmtByID(MmsPropertyManagement pojo) {
		
		return mmspPropMgmtRepo.getByID(pojo);
	}

	
	public boolean updatePropMgmt(MmsPropertyManagement pojo) {
		
		return mmspPropMgmtRepo.update(pojo);
	}

}
