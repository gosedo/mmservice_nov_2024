package com.mmsystem.property.repo;

import java.util.List;
 

public interface IMmspRepository<T> {  

  public boolean save(T model);  
  public List<T> get();  
  public boolean delete(T model);  
  public T getByID(T model);  
  public boolean update(T model);  
} 
