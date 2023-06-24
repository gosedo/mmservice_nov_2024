package com.mmsystem.property.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mmsystem.property.model.MmsMaintenanceIssue;

import jakarta.transaction.Transactional;


@Repository
public class MmsIssuesRepository implements IMmspRepository<MmsMaintenanceIssue>{

	@Autowired  
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean save(MmsMaintenanceIssue model) {
		
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
	public List<MmsMaintenanceIssue> get() {
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<MmsMaintenanceIssue> query = currentSession.createQuery("from MmsMaintenanceIssue", MmsMaintenanceIssue.class);
		  List<MmsMaintenanceIssue> list = query.getResultList(); 
		  return list;
	}
	
	@Transactional
	@Override
	public boolean delete(MmsMaintenanceIssue model) {
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
	public MmsMaintenanceIssue getByID(MmsMaintenanceIssue model) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<MmsMaintenanceIssue> query = currentSession
				  				.createQuery("from MmsMaintenanceIssue where issueId=:issueId",MmsMaintenanceIssue.class); 
		  query.setParameter("issueId", model.getIssueId());
		  List<MmsMaintenanceIssue> list=query.getResultList(); 
		  return list.get(0);
	}

	@Override
	public boolean update(MmsMaintenanceIssue model) {
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
