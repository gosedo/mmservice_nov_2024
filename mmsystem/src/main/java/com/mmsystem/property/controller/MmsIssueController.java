package com.mmsystem.property.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmsystem.property.model.MaintenanceIssue;
import com.mmsystem.property.service.MmsIssuesService;
import com.mmsystem.property.service.PropMgmtService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/issue")
public class MmsIssueController {
	
	@Autowired
	private MmsIssuesService mmsIssuesService;

	@GetMapping("test")
	public String test() {
		return "The result from Gosa";

	}
		
	@PostMapping("mmsissue-save") 
	public boolean saveMmsIssue(@RequestBody MaintenanceIssue issue){ 
		 return mmsIssuesService.saveMmsIssue(issue);
	}
	
	@GetMapping("mmsissue-list")
	public List<MaintenanceIssue> allIssues() {
		return mmsIssuesService.getMmsIssue();

	}

	@DeleteMapping("delete-mmsissue/{mmsissue_id}")
	public boolean deleteMmsIssue(@PathVariable("mmsissue_id") int mmsissue_id, MaintenanceIssue mmsIssue) {
		mmsIssue.setIssueId(mmsissue_id);
		return mmsIssuesService.deleteMmsIssue(mmsIssue);
	}

	@GetMapping("mmsissue/{mmsissue_id}")
	public MaintenanceIssue getMmsIssueByID(@PathVariable("mmsissue_id") int mmsissue_id, MaintenanceIssue mmsIssue) {
		mmsIssue.setIssueId(mmsissue_id);
		return mmsIssuesService.getMmsIssueByID(mmsIssue);

	}

	@PostMapping("update-mmsissue/{mmsissue_id}")
	public boolean updateMmsIssue(@RequestBody MaintenanceIssue mmsissue, @PathVariable("mmsissue_id") int mmsissue_id) {
		mmsissue.setIssueId(mmsissue_id);
		return mmsIssuesService.updateMmsIssue(mmsissue);
	}
}
