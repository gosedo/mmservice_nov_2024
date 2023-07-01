package com.mmsystem.property.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MmsTechTeamMemberDTO {
	
	private int teamMemberId;
	private MmsUserDTO memberInfo;
	private Set<MmsTechTeamDTO> memberOf ;

	
}
