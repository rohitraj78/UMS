package com.app.registration.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserPojo {
	
	private int id;
	private String email;
	private String password;
	LocalDateTime lastLoginTimeStamp;
	
	List<LoginHistory> listLoginHistory = new ArrayList();

	
	public List<LoginHistory> getListLoginHistory() {
		return listLoginHistory;
	}
	public void setListLoginHistory(List<LoginHistory> listLoginHistory) {
		this.listLoginHistory = listLoginHistory;
	}
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.id = userId;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getLastLoginTimeStamp() {
		return lastLoginTimeStamp;
	}
	public void setLastLoginTimeStamp(LocalDateTime lastLoginTimeStamp) {
		this.lastLoginTimeStamp = lastLoginTimeStamp;
	}
	public UserPojo save(Object userPojo) {
	     //TODO Auto-generated method stub	   
	     return null;
 }
	@Override
    public String toString() {
        return this.id + " + " + this.password + "i";
    }
				


}
