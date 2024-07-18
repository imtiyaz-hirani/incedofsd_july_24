package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.enums.RoleType;
import com.microservice.account.model.UserInfo;
import com.microservice.account.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo insertUserInfo(UserInfo userInfo) {
		userInfo.setRole(RoleType.EMPLOYEE);
		return userInfoRepository.save(userInfo);
	}

}
