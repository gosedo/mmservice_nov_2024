package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MmsProperty;
import com.mmsystem.property.repo.MmsPropertiesRepository;



@Service  
@Transactional 
public class MmsPropertyService {

	
	@Autowired  
	private MmsPropertiesRepository mmsPropertyRepo; 
	
	
	public boolean saveMmsProp(MmsProperty pojo) {
		
		return mmsPropertyRepo.save(pojo); 
	}

	
	public List<MmsProperty> getMmsProp() {
		
		return mmsPropertyRepo.get();
	}

	
	public boolean deleteMmsProp(MmsProperty pojo) {
		
		return mmsPropertyRepo.delete(pojo); 
	}

	
	public MmsProperty getMmsPropByID(MmsProperty pojo) {
		
		return mmsPropertyRepo.getByID(pojo);
	}

	
	public boolean updateMmsProp(MmsProperty pojo) {
		
		return mmsPropertyRepo.update(pojo);
	}

}
