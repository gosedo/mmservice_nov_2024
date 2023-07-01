package com.mmsystem.property.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.MmsPropertyManagementDTO;
import com.mmsystem.property.mapper.MmsPropertyManagementMapper;
import com.mmsystem.property.mapper.MmsUnitMapper;
import com.mmsystem.property.model.MmsPropertyManagement;
import com.mmsystem.property.model.MmsUnit;
import com.mmsystem.property.repo.PropMgmtsRepository;


@Service  
@Transactional 
public class PropMgmtService {

	
	@Autowired  
	private PropMgmtsRepository mmspPropMgmtRepo; 
	
	
	public MmsPropertyManagementDTO savePropMgmt(MmsPropertyManagementDTO pmgmtDto) {
		
		MmsPropertyManagement pmgmt = MmsPropertyManagementMapper.INSTANCE.mapToMmsPropertyManagement(pmgmtDto);
		mmspPropMgmtRepo.save(pmgmt);
		
		return MmsPropertyManagementMapper.INSTANCE.mapToMmsPropertyManagementDto(pmgmt);
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
