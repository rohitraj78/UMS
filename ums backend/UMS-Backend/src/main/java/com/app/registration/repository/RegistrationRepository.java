package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model. UserRegister;
@Repository("registrationRepository")
public interface RegistrationRepository extends JpaRepository< UserRegister,Integer> {

	public UserRegister findByEmail(String email);
	public UserRegister findByEmailAndPassword(String email,String password);
}
