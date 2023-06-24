package com.mmsystem.property.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.MmsUser;
import com.mmsystem.property.repo.UserRepository;




@Service  
@Transactional  
public class MmsUserService implements IMmspService {  
 
  @Autowired  
  private UserRepository mmspUserRepo;  
    
  @Override  
  public boolean saveUser(MmsUser mmsUser) {  
      return mmspUserRepo.save(mmsUser);  
  }  

  @Override  
  public List<MmsUser> getUsers() {  
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
  public MmsUser getUserByID(int mmsUser) {  
      return mmspUserRepo.getByID(mmsUser);  
  }
  
  public MmsUser getByEmail(String email) {
	  
	  return mmspUserRepo.getByEmail(email);
  }
  
  public boolean isValidUserCrediential(String email,String password) {
	  
	  return mmspUserRepo.getByCredential(email,password) != null;
  }

} 
