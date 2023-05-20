package com.mmsystem.property.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmsystem.property.model.PropertyManagement;
import com.mmsystem.property.model.User;

import jakarta.transaction.Transactional;


@Repository
public class PropMgmtsRepository implements IMmspRepository<PropertyManagement>{

	@Autowired  
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean save(PropertyManagement model) {
		
		boolean status=false;  
	      try {  
	          sessionFactory.getCurrentSession().persist(model);  
	          status=true;  
	      } catch (Exception e) {  
	          e.printStackTrace();  
	      }  
	      return status;  
				
	}

	@Override
	public List<PropertyManagement> get() {
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<PropertyManagement> query = currentSession.createQuery("from PropertyManagement", PropertyManagement.class);
		  List<PropertyManagement> list = query.getResultList(); 
		  return list;
	}
	
	@Transactional
	@Override
	public boolean delete(PropertyManagement model) {
		boolean status=false;  
	      try {  
	          sessionFactory.getCurrentSession().remove(model);  
	          status=true;  
	      } catch (Exception e) {  
	          e.printStackTrace();  
	      }  
	      return status; 
		
	}

	@Override
	public PropertyManagement getByID(PropertyManagement model) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<PropertyManagement> query = currentSession
				  				.createQuery("from PropertyManagement where pMgmtId=:pMgmtId",PropertyManagement.class); 
		  query.setParameter("pMgmtId", model.getpMgmtId());
		  List<PropertyManagement> list=query.getResultList(); 
		  return list.get(0);
	}

	@Override
	public boolean update(PropertyManagement model) {
		boolean status=false;  
	      try {  
	          sessionFactory.getCurrentSession().merge(model);  
	          status=true;  
	      } catch (Exception e) {  
	          e.printStackTrace();  
	      }  
	      return status; 
	}

}
