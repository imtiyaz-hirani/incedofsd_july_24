package com.microservice.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
