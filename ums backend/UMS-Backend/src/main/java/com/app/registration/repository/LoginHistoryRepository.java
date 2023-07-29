package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.registration.model.LoginHistory;

@Repository("loginHistoryRepository")
public interface LoginHistoryRepository  extends JpaRepository<LoginHistory, Integer> {

}
