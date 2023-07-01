package com.mmsystem.property.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mmsystem.property.dto.MmsPropertyManagementDTO;

import com.mmsystem.property.model.MmsPropertyManagement;


@Mapper
public interface MmsPropertyManagementMapper {
	
	MmsPropertyManagementMapper INSTANCE = Mappers.getMapper(MmsPropertyManagementMapper.class);
		
	MmsPropertyManagementDTO mapToMmsPropertyManagementDto(MmsPropertyManagement mmsPropertyManagement);

	MmsPropertyManagement mapToMmsPropertyManagement(MmsPropertyManagementDTO mmsPropertyManagementDto);
	 
}

