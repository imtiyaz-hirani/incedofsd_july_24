package com.microservice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.model.Project;
import com.microservice.account.model.Region;
import com.microservice.account.service.ProjectService;
import com.microservice.account.service.RegionService;

@RestController
public class ProjectController {

	@Autowired
	private RegionService regionService;
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/api/project/add/{regionId}")
	public Project postProject(@PathVariable("regionId") int regionId,  @RequestBody Project project) {
		
		/* Fetch region obj based on regionid */
		
		/* Attach region to project */
		
		/* Save project */
		return null; 
	}
}
