package com.spring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.RegistrationService;
import com.spring.entity.Bank;
import com.spring.entity.User;

@RestController("/api")
public class RegistrationController {
	
	private RegistrationService registrationService;
	
	
	@PostMapping("api/register")
	public ResponseEntity<User> registerUser( @RequestParam(required=true,name="userName")  String userName, @RequestParam(required=true,name="password") String password) {
		User user=registrationService.registerUser(userName, password);
		return ResponseEntity.ok(user);
	}
	
	
	@PostMapping("api/login")
	public ResponseEntity<User> userLogin(@RequestParam(required=true,name="userName")  String userName, @RequestParam(required=true,name="password") String password) {
		User user=registrationService.userLogin(userName, password);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("api/getbanklist")
	public ResponseEntity<List<Bank>> getBankList() {
		List<Bank> bankList=registrationService.getBankList();
		return ResponseEntity.ok(bankList);
	}
	
	
	@PostMapping("api/getbankdata/{bankName}")
	public ResponseEntity<Bank> getUserInfoBankName(@PathVariable(required=true, name="bankName") String bankName) {
		Bank user=registrationService.getBankInfo(bankName);
		return ResponseEntity.ok(user);
	}
	
	
	@PostMapping("api/logintobank/bankName")
	public ResponseEntity<User> logintoBank(@RequestParam(required=true,name="userName")  String userName, @RequestParam(required=true,name="password") String password ) {
		User user=registrationService.userLogin(userName, password);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("api/getaccounts/bankname")
	public ResponseEntity<List<Bank>> getAccounts() {
		List<Bank> bankList=registrationService.getBankList();
		return ResponseEntity.ok(bankList);
	}
	

}
