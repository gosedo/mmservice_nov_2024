package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MaintenanceIssue;
import com.mmsystem.property.model.PropertyManagement;
import com.mmsystem.property.repo.MmsIssuesRepository;
import com.mmsystem.property.repo.PropMgmtsRepository;


@Service  
@Transactional 
public class MmsIssuesService {

	
	@Autowired  
	private MmsIssuesRepository mmsIssuesRepo; 
	
	
	public boolean saveMmsIssue(MaintenanceIssue pojo) {
		
		return mmsIssuesRepo.save(pojo); 
	}

	
	public List<MaintenanceIssue> getMmsIssue() {
		
		return mmsIssuesRepo.get();
	}

	
	public boolean deleteMmsIssue(MaintenanceIssue pojo) {
		
		return mmsIssuesRepo.delete(pojo); 
	}

	
	public MaintenanceIssue getMmsIssueByID(MaintenanceIssue pojo) {
		
		return mmsIssuesRepo.getByID(pojo);
	}

	
	public boolean updateMmsIssue(MaintenanceIssue pojo) {
		
		return mmsIssuesRepo.update(pojo);
	}

}
