package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MmsUnit;
import com.mmsystem.property.repo.MmsUnitsRepository;



@Service  
@Transactional 
public class MmsUnitService {

	
	@Autowired  
	private MmsUnitsRepository mmsUnitsRepo; 
	
	
	public boolean saveMmsUnit(MmsUnit pojo) {
		
		return mmsUnitsRepo.save(pojo); 
	}

	
	public List<MmsUnit> getMmsUnits() {
		
		return mmsUnitsRepo.get();
	}

	
	public boolean deleteMmsUnit(MmsUnit pojo) {
		
		return mmsUnitsRepo.delete(pojo); 
	}

	
	public MmsUnit getMmsUnitByID(MmsUnit pojo) {
		
		return mmsUnitsRepo.getByID(pojo);
	}

	
	public boolean updateMmsUnit(MmsUnit pojo) {
		
		return mmsUnitsRepo.update(pojo);
	}

}
