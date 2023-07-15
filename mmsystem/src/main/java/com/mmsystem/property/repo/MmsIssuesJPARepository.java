package com.mmsystem.property.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmsystem.property.model.MmsMaintenanceIssue;


public interface MmsIssuesJPARepository extends JpaRepository<MmsMaintenanceIssue, Long>  {
	
	List<MmsMaintenanceIssue> findByRequestedByTenantInfoUserEmail(String userEmail);
	List<MmsMaintenanceIssue> findByRequestedByTenantInfoUserId(Long userId);
	Page<MmsMaintenanceIssue> findByCreatedOnDateGreaterThanEqualAndCreatedOnDateLessThanEqualAndRequestedByTenantInfoUserId(
			LocalDateTime startDate,LocalDateTime endData,Long userId,
			 Pageable pageable);
}

