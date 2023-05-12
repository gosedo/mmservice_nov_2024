package com.mmsystem.property.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity  
@Table(name="mmsuser")  
public class User{  
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "userId")
    private int UserId; 
    
    @Column(name = "userEmail")
    private String userEmail;
    
    @Column(name = "userPassword")
   	private String userPassword;
    
    @Column(name = "userFirstname")
    private String userFirstname;
    
    @Column(name = "userLastname")
    private String userLastname;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTypeId" , nullable=false)
    private UserType userType;
    
    @Column(name = "userStatus")
    private String userStatus;
    
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	  
	  
}  
