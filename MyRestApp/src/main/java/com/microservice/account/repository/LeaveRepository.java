package com.microservice.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.account.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{

}
