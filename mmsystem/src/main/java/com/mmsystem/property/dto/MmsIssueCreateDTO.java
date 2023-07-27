package com.mmsystem.property.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MmsIssueCreateDTO {
	private int issueTypeId;
	private String issueDescr;
	private int requestedByUserId;

}
