package com.mmsystem.property.dto;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthInformationDTO {
	
	private int userId;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private String jwtToken;
	private Date tokenExpiration;
	private Set<Integer> userRoleIds;

}
