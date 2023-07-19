package com.mmsystem.property.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.mmsystem.property.dto.MmsMaintenanceIssueDTO;
import com.mmsystem.property.model.MmsIssueStatus;
import com.mmsystem.property.model.MmsIssueType;
import com.mmsystem.property.model.MmsMaintenanceIssue;
import com.mmsystem.property.model.MmsTenant;
import com.mmsystem.property.repo.MmsIssuesJPARepository;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
class MmsIssuesServiceImplTest {

	@Autowired
	private MmsIssuesService mmsIssueService;
	
	@MockBean
	private MmsIssuesJPARepository mmsIssuesJPARepository;
	
//	MmsMaintenanceIssue mmsIssueOne= new MmsMaintenanceIssue(1,new MmsIssueType(1,"",""), "Test1", new MmsIssueStatus(1,"","")
//			,new  MmsTenant(1,null,null,false,null,null),null,null) 
	
	@BeforeEach
	void setup() {
		List<MmsMaintenanceIssue> listOfIssues = new ArrayList<>();
		MmsMaintenanceIssue mmsIssueOne= new MmsMaintenanceIssue();
		mmsIssueOne.setIssueId(1);
		MmsMaintenanceIssue mmsIssueTwo= new MmsMaintenanceIssue();
		mmsIssueOne.setIssueId(1);
		
		listOfIssues.add(mmsIssueOne);
		listOfIssues.add(mmsIssueTwo);
		
		Mockito.when(mmsIssuesJPARepository.findByRequestedByTenantInfoUserId((long)1)).thenReturn(listOfIssues);
		
	}
	@Test
	public void testGetIssueById_Success() {
		
				
		List<MmsMaintenanceIssueDTO> issuesList = mmsIssueService.getMmsIssueByUserId(1);
		assertEquals(2,issuesList.size());
	}

}
