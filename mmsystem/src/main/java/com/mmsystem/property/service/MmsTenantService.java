package com.mmsystem.property.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.MmsIssueTypeDTO;
import com.mmsystem.property.dto.MmsTenantDTO;
import com.mmsystem.property.mapper.MmsIssueTypeMapper;
import com.mmsystem.property.mapper.MmsTenantMapper;
import com.mmsystem.property.model.MmsIssueType;
import com.mmsystem.property.model.MmsTenant;
import com.mmsystem.property.repo.MmsIssueTypeRepository;
import com.mmsystem.property.repo.MmsTenantRepository;



@Service  
@Transactional 
public class MmsTenantService {

	
	@Autowired  
	private MmsTenantRepository mmsTenantRepo; 
	
	
	public MmsTenantDTO savePropMgmt(MmsTenantDTO mmsTenantDto) {
		
		MmsTenant mmsTenant = MmsTenantMapper.INSTANCE.mapToMmsTenant(mmsTenantDto);
		mmsTenantRepo.save(mmsTenant);
		
		return MmsTenantMapper.INSTANCE.mapToMmsTenantDto(mmsTenant);
	}

	
	public List<MmsTenantDTO> getTenats() {
		
		return mmsTenantRepo.get()
				.stream()
				.map((mmsTenant) -> MmsTenantMapper.INSTANCE.mapToMmsTenantDto(mmsTenant))
		        .collect(Collectors.toList());
	}

	
	public boolean deleteTenant(MmsTenant pojo) {
		
		return mmsTenantRepo.delete(pojo); 
	}

	
	public MmsTenant getTenantByID(MmsTenant pojo) {
		
		return mmsTenantRepo.getByID(pojo);
	}

	
	public boolean updateIssueType(MmsTenant pojo) {
		
		return mmsTenantRepo.update(pojo);
	}

}
