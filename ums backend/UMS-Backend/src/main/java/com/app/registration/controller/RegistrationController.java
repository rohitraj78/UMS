package com.app.registration.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.LoginHistory;
//import com.app.registration.model.User;
import com.app.registration.model.UserPojo;
import com.app.registration.model.UserRegister;
import com.app.registration.repository.LoginHistoryRepository;
import com.app.registration.repository.RegistrationRepository;
//import com.app.registration.repository.UserRepository;
import com.app.registration.service.RegistrationService;

import java.util.List;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public UserRegister registerUser(@RequestBody UserRegister user) throws Exception  {
		String tempEmailId=user.getEmail();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			UserRegister userObj=service.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				
				throw new Exception("user with "+tempEmailId + " is already exist");
			}
		}

		

		
		UserRegister userObj=new UserRegister();
		LocalDateTime instant = LocalDateTime.now();
		
		user.setLastLoginTimeStamp(instant);
		userObj=service.saveUser(user);
		
		return userObj;
	}
	
	@PostMapping("/updateuser")
	@CrossOrigin(origins="http://localhost:4200")
	public UserRegister updateUser(@RequestBody UserRegister user) throws Exception  {
		String tempEmailId=user.getEmail();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			UserRegister userObj=service.fetchUserByEmailId(tempEmailId);
			
		}
		
		UserRegister userObj=null;
		userObj=service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public UserRegister loginUser(@RequestBody UserRegister user) throws Exception {
		String tempEmailId=user.getEmail();
		String tempPass=user.getPassword();
		UserRegister userObj=null;
		if(tempEmailId !=null && tempPass !=null) {
			
			
			
		userObj=	registrationRepository.findByEmailAndPassword(tempEmailId, tempPass);
		
		}
		if(userObj==null) {
			throw new Exception("bad Credentials");
		}
		
		return userObj;
		
		
	}  
	
	@GetMapping("/getuserlist")
	@CrossOrigin(origins="http://localhost:4200")
	public List<UserRegister> fetchUserList(){
		List<UserRegister> users=new ArrayList<UserRegister>();
		users=service.fetchUserList();
		return users;
	}
	
	@GetMapping("/getuserbyid/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public UserRegister fetchUserById(@PathVariable int id){
		return service.fetchUserById(id).get();	
	}
	@DeleteMapping("/deleteuserbyid/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<UserRegister>  DeleteUserById(@PathVariable int id)
	{
		List<UserRegister> userObj;
		 service.deleteUserById(id);
		 userObj=service.fetchUserList();
		   return userObj;
		   
    }
	
	
	@PostMapping("/validateLogin")
	@CrossOrigin(origins="http://localhost:4200")
	public LocalDateTime validateLogin(@RequestBody UserRegister nehrPojo) {
//		System.out.println("nehrPojo : "+nehrPojo.toString());
		try {
			UserRegister user = registrationRepository.findByEmail(nehrPojo.getEmail());
//		   
			LoginHistory loginHistory = new LoginHistory();

			loginHistory.setUserRegister(user);
                                                                                                                                                                                                                                                                    
			LocalDateTime instant = LocalDateTime.now();
			loginHistory.setLastLoginTimeStamp(instant);

			if (nehrPojo.getEmail().equals(user.getEmail()) ) {
				loginHistory.setStatus("success");
				loginHistoryRepository.save(loginHistory);
				return loginHistory.getLastLoginTimeStamp();
			} else {
				loginHistory.setStatus("fail");
				loginHistoryRepository.save(loginHistory);
				return null;
			}

		} catch (Exception e) {
			return null;
		} finally {
		}
	}
	
	
	//lastlogin
	
	
	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	LoginHistoryRepository loginHistoryRepository;

//	@PostMapping(value = "/save")
//	@CrossOrigin(origins="http://localhost:4200")
//	public UserPojo saveUser(@RequestBody UserPojo userPojo) {
//		
//		
//		User user = new User();
//
//		user.setEmail(userPojo.getEmail());
//		user.setPassword(userPojo.getPassword());
//
//		LocalDateTime instant = LocalDateTime.now();
//
//		user.setLastLoginTimeStamp(instant);
//		user = userRepository.save(user);
//
//		userPojo.setUserId(user.getUserId());
//		userPojo.setLastLoginTimeStamp(user.getLastLoginTimeStamp());
//		return userPojo;
//	}
	
	@PostMapping(value = "/savehistory")
	@CrossOrigin(origins="http://localhost:4200")
    public UserPojo saveHistory(@RequestBody UserPojo userPojo) {

                    System.out.println("from save controller");



                    LoginHistory his= new LoginHistory();

                    LocalDateTime instant = LocalDateTime.now();



                    his.setLastLoginTimeStamp(instant);

                    his = loginHistoryRepository.save(his);

                    userPojo.setLastLoginTimeStamp(his.getLastLoginTimeStamp());

                    return userPojo;

    }
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/validateLogin")
//	@CrossOrigin(origins="http://localhost:4200")
//	public LocalDateTime validateLogin(@RequestBody UserPojo nehrPojo) {
////		System.out.println("nehrPojo : "+nehrPojo.toString());
//		try {
//			User user = userRepository.findByEmail(nehrPojo.getEmail());
//			System.out.println("user : "+user.toString());
//			LoginHistory loginHistory = new LoginHistory();
//
//			loginHistory.setUser(user);
//
//			LocalDateTime instant = LocalDateTime.now();
//			loginHistory.setLastLoginTimeStamp(instant);
//
//			if (nehrPojo.getEmail().equals(user.getEmail()) ) {
//				loginHistory.setStatus("success");
//				loginHistoryRepository.save(loginHistory);
//				return loginHistory.getLastLoginTimeStamp();
//			} else {
//				loginHistory.setStatus("fail");
//				loginHistoryRepository.save(loginHistory);
//				return null;
//			}
//
//		} catch (Exception e) {
//			return null;
//		} finally {
//		}
//	}

	@GetMapping("/get/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<LoginHistory> listNehr(@PathVariable int id) {
		UserRegister user = registrationRepository.getReferenceById(id);

		UserPojo userPojo = new UserPojo();

		userPojo.setId(user.getId());
		userPojo.setEmail(user.getEmail());
		userPojo.setLastLoginTimeStamp(user.getLastLoginTimeStamp());

		List<LoginHistory> listLoginHistory = new ArrayList<LoginHistory>();

		for (LoginHistory userent : user.getLoginHistory()) {
			LoginHistory loginHistory = new LoginHistory();
			loginHistory.setId(userent.getId());
			loginHistory.setLastLoginTimeStamp(userent.getLastLoginTimeStamp());
			loginHistory.setStatus(userent.getStatus());
			
			listLoginHistory.add(loginHistory);
		}

		userPojo.setListLoginHistory(listLoginHistory);
		return listLoginHistory;
	}
	
	
	
	
	
	
	}
	
	

