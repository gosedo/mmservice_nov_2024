package com.mmsystem.property.service;

import java.util.List;

import com.mmsystem.property.model.User;


public interface IMmspService {  
	      
    public boolean saveUser(User mmsUser);  
    public List<User> getUsers();  
    public boolean deleteUser(User mmsUser);  
    public User getUserByID(User mmsUser);  
    public boolean updateUser(User mmsUser);  
}
