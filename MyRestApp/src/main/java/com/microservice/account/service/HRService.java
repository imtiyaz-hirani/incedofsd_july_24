package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.account.model.HR;
import com.microservice.account.repository.HRRepository;

@Service
public class HRService {

	@Autowired
	private HRRepository hrRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public HR insertHR(HR hr) {
		String rawPass = hr.getUserInfo().getPassword();
		String encodedPass = passwordEncoder.encode(rawPass);
		hr.getUserInfo().setPassword(encodedPass);
		return hrRepository.save(hr);
	}

}
