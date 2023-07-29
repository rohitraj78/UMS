//package com.app.registration.controller;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.registration.model.LoginHistory;
//import com.app.registration.model.User;
//import com.app.registration.model.UserPojo;
//import com.app.registration.repository.LoginHistoryRepository;
//import com.app.registration.repository.UserRepository;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//
//public class UserController {
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	LoginHistoryRepository loginHistoryRepository;
//
//	@PostMapping(value = "/save")
//	public UserPojo saveUser(@RequestBody UserPojo userPojo) {
//		System.out.println();
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
//	
//	@PostMapping(value = "/savehistory")
//
//    public UserPojo saveHistory(@RequestBody UserPojo userPojo) {
//
//                    System.out.println("from save controller");
//
//
//
//                    LoginHistory his= new LoginHistory();
//
//                    LocalDateTime instant = LocalDateTime.now();
//
//
//
//                    his.setLastLoginTimeStamp(instant);
//
//                    his = loginHistoryRepository.save(his);
//
//                    userPojo.setLastLoginTimeStamp(his.getLastLoginTimeStamp());
//
//                    return userPojo;
//
//    }
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	@PostMapping("/validateLogin")
//	public String validateLogin(@RequestBody UserPojo nehrPojo) {
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
//			if (nehrPojo.getEmail().equals(user.getEmail()) && nehrPojo.getPassword().equals(user.getPassword())) {
//				loginHistory.setStatus("success");
//				loginHistoryRepository.save(loginHistory);
//				return "s";
//			} else {
//				loginHistory.setStatus("fail");
//				loginHistoryRepository.save(loginHistory);
//				return "f";
//			}
//
//		} catch (Exception e) {
//			return "f";
//		} finally {
//		}
//	}
//
//	@GetMapping("/get/{userId}")
//	public UserPojo listNehr(@PathVariable int userId) {
//		User user = userRepository.getReferenceById(userId);
//
//		UserPojo userPojo = new UserPojo();
//
//		userPojo.setUserId(user.getUserId());
//		userPojo.setEmail(user.getEmail());
//		userPojo.setLastLoginTimeStamp(user.getLastLoginTimeStamp());
//
//		List<LoginHistory> listLoginHistory = new ArrayList<LoginHistory>();
//
//		for (LoginHistory userent : user.getLoginHistory()) {
//			LoginHistory loginHistory = new LoginHistory();
//			loginHistory.setId(userent.getId());
//			loginHistory.setLastLoginTimeStamp(userent.getLastLoginTimeStamp());
//			loginHistory.setStatus(userent.getStatus());
//			
//			listLoginHistory.add(loginHistory);
//		}
//
//		userPojo.setListLoginHistory(listLoginHistory);
//		return userPojo;
//	}
//
//
//}
