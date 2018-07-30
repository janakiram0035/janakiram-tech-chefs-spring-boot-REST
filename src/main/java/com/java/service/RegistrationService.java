package com.java.service;

import java.util.List;

import com.spring.entity.Bank;
import com.spring.entity.User;

public interface RegistrationService {

	User registerUser(String userName, String password);
	
	User userLogin(String userName, String password);
	
	List<Bank> getBankList();
	
	Bank getBankInfo(String bankName);
}
