package com.microservice.college.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.microservice.college.entities.RestTemplateVO;
import com.microservice.college.entities.college;


@Repository
public interface CollegeService {
	public List<college> getCollege();
	
	public college addCollege(college dt);
	
	public college getCollegeById(int id);
	
	public college updateColleget( int id,String deptname);
	
	public void deleteCollege(int id);
	
	public List<RestTemplateVO> getCollegewithstudent();
	
	public RestTemplateVO getcollegewithstudentbyid(int id);

}
