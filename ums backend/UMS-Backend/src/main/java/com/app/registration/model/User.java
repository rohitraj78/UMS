//package com.app.registration.model;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import javax.persistence.Entity;
//
//
//
//
//@Table(name = "icici_user1")
//@Entity
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	int userId;
//
//	
//	String email;
//	
//	@Column(name="password")
//	String password1;
//	
////	@Column(name="id")
////	String password;
//	
//	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
//	List<LoginHistory> loginHistory;
//	
//	LocalDateTime lastLoginTimeStamp;
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	
//
//	public String getPassword() {
//		return password1;
//	}
//
//	public void setPassword(String password) {
//		this.password1 = password;
//	}
//
//	public List<LoginHistory> getLoginHistory() {
//		return loginHistory;
//	}
//
//	public void setLoginHistory(List<LoginHistory> loginHistory) {
//		this.loginHistory = loginHistory;
//	}
//
//	public LocalDateTime getLastLoginTimeStamp() {
//		return lastLoginTimeStamp;
//	}
//
//	public void setLastLoginTimeStamp(LocalDateTime lastLoginTimeStamp) {
//		this.lastLoginTimeStamp = lastLoginTimeStamp;
//	}
//	@Override
//    public String toString() {
//        return this.userId + " + " + this.lastLoginTimeStamp + "i";
//    }
//		
//				
//	
//}
