package com.mmsystem.property.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.model.User;
import com.mmsystem.property.repo.UserRepository;



@Service  
@Transactional  
public class MmspUserService implements IMmspService {  
 
  @Autowired  
  private UserRepository mmspUserRepo;  
    
  @Override  
  public boolean saveUser(User mmsUser) {  
      return mmspUserRepo.save(mmsUser);  
  }  

  @Override  
  public List<User> getUsers() {  
      return mmspUserRepo.get();  
  }  

  @Override  
  public boolean deleteUser(User mmsUser) {  
      return mmspUserRepo.delete(mmsUser);  
  }  

  @Override  
  public User getUserByID(User mmsUser) {  
      return mmspUserRepo.getByID(mmsUser);  
  }  

  @Override  
  public boolean updateUser(User mmsUser) {  
      return mmspUserRepo.update(mmsUser);  
  }  

} 
