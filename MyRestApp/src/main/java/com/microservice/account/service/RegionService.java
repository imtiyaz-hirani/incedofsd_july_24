package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Region;
import com.microservice.account.repository.RegionRepository;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	public Region saveRegion(Region region) {
		 
		return regionRepository.save(region);
	}

}
