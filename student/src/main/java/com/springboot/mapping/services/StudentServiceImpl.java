package com.springboot.mapping.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.mapping.dao.StudentDao;
import com.springboot.mapping.entitites.Student;
import com.springboot.mapping.sorting.sortbyage;



@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao stud;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String addStudent(Student st) {
		// TODO Auto-generated method stub
		int cid=st.getCollegeid();
	    restTemplate.getForEntity("http://COLLEGE-SERVICE/college/studentadd/"+ cid, String.class);
		stud.save(st);
		return "Student Added";
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		// TODO Auto-generated method stub
		return stud.findById(id);
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return stud.findAll();
	}

	@Override
	public List<Student> getStudentByStream(String stream) {
		List<Student> stu= stud.findAll();
		List<Student> select=new ArrayList<Student>();
		for(int i=0;i<stu.size();i++)
		{
			Student temp=stu.get(i);
			if(temp.getStream().equals(stream))
				select.add(temp);		
		}
		Collections.sort(select,new sortbyage());
		return select;
		
	}
	}


