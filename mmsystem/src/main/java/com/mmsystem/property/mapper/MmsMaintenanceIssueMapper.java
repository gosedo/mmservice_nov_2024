package com.mmsystem.property.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mmsystem.property.dto.MmsMaintenanceIssueDTO;

import com.mmsystem.property.model.MmsMaintenanceIssue;


@Mapper
public interface MmsMaintenanceIssueMapper {
	
	MmsMaintenanceIssueMapper INSTANCE = Mappers.getMapper(MmsMaintenanceIssueMapper.class);
	
	MmsMaintenanceIssueDTO mapToIssueDto(MmsMaintenanceIssue mmsIssue);

	MmsMaintenanceIssue mapToMmsIssue(MmsMaintenanceIssueDTO mmsIssueDto);
}
