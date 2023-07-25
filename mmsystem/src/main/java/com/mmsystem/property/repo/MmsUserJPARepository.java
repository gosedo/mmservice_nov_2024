package com.mmsystem.property.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mmsystem.property.model.MmsUser;

public interface MmsUserJPARepository extends JpaRepository<MmsUser, Integer>{
	
	MmsUser findByUserEmail(String userEmail);
	MmsUser findByActivationId(String activationId);
	
	@Query("FROM MmsUser c WHERE ((:userFirstname ='GGGG' ) "
			+ "or (c.userFirstname = :userFirstname )) "
			+ "and (:userLastname = 'GGGG' "
			+ " or c.userLastname = :userLastname) and"
			+ "(:userEmail = 'GGGG' or c.userEmail =:userEmail)")
	Page<MmsUser> findUserByNameAndEmail(@Param("userFirstname") String userFirstname
		,@Param("userLastname") String userLastname
		,@Param("userEmail") String userEmail
		,Pageable pageable);

}
