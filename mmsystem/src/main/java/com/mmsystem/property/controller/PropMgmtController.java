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

import com.mmsystem.property.model.PropertyManagement;
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
	public boolean savePropMgmt(@RequestBody PropertyManagement propMgmt){ 
		 return mmsPropMgmtService.savePropMgmt(propMgmt);
	}
	
	@GetMapping("propmgmt-list")
	public List<PropertyManagement> allPropMgmt() {
		return mmsPropMgmtService.getPropMgmt();

	}

	@DeleteMapping("delete-propmgmt/{propmgmt_id}")
	public boolean deletePropMgmt(@PathVariable("propmgmt_id") int propmgmt_id, PropertyManagement propMgmt) {
		propMgmt.setpMgmtId(propmgmt_id);
		return mmsPropMgmtService.deletePropMgmt(propMgmt);
	}

	@GetMapping("propmgmt/{propmgmt_id}")
	public PropertyManagement allPropMgmtByID(@PathVariable("propmgmt_id") int propmgmt_id, PropertyManagement propmgmt) {
		propmgmt.setpMgmtId(propmgmt_id);
		return mmsPropMgmtService.getPropMgmtByID(propmgmt);

	}

	@PostMapping("update-propmgmt/{propmgmt_id}")
	public boolean updateStudent(@RequestBody PropertyManagement propmgmt, @PathVariable("propmgmt_id") int propmgmt_id) {
		propmgmt.setpMgmtId(propmgmt_id);
		return mmsPropMgmtService.updatePropMgmt(propmgmt);
	}
}
