package com.mmsystem.property.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.MmsPropertyManagementDTO;
import com.mmsystem.property.exception.PropertyManagmentAlreadyExistsException;
import com.mmsystem.property.exception.PropertyManagmentNotFoundException;
import com.mmsystem.property.mapper.MmsPropertyManagementMapper;

import com.mmsystem.property.model.MmsPropertyManagement;

import com.mmsystem.property.repo.PropMgmtsRepository;
import com.mmsystem.property.repo.PropMgmtsRepositoryJPA;


@Service  
@Transactional 
public class MmsPropMgmtService {

	
	@Autowired  
	private PropMgmtsRepository mmspPropMgmtRepo; 
	
	@Autowired
	private PropMgmtsRepositoryJPA propMgmtsRepositoryJPA;
	
	
	public MmsPropertyManagementDTO savePropMgmt(MmsPropertyManagementDTO pmgmtDto) throws PropertyManagmentAlreadyExistsException {
		
			
		Optional<MmsPropertyManagement> optProMgmt =  propMgmtsRepositoryJPA.findById(pmgmtDto.getPMgmtId());
				
		MmsPropertyManagementDTO pmgmtDtoresponse;
		
		MmsPropertyManagement savedPropMgmt;
		
		if(optProMgmt.isEmpty()) {
			
			throw new PropertyManagmentAlreadyExistsException();
			
		}else {
			
			MmsPropertyManagement pmgmt = MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagement(pmgmtDto);
			savedPropMgmt = propMgmtsRepositoryJPA.save(pmgmt);
			
			pmgmtDtoresponse = MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagementDto(savedPropMgmt);
		}
		
		return pmgmtDtoresponse;
//		//===================
//		
//		
//		MmsPropertyManagement pmgmt = MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagement(pmgmtDto);
//		propMgmtsRepositoryJPA.save(pmgmt);
//		
//		return MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagementDto(pmgmt);
	}

	
	public List<MmsPropertyManagementDTO> getPropMgmt() {
		
		return propMgmtsRepositoryJPA.findAll()
				.stream()
				.map((pmgmt) -> MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagementDto(pmgmt))
		        .collect(Collectors.toList());
	}
	
	public void deletePropMgmt(MmsPropertyManagement pojo) {
					
		 propMgmtsRepositoryJPA.delete(pojo);
	}

	
	public MmsPropertyManagementDTO getPropMgmtByID(MmsPropertyManagement pojo) throws PropertyManagmentNotFoundException{
		
		Optional<MmsPropertyManagement> optProMgmt =  propMgmtsRepositoryJPA.findById(pojo.getPMgmtId());
		
		MmsPropertyManagementDTO pmgmtDto;
		
		if(optProMgmt.isEmpty()) {
			throw new PropertyManagmentNotFoundException();
		}else {
			pmgmtDto = MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagementDto(optProMgmt.get()) ;
			
		}
		return pmgmtDto;
	}

	
	public MmsPropertyManagementDTO updatePropMgmt(MmsPropertyManagement pojo) throws PropertyManagmentNotFoundException {
		
		Optional<MmsPropertyManagement> optProMgmt =  propMgmtsRepositoryJPA.findById(pojo.getPMgmtId());
		
		MmsPropertyManagementDTO pmgmtDto;
		
		MmsPropertyManagement savedPropMgmt;
		
		if(optProMgmt.isEmpty()) {
			throw new PropertyManagmentNotFoundException();
		}else {
			
			savedPropMgmt = propMgmtsRepositoryJPA.save(pojo);
			
			pmgmtDto = MmsPropertyManagementMapper.INSTANCE.mapToMmsPManagementDto(savedPropMgmt);
		
		}
		
		return pmgmtDto;
	}

}
