package com.mmsystem.property.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mmsystem.property.dto.MmsIssueStatusDTO;

import com.mmsystem.property.model.MmsIssueStatus;


@Mapper
public interface MmsIssueStatusMapper {
	
	MmsIssueStatusMapper INSTANCE = Mappers.getMapper(MmsIssueStatusMapper.class);
		
	MmsIssueStatusDTO mapToIssueStatusDto(MmsIssueStatus issueStatus);

	MmsIssueStatus mapToIssueStatus(MmsIssueStatusDTO issueStatusDto);
	 
}

