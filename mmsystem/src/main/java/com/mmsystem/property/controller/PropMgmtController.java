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

import com.mmsystem.property.dto.MmsPropertyManagementDTO;
import com.mmsystem.property.model.MmsPropertyManagement;
import com.mmsystem.property.service.PropMgmtService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/propmgmt")
public class PropMgmtController {
	
	@Autowired
	private PropMgmtService mmsPropMgmtService;

	@GetMapping("test")
	public String test() {
		return "The result from Gosa";

	}
		
	@PostMapping("propmgmt-save") 
	public MmsPropertyManagementDTO savePropMgmt(@RequestBody MmsPropertyManagementDTO propMgmtDto){ 
		 return mmsPropMgmtService.savePropMgmt(propMgmtDto);
	}
	
	@GetMapping("propmgmt-list")
	public List<MmsPropertyManagement> allPropMgmt() {
		return mmsPropMgmtService.getPropMgmt();

	}

	@DeleteMapping("delete-propmgmt/{propmgmt_id}")
	public boolean deletePropMgmt(@PathVariable("propmgmt_id") int propmgmt_id, MmsPropertyManagement propMgmt) {
		propMgmt.setPMgmtId(propmgmt_id);
		return mmsPropMgmtService.deletePropMgmt(propMgmt);
	}

	@GetMapping("propmgmt/{propmgmt_id}")
	public MmsPropertyManagement allPropMgmtByID(@PathVariable("propmgmt_id") int propmgmt_id, MmsPropertyManagement propmgmt) {
		propmgmt.setPMgmtId(propmgmt_id);
		return mmsPropMgmtService.getPropMgmtByID(propmgmt);

	}

	@PostMapping("update-propmgmt/{propmgmt_id}")
	public boolean updatePropMgmt(@RequestBody MmsPropertyManagement propmgmt, @PathVariable("propmgmt_id") int propmgmt_id) {
		propmgmt.setPMgmtId(propmgmt_id);
		return mmsPropMgmtService.updatePropMgmt(propmgmt);
	}
}
