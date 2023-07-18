package com.mmsystem.property.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.AuthInformationDTO;
import com.mmsystem.property.dto.MmsUserDTO;
import com.mmsystem.property.mapper.MmsUserMapper;
import com.mmsystem.property.model.MmsUser;
import com.mmsystem.property.repo.UserRepository;


@Service  
@Transactional  
public class MmsUserServiceImpl implements MmsUserService {  
 
  @Autowired  
  private UserRepository mmspUserRepo;  
    
   
  public MmsUserDTO saveUser(MmsUserDTO mmsUserDto) { 
	  
	  MmsUser mmsUser = MmsUserMapper.INSTANCE.mapToUser(mmsUserDto);
	  
      mmspUserRepo.save(mmsUser); 
      
      return MmsUserMapper.INSTANCE.mapToUserDto(mmsUser);
  }  

   
  public List<MmsUser> getUsers() {  
      return mmspUserRepo.get();  
  }  

    
  public boolean deleteUser(MmsUser mmsUser) {  
      return mmspUserRepo.delete(mmsUser);  
  }  

    
  public MmsUser getUserByID(MmsUser mmsUser) {  
      return mmspUserRepo.getByID(mmsUser);  
  } 
  
    
  public boolean updateUser(MmsUser mmsUser) {  
      return mmspUserRepo.update(mmsUser);  
  } 
  //Below codes are additional service method from what is defined in the Interface IMMspService
  public MmsUser getUserByID(int mmsUser) {  
      return mmspUserRepo.getByID(mmsUser);  
  }
  
  public MmsUser getByEmail(String email) {
	  
	  return mmspUserRepo.getByEmail(email);
  }
  
  public boolean isValidUserCrediential(String email,String password) {
	  
	  return mmspUserRepo.getByCredential(email,password) != null;
  }
  
  public AuthInformationDTO createAuthInfoDTO(String jwtToken,Date tokenExpiration, MmsUserDTO userDTO) {
	  
	  Set<Integer> listOfUserRoles = new HashSet<>();
	  for(var role : userDTO.getUserRoles()) {
		  listOfUserRoles.add(role.getUsrRoleId());
	  }
		
	  AuthInformationDTO responseAuthInfo = new AuthInformationDTO();
	  responseAuthInfo.setJwtToken(jwtToken);
	  responseAuthInfo.setUserId(userDTO.getUserId());
	  responseAuthInfo.setUserEmail(userDTO.getUserEmail());
	  responseAuthInfo.setUserFirstName(userDTO.getUserFirstname());
	  responseAuthInfo.setUserLastName(userDTO.getUserLastname());
	  responseAuthInfo.setTokenExpiration(tokenExpiration);
	  responseAuthInfo.setUserRoleIds(listOfUserRoles);
	  
	  return responseAuthInfo;
  }

} 
