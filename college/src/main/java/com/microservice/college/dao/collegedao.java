package com.microservice.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.college.entities.college;


@Repository
public interface collegedao  extends JpaRepository<college, Integer> {
	
	  
}
