package com.mmsystem.property.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mmsystem.property.model.MmsUser;

public interface MmsUserJPARepository extends JpaRepository<MmsUser, Integer>{
	
	MmsUser findByUserEmail(String userEmail);

}
