package com.mmsystem.property.controller;

import java.util.List;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmsystem.property.dto.MmsMaintenanceIssueDTO;
import com.mmsystem.property.model.MmsMaintenanceIssue;
import com.mmsystem.property.service.MmsIssuesService;
import com.mmsystem.property.service.PropMgmtService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/issue")
public class MmsIssueController {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private MmsIssuesService mmsIssuesService;

	@GetMapping("test")
	public String test() {
		return "The result from Gosa";

	}
		
	@PostMapping("mmsissue-save") 
	public MmsMaintenanceIssueDTO saveMmsIssue(@RequestBody MmsMaintenanceIssueDTO issueDto){ 
		 return mmsIssuesService.saveMmsIssue(issueDto);
	}
	
	@GetMapping("mmsissue-list")
	public List<MmsMaintenanceIssue> allIssues() {
		logger.info("Request URI: Gosaye" );
		
		return mmsIssuesService.getMmsIssue();

	}

	@DeleteMapping("delete-mmsissue/{mmsissue_id}")
	public boolean deleteMmsIssue(@PathVariable("mmsissue_id") int mmsissue_id, MmsMaintenanceIssue mmsIssue) {
		mmsIssue.setIssueId(mmsissue_id);
		return mmsIssuesService.deleteMmsIssue(mmsIssue);
	}

	@GetMapping("mmsissue/{mmsissue_id}")
	public MmsMaintenanceIssue getMmsIssueByID(@PathVariable("mmsissue_id") int mmsissue_id, MmsMaintenanceIssue mmsIssue) {
		mmsIssue.setIssueId(mmsissue_id);
		return mmsIssuesService.getMmsIssueByID(mmsIssue);

	}

	@PostMapping("update-mmsissue/{mmsissue_id}")
	public boolean updateMmsIssue(@RequestBody MmsMaintenanceIssue mmsissue, @PathVariable("mmsissue_id") int mmsissue_id) {
		mmsissue.setIssueId(mmsissue_id);
		return mmsIssuesService.updateMmsIssue(mmsissue);
	}
}
