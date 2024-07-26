package com.microservice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.account.model.Employee;
import com.microservice.account.model.Task;
import com.microservice.account.repository.EmployeeRepository;
import com.microservice.account.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private TaskRepository taskRepository;
	
	public void assignTask(int eid, Task task) {
		Employee employee = employeeRepository.findById(eid).get();
		task.setEmployee(employee);
		taskRepository.save(task);
	}

}
