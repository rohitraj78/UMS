package com.app.registration.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserRegister {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String gender;
	private String email;
	private long mobileNo;
	private String userType;
	
	@OneToMany(mappedBy="userRegister",cascade = CascadeType.ALL)
	  @JsonIgnore
	List<LoginHistory> loginHistory;
	
	LocalDateTime lastLoginTimeStamp;
	
	
	
	public UserRegister(int id, String firstName, String lastName, String password, String gender, String email,
			long mobileNo, String userType, List<LoginHistory> loginHistory, LocalDateTime lastLoginTimeStamp) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.mobileNo = mobileNo;
		this.userType = userType;
		this.loginHistory = loginHistory;
		this.lastLoginTimeStamp = lastLoginTimeStamp;
	}


	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<LoginHistory> getLoginHistory() {
		return loginHistory;
	}

	public void setLoginHistory(List<LoginHistory> loginHistory) {
		this.loginHistory = loginHistory;
	}

	public LocalDateTime getLastLoginTimeStamp() {
		return lastLoginTimeStamp;
	}

	public void setLastLoginTimeStamp(LocalDateTime lastLoginTimeStamp) {
		this.lastLoginTimeStamp = lastLoginTimeStamp;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	





	
	




}
