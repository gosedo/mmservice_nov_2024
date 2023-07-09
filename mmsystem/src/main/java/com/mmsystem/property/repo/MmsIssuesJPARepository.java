package com.mmsystem.property.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mmsystem.property.model.MmsMaintenanceIssue;


public interface MmsIssuesJPARepository extends JpaRepository<MmsMaintenanceIssue, Long>  {

}

