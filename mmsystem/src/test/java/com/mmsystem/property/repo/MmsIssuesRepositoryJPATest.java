package com.mmsystem.property.repo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mmsystem.property.mapper.MmsMaintenanceIssueMapper;
import com.mmsystem.property.model.MmsMaintenanceIssue;
import com.mmsystem.property.util.StubData;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MmsIssuesRepositoryJPATest {
	
	@Autowired
	private MmsIssuesJPARepository mmsIssuesJPARepository;
	
	static StubData allData = new StubData();
	
	@BeforeAll
	static void setupAllDataForTest() {
		allData.setUpAllData();
	}
	
	@BeforeEach
	void setup() {
		
		
		
	}
	
	@Test
	public void givenMmsMaintenaceIssue_whenSave_theReturnsSavedIssue() {
		
		MmsMaintenanceIssue mmsMaintenanceIssue = allData.getStubListOfIssues().get(0);
		
		MmsMaintenanceIssue newIssue = MmsMaintenanceIssueMapper.INSTANCE.mapToNoIdIssueObj(mmsMaintenanceIssue);
		
		MmsMaintenanceIssue savedIssue = mmsIssuesJPARepository.save(newIssue);
		
		assertThat(savedIssue).isNotNull();
        assertThat(savedIssue.getIssueId()).isGreaterThan(0);
		
	}
	

}
