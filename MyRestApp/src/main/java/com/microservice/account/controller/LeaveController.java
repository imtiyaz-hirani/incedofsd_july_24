package com.microservice.account.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.account.enums.LeaveStatus;
import com.microservice.account.model.Employee;
import com.microservice.account.model.Leave;
import com.microservice.account.service.EmployeeService;
import com.microservice.account.service.LeaveService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class LeaveController {

	@Autowired
	private LeaveService leaveService;
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/api/leave/post")
	public void postLeave(Principal principal, @RequestBody Leave leave) {
		String username = principal.getName();
		/* Fetch Employee on the based on username */
		Employee employee = employeeService.getEmployeeByUsername(username); 
		
		/* Attach the employee to Leave */
		leave.setEmployee(employee);
		leave.setStatus(LeaveStatus.PENDING);
		/*Save the Leave */
		leaveService.postLeave(leave);
	}
}
