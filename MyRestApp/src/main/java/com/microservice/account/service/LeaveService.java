package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Leave;
import com.microservice.account.repository.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;
	
	public void postLeave(Leave leave) {
		leaveRepository.save(leave);
		
	}

}
