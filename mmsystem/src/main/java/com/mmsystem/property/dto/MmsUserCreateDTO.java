package com.mmsystem.property.dto;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MmsUserCreateDTO {
	
	@Email(message = "Email cannot be blank")
	private String userEmail;
	@Size(min=6, max=14)
	private String userPassword;
	private String userFirstname;
	private String userLastname;
	private String userPhone;
	private Set<Integer> userRoles;
	
}

