package com.mmsystem.property.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity  
@Table(name="mmstenants")
public class MmsTenant {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "tenantId")
    private int tenantId;
	@ManyToOne(cascade = CascadeType.ALL)
	private MmsUser tenantInfo;
	@ManyToOne(cascade = CascadeType.ALL)
	private MmsUnit tenantUnit;
	private boolean isCurrent;
	private LocalDateTime createdOnDate;
	private LocalDateTime statusModifiedDate;
	
	
	
		
}
