package com.microservice.account.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.account.model.HR;
import com.microservice.account.repository.EmployeeRepository;
import com.microservice.account.repository.HRRepository;
import com.microservice.account.repository.ManagerRepository;

@Service
public class HRService {

	@Autowired
	private HRRepository hrRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public HR insertHR(HR hr) {
		String rawPass = hr.getUserInfo().getPassword();
		String encodedPass = passwordEncoder.encode(rawPass);
		hr.getUserInfo().setPassword(encodedPass);
		return hrRepository.save(hr);
	}

	public Map<String, Integer> getStat() {
		int countEmployees = employeeRepository.findAll().size();
		int countManager =managerRepository.findAll().size();
		Map<String, Integer> map = new HashMap<>();
		map.put("count_emoplyee", countEmployees);
		map.put("count_manager", countManager);
		return map;
	}

}
