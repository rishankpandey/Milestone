package com.springboot.mapping.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mapping.dao.StudentDao;
import com.springboot.mapping.entitites.Student;
import com.springboot.mapping.services.StudentService;
import com.springboot.mapping.sorting.sortbyage;

@RestController
@RequestMapping("/student")
public class MycontrollerStudent {
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private StudentDao stdao;
	
	
	@GetMapping
	public List<Student> getStudent()
	{
		
		return this.studentservice.getStudent();
		
	}

	@PostMapping(path="/add" , consumes="application/json")
	public String addStudent( @RequestBody Student st)
	{
     	return studentservice.addStudent(st);
			
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable(value= "id") int id)
	{
		
		return this.studentservice.getStudentById(id);
	}
		

	
	@GetMapping("/college/{id}")
	public List<Student> getStudentBycollegeId(@PathVariable(value= "id") int id)
	{
		List<Student> temp= stdao.findBycollegeid(id);
		//Collections.sort(temp,new sortbyage());
		return temp;
	}
	
	@GetMapping("/stream/{Stream}")
	public List<Student> getStudentByStream(@PathVariable(value= "Stream") String Stream)
	{
		return this.studentservice.getStudentByStream(Stream);
	}
}
