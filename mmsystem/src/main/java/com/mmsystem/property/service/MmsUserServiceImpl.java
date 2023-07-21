package com.mmsystem.property.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.AuthInformationDTO;
import com.mmsystem.property.dto.MmsUserCreateDTO;
import com.mmsystem.property.dto.MmsUserDTO;
import com.mmsystem.property.dto.MmsUserUpdateDTO;
import com.mmsystem.property.exception.ResourceAlreadyExistsException;
import com.mmsystem.property.exception.ResourceNotFoundException;
import com.mmsystem.property.mapper.MmsMaintenanceIssueMapper;
import com.mmsystem.property.mapper.MmsTechTaskMapper;
import com.mmsystem.property.mapper.MmsUserMapper;
import com.mmsystem.property.model.MmsTechTask;
import com.mmsystem.property.model.MmsUser;
import com.mmsystem.property.model.MmsUserRole;
import com.mmsystem.property.model.MmsUserStatus;
import com.mmsystem.property.repo.MmsIssuesRepository;
import com.mmsystem.property.repo.MmsUserJPARepository;
import com.mmsystem.property.repo.UserRepository;
import com.mmsystem.property.util.UserStatusesConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Service  
@Transactional  
public class MmsUserServiceImpl implements MmsUserService {  
 
  @Autowired  
  private UserRepository mmspUserRepo;
  
  @Autowired  
  private MmsUserJPARepository mmspUserJpaRepo; 
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Autowired
  private MmsUserRoleServiceImpl mmsUserRoleServiceImpl;
  
  @Autowired
  private MmsUserStatusServiceImpl mmsUserStatusServiceImpl;
  
  //Start using JPA Repo
  
  @Override
  public MmsUserDTO createUser(MmsUserCreateDTO mmsUserCreateDto) throws ResourceAlreadyExistsException { 
	  
	  
	  MmsUser checkUserExists = mmspUserJpaRepo.findByUserEmail(mmsUserCreateDto.getUserEmail());
	  
	  if(checkUserExists != null) {
		  String message = String.format("User with %s email already exist. ", mmsUserCreateDto.getUserEmail());
		  throw new ResourceAlreadyExistsException(message);
	  }
		  
	  
	  MmsUser userToSave = new MmsUser();
	  Set<MmsUserRole> userRoles = mmsUserRoleServiceImpl.getUserRoles(mmsUserCreateDto.getUserRoles());
	  MmsUserStatus mmsUserStatus =mmsUserStatusServiceImpl.getUserStatusById(UserStatusesConstants.Active);
	  
	  userToSave.setUserEmail(mmsUserCreateDto.getUserEmail());
	  userToSave.setUserPassword(mmsUserCreateDto.getUserPassword());
	  userToSave.setUserFirstname(mmsUserCreateDto.getUserFirstname());
	  userToSave.setUserLastname(mmsUserCreateDto.getUserLastname());
	  userToSave.setUserPhone(mmsUserCreateDto.getUserPhone());
	  userToSave.setUserRoles(userRoles);
	  userToSave.setUserStatus(mmsUserStatus);
	  
	  String passwd= userToSave.getUserPassword();
	  String encodedPasswod = passwordEncoder.encode(passwd);
	  userToSave.setUserPassword(encodedPasswod);
	  
	  MmsUser mmsUserSaved = mmspUserJpaRepo.save(userToSave); 
      
      return MmsUserMapper.INSTANCE.mapToUserDto(mmsUserSaved);
  }
  
  @Override
  public MmsUserDTO updateUser(MmsUserUpdateDTO mmsUserUpdateDTO) throws ResourceNotFoundException { 
	  
	  MmsUser checkUserExists = mmspUserJpaRepo.findById(mmsUserUpdateDTO.getUserId()).get();
	  
	  if(checkUserExists == null) {
		  String message = String.format("User with %s userId doesn't exist. ", mmsUserUpdateDTO.getUserId());
		  throw new ResourceNotFoundException(message);
	  }
	  
	  
	  MmsUser userToUpdate = mmspUserJpaRepo.findById(mmsUserUpdateDTO.getUserId()).get();
	  Set<MmsUserRole> userRoles = mmsUserRoleServiceImpl.getUserRoles(mmsUserUpdateDTO.getUserRoles());
	  MmsUserStatus mmsUserStatus =mmsUserStatusServiceImpl.getUserStatusById(mmsUserUpdateDTO.getUserStatus());
	  
	  userToUpdate.setUserEmail(mmsUserUpdateDTO.getUserEmail());
	  userToUpdate.setUserPassword(mmsUserUpdateDTO.getUserPassword());
	  userToUpdate.setUserFirstname(mmsUserUpdateDTO.getUserFirstname());
	  userToUpdate.setUserLastname(mmsUserUpdateDTO.getUserLastname());
	  userToUpdate.setUserPhone(mmsUserUpdateDTO.getUserPhone());
	  userToUpdate.setUserRoles(userRoles);
	  userToUpdate.setUserStatus(mmsUserStatus);
	  
	  String passwd= userToUpdate.getUserPassword();
	  String encodedPasswod = passwordEncoder.encode(passwd);
	  userToUpdate.setUserPassword(encodedPasswod);
	  
	  MmsUser mmsUserUpdated = mmspUserJpaRepo.save(userToUpdate);
	  
	  MmsUserDTO returnUserDTO = MmsUserMapper.INSTANCE.mapToUserDto(mmsUserUpdated);
	  
      
      return returnUserDTO;
  }
  
  
  @Override
  public List<MmsUserDTO> getUsers() { 
	  
	List<MmsUser> listOfUsers = mmspUserJpaRepo.findAll();
	List<MmsUserDTO> listOfUsersDto = listOfUsers
			  							.stream()
			  							.map(user -> MmsUserMapper.INSTANCE.mapToUserDto(user))
			  							.collect(Collectors.toList());
			  

      return listOfUsersDto;  
  } 
  
  //End using JPA Repo
  
    
  @Override
  public MmsUserDTO saveUser(MmsUserDTO mmsUserDto) { 
	  
	  MmsUser mmsUser = MmsUserMapper.INSTANCE.mapToUser(mmsUserDto);
	  
      mmspUserRepo.save(mmsUser); 
      
      return MmsUserMapper.INSTANCE.mapToUserDto(mmsUser);
  }  

  @Override
  public List<MmsUser> getUsersOld() {  
      return mmspUserRepo.get();  
  }  

  @Override 
  public boolean deleteUser(MmsUser mmsUser) {  
      return mmspUserRepo.delete(mmsUser);  
  }  

  @Override 
  public MmsUser getUserByID(MmsUser mmsUser) {  
      return mmspUserRepo.getByID(mmsUser);  
  } 
  
  @Override 
  public boolean updateUser(MmsUser mmsUser) {  
      return mmspUserRepo.update(mmsUser);  
  } 
  //Below codes are additional service method from what is defined in the Interface IMMspService
  @Override
  public MmsUser getUserByID(int mmsUser) {  
      return mmspUserRepo.getByID(mmsUser);  
  }
  @Override
  public MmsUser getByEmail(String email) {
	  
	  return mmspUserRepo.getByEmail(email);
  }
  @Override
  public boolean isValidUserCrediential(String email,String password) {
	  
	  return mmspUserRepo.getByCredential(email,password) != null;
  }
  @Override
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
