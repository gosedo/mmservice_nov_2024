package com.mmsystem.property.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.MmsStaticDataDTO;


@Service  
@Transactional 
public class MmsStaticDataServiceImpl implements MmsStaticDataService{

	
	@Autowired  
	private MmsUnitService mmsUnitService; 
	
	@Autowired  
	private MmsIssueTypeService mmsIssueTypeService;
	
	@Autowired  
	private MmsIssueStatusService mmsIssueStatusService;
	
	@Autowired  
	private MmsTechTaskStatusService mmsTaskStatusService;
	
	@Autowired  
	private MmsTechTeamService mmsTechteamService;
	
	
	public MmsStaticDataDTO getStaticData() {
		
		MmsStaticDataDTO staticData = new MmsStaticDataDTO();
		
		staticData.setIssueStatuses(mmsIssueStatusService.getIssueStatuses());
		staticData.setIssueTypes(mmsIssueTypeService.getIssueTypes());
		staticData.setMmsProperyUnits(mmsUnitService.getMmsUnits());
		staticData.setMmsTechTeams(mmsTechteamService.findAll());
		staticData.setMmsTaskStatuses(mmsTaskStatusService.findAll());
		
		return staticData;
	}


}
