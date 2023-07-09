package com.mmsystem.property.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class MmsIssueStatusDTO {
	
	private int issueStatusId;
	private String issueStatusCode;
	private String issueStatusDescr;
	
}
