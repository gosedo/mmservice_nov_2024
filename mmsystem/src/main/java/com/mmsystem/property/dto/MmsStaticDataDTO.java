package com.mmsystem.property.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MmsStaticDataDTO {
	private List<MmsIssueTypeDTO> issueTypes;
	private List<MmsIssueStatusDTO> issueStatuses;
	private List<MmsUnitDTO> mmsProperyUnits;
}



