package com.mmsystem.property.service;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import com.mmsystem.property.dto.MmsMaintenanceIssueDTO;

import com.mmsystem.property.repo.MmsIssuesJPARepository;
import com.mmsystem.property.util.StubData;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
class MmsIssuesServiceImplTest {

	@Autowired
	private MmsIssuesService mmsIssueService;
	
	@MockBean
	private MmsIssuesJPARepository mmsIssuesJPARepository;
	
	
	static StubData allData = new StubData();
	
	@BeforeAll
	static void setupAllDataForTest() {
		allData.setUpAllData();
	}
	@BeforeEach
	void setup() {
		
		 
//		List<MmsMaintenanceIssue> listOfIssues = new ArrayList<>();
//		MmsMaintenanceIssue mmsIssueOne= new MmsMaintenanceIssue();
//		mmsIssueOne.setIssueId(1);
//		MmsMaintenanceIssue mmsIssueTwo= new MmsMaintenanceIssue();
//		mmsIssueOne.setIssueId(1);
//		
//		listOfIssues.add(mmsIssueOne);
//		listOfIssues.add(mmsIssueTwo);
//		//StubData fromStubData = new StubData();
		
		Mockito.when(mmsIssuesJPARepository.findByRequestedByTenantInfoUserId((long)1)).thenReturn(allData.getStubListOfIssues());
		
	}
	
	@Test
	public void testGetIssueById_Success() {
				
		List<MmsMaintenanceIssueDTO> issuesList = mmsIssueService.getMmsIssueByUserId(1);
		assertEquals(3,issuesList.size());
	}
	
	@Test
	public void testGetIssueById_ReturnIssueDTO_Success() {
		
				
		List<MmsMaintenanceIssueDTO> issuesList = mmsIssueService.getMmsIssueByUserId(1);
		
		//jupiter.api
		assertEquals(3,issuesList.size());
		
		//hamcrest
		assertThat(3,equalTo(issuesList.size()));
		assertThat(issuesList.get(0), instanceOf(MmsMaintenanceIssueDTO.class));
		
		//assertj
		assertThat(3).isEqualTo(issuesList.size());
		assertThat(issuesList.get(0)).isInstanceOf(MmsMaintenanceIssueDTO.class);
		assertThat(issuesList).isNotInstanceOf(MmsMaintenanceIssueDTO.class);
		
	}
	
	

}
