package com.mmsystem.property.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mmsystem.property.model.MmsProperty;
import com.mmsystem.property.model.PropertyManagement;
import com.mmsystem.property.model.Unit;

import jakarta.transaction.Transactional;


@Repository
public class MmsUnitsRepository  implements IMmspRepository<Unit> {

	@Autowired  
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean save(Unit model) {
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
	public List<Unit> get() {
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<Unit> query = currentSession.createQuery("from Unit", Unit.class);
		  List<Unit> list = query.getResultList(); 
		  return list;
	}

	@Transactional
	@Override
	public boolean delete(Unit model) {
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
	public Unit getByID(Unit model) {
		Session currentSession = sessionFactory.getCurrentSession(); 
		  Query<Unit> query = currentSession
				  				.createQuery("from Unit where unitId=:unitId",Unit.class); 
		  query.setParameter("unitId", model.getUnitId());
		  List<Unit> list=query.getResultList(); 
		  return list.get(0);
	}

	@Override
	public boolean update(Unit model) {
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
