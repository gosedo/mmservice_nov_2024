package com.mmsystem.property.service;

import java.util.List;

import com.mmsystem.property.dto.MmsPropertyManagementDTO;
import com.mmsystem.property.exception.PropertyManagmentAlreadyExistsException;
import com.mmsystem.property.exception.PropertyManagmentNotFoundException;
import com.mmsystem.property.model.MmsPropertyManagement;

 
public interface MmsPropMgmtService {

		
	MmsPropertyManagementDTO savePropMgmt(MmsPropertyManagementDTO pmgmtDto)throws PropertyManagmentAlreadyExistsException ;
	
	List<MmsPropertyManagementDTO> getPropMgmt() ;
	
	void deletePropMgmt(MmsPropertyManagement pojo);
	
	MmsPropertyManagementDTO getPropMgmtByID(MmsPropertyManagement pojo)throws PropertyManagmentNotFoundException;

	MmsPropertyManagementDTO updatePropMgmt(MmsPropertyManagement pojo) throws PropertyManagmentNotFoundException ;

}
