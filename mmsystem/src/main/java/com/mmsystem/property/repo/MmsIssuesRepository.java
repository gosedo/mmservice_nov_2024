package com.mmsystem.property.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmsystem.property.model.MaintenanceIssue;
import com.mmsystem.property.model.PropertyManagement;
import com.mmsystem.property.model.User;

import jakarta.transaction.Transactional;


@Repository
public class MmsIssuesRepository implements IMmspRepository<MaintenanceIssue>{

	@Autowired  
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean save(MaintenanceIssue model) {
		
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
	public List<MaintenanceIssue> get() {
		
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<MaintenanceIssue> query = currentSession.createQuery("from MaintenanceIssue", MaintenanceIssue.class);
		  List<MaintenanceIssue> list = query.getResultList(); 
		  return list;
	}
	
	@Transactional
	@Override
	public boolean delete(MaintenanceIssue model) {
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
	public MaintenanceIssue getByID(MaintenanceIssue model) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<MaintenanceIssue> query = currentSession
				  				.createQuery("from MaintenanceIssue where issueId=:issueId",MaintenanceIssue.class); 
		  query.setParameter("issueId", model.getIssueId());
		  List<MaintenanceIssue> list=query.getResultList(); 
		  return list.get(0);
	}

	@Override
	public boolean update(MaintenanceIssue model) {
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
