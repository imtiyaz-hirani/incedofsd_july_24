package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Manager;
import com.microservice.account.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Manager insertManager(Manager manager) {
		String rawPass = manager.getUserInfo().getPassword();
		String encodedPass = passwordEncoder.encode(rawPass);
		manager.getUserInfo().setPassword(encodedPass);
		return managerRepository.save(manager);
	}

}
