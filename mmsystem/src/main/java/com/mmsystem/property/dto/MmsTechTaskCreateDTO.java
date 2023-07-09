package com.mmsystem.property.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MmsTechTaskCreateDTO {
	
	private String taskDescr;
	private int taskForIssueId;
	private int teamAssignedId;
	private int taskCreatedByUserId;
	
}
