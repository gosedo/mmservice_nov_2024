package com.mmsystem.property.repo;


import java.util.List;  


import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;

import com.mmsystem.property.model.User;

import jakarta.transaction.Transactional;
  


@Repository 
public class UsersRepository  implements IMmspRepository<User> {  

  @Autowired  
  private SessionFactory sessionFactory;  
  
  @Transactional
  @Override  
  public boolean save(User mmspuser) {  
      boolean status=false;  
      try {  
          sessionFactory.getCurrentSession().persist(mmspuser);  
          status=true;  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
      return status;  
  }  

  @Override  
  public List<User> get() {  
		
		  Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<User> query = currentSession.createQuery("from User", User.class);
		  List<User> list = query.getResultList(); 
		  return list;
		     	
  }  

  @Transactional
  @Override  
  public boolean delete(User mmsUser) {  
      boolean status=false;  
      try {  
          sessionFactory.getCurrentSession().remove(mmsUser);  
          status=true;  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
      return status;  
  }  

  @Override  
  public User getByID(User mmsUser) {  
		
		  Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<User> query = currentSession
				  				.createQuery("from User where userId=:userId",User.class); 
		  query.setParameter("userId", mmsUser.getUserId());
		  List<User> list=query.getResultList(); 
		  return list.get(0);
		
  }  
  @Transactional
  @Override  
  public boolean update(User mmsUser) {  
      boolean status=false;  
      try {  
          sessionFactory.getCurrentSession().merge(mmsUser);  
          status=true;  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
      return status;  
  }  
    
    

}
