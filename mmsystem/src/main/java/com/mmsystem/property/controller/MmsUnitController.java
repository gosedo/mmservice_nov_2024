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

import com.mmsystem.property.model.Unit;
import com.mmsystem.property.service.MmsUnitService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/mmsunit")
public class MmsUnitController {
	
	@Autowired
	private MmsUnitService mmsUnitService;

	@GetMapping("test")
	public String test() {
		return "The result from Gosa";

	}
		
	@PostMapping("mmsunit-save") 
	public boolean saveMmsUnit(@RequestBody Unit mmsUnit){ 
		 return mmsUnitService.saveMmsUnit(mmsUnit);
	}
	
	@GetMapping("mmsunit-list")
	public List<Unit> allMmsUnits() {
		return mmsUnitService.getMmsUnits();

	}

	@DeleteMapping("delete-mmsUnit/{unitId}")
	public boolean deleteMmsUnit(@PathVariable("unitId") int unitId, Unit mmsUnit) {
		mmsUnit.setUnitId(unitId);
		return mmsUnitService.deleteMmsUnit(mmsUnit);
	}

	@GetMapping("mmsUnit/{unitId}")
	public Unit getMmsUnitByID(@PathVariable("unitId") int unitId, Unit mmsUnit) {
		mmsUnit.setUnitId(unitId);
		return mmsUnitService.getMmsUnitByID(mmsUnit);

	}

	@PostMapping("update-mmsUnit/{unitId}")
	public boolean updateMmsUnit(@RequestBody Unit mmsUnit, @PathVariable("unitId") int unitId) {
		mmsUnit.setUnitId(unitId);
		return mmsUnitService.updateMmsUnit(mmsUnit);
	}
}
