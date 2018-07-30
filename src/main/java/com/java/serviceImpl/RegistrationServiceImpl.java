package com.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.service.RegistrationService;
import com.spring.entity.Bank;
import com.spring.entity.User;
import com.spring.repository.BankRepository;
import com.spring.repository.UserRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BankRepository BankRepository;

	@Override
	public com.spring.entity.User registerUser(String userName, String password) {

		User user = userRepository.getUserByName(userName);

		if (null == user) {
			return userRepository.save(new User(userName, password));
			// return new User(1, userName, password);
		}

		return null;
	}

	@Override
	public User userLogin(String userName, String password) {
		User user = userRepository.getUserByName(userName);
		String fetchedUserNameFromDatBase = "";
		if (null != user) {
			fetchedUserNameFromDatBase = user.getUserName();

			if (userName.toLowerCase().equalsIgnoreCase(fetchedUserNameFromDatBase.toLowerCase())
					&& password.toLowerCase().equalsIgnoreCase(user.getPassword().toLowerCase())) {
				return user;
			}
		}

		return null;
	}

	@Override
	public List<Bank> getBankList() {

		List<Bank> bankList = BankRepository.findAll();
		return bankList;
	}

	@Override
	public Bank getBankInfo(String bankName) {

		Bank bank = BankRepository.getBankByName(bankName);
		return bank;
	}

}
