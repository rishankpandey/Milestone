package com.microservice.college.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.college.dao.collegedao;


import com.microservice.college.entities.RestTemplateVO;
import com.microservice.college.entities.Student;
import com.microservice.college.entities.college;

import com.microservice.college.sorting.sortbyage;
import com.microservice.college.sorting.sortbyname;

@Service
@Component
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	private collegedao cod;
	
	@Autowired
	private RestTemplate restTemplate;

	

	@Override
	public List<college> getCollege() {
		// TODO Auto-generated method stub
		return cod.findAll();
	}

	@Override
	public college addCollege(college co) {
		// TODO Auto-generated method stub
		cod.save(co);
		return co;
	}

	@Override
	public college getCollegeById(int id) {
		// TODO Auto-generated method stub
	
		return cod.findById(id).get();
	}

	@Override
	public college updateColleget(int id, String colname) {
		// TODO Auto-generated method stub
		
		college co= cod.findById(id).get();
		co.setCollegename(colname);
		cod.save(co);
		return co;
	}

	@Override
	public void deleteCollege(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RestTemplateVO> getCollegewithstudent() {
		
		 List<college> dt=cod.findAll();
		 int len=dt.size();
		 List<RestTemplateVO> finallist = new ArrayList<RestTemplateVO>();
		 for(int i=1;i<=len;i++)
		 {
			 RestTemplateVO vo=new RestTemplateVO();
			 college d=cod.findById(i).get();
			 vo.setCo(d);
			 ResponseEntity<Student[]> e= restTemplate.getForEntity("http://STUDENT-SERVICE/student/college/"+ d.getCollegeid(), Student[].class);
			    Student[] emp=e.getBody();
			    List<Student> list = new ArrayList<Student>();
			    for(Student temp:emp)
			    	{list.add(temp);}
			    Collections.sort(list, new sortbyname());
			 vo.setStud(list) ;
			 finallist.add(vo);
		 }
		 
		 return finallist;
		 
	}

	@Override
	public RestTemplateVO getcollegewithstudentbyid(int id) {
		 RestTemplateVO vo=new RestTemplateVO();
		college co=cod.findById(id).get();
		 vo.setCo(co);
		 ResponseEntity<Student[]> e= restTemplate.getForEntity("http://STUDENT-SERVICE/student/college/"+ co.getCollegeid(), Student[].class);
		    Student[] emp=e.getBody();
		    List<Student> list = new ArrayList<Student>();
		    for(Student temp:emp)
		    	{list.add(temp);}
		    Collections.sort(list,new sortbyage());
		 vo.setStud(list) ;
		return vo;
	}


}
