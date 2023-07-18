package com.mmsystem.property.service;

import java.util.List;
import com.mmsystem.property.dto.MmsTenantDTO;
import com.mmsystem.property.model.MmsTenant;


public interface MmsTenantService {

	MmsTenantDTO savePropMgmt(MmsTenantDTO mmsTenantDto);

	List<MmsTenantDTO> getTenats();

	boolean deleteTenant(MmsTenant pojo);

	MmsTenant getTenantByID(MmsTenant pojo);

	boolean updateIssueType(MmsTenant pojo);

}