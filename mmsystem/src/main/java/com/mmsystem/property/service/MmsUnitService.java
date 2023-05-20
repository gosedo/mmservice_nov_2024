package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.Unit;
import com.mmsystem.property.repo.MmsUnitsRepository;



@Service  
@Transactional 
public class MmsUnitService {

	
	@Autowired  
	private MmsUnitsRepository mmsUnitsRepo; 
	
	
	public boolean saveMmsUnit(Unit pojo) {
		
		return mmsUnitsRepo.save(pojo); 
	}

	
	public List<Unit> getMmsUnits() {
		
		return mmsUnitsRepo.get();
	}

	
	public boolean deleteMmsUnit(Unit pojo) {
		
		return mmsUnitsRepo.delete(pojo); 
	}

	
	public Unit getMmsUnitByID(Unit pojo) {
		
		return mmsUnitsRepo.getByID(pojo);
	}

	
	public boolean updateMmsUnit(Unit pojo) {
		
		return mmsUnitsRepo.update(pojo);
	}

}
