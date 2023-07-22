package com.mmsystem.property.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MmsUserActivationDTO {
	
	private String activationId;
	private String newPassword;

}
