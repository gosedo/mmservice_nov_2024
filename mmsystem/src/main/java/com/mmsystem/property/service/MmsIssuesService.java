package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MmsMaintenanceIssue;

import com.mmsystem.property.repo.MmsIssuesRepository;



@Service  
@Transactional 
public class MmsIssuesService {

	
	@Autowired  
	private MmsIssuesRepository mmsIssuesRepo; 
	
	
	public boolean saveMmsIssue(MmsMaintenanceIssue pojo) {
		
		return mmsIssuesRepo.save(pojo); 
	}

	
	public List<MmsMaintenanceIssue> getMmsIssue() {
		
		return mmsIssuesRepo.get();
	}

	
	public boolean deleteMmsIssue(MmsMaintenanceIssue pojo) {
		
		return mmsIssuesRepo.delete(pojo); 
	}

	
	public MmsMaintenanceIssue getMmsIssueByID(MmsMaintenanceIssue pojo) {
		
		return mmsIssuesRepo.getByID(pojo);
	}

	
	public boolean updateMmsIssue(MmsMaintenanceIssue pojo) {
		
		return mmsIssuesRepo.update(pojo);
	}

}
