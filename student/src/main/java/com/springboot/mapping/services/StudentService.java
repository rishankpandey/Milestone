package com.springboot.mapping.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.springboot.mapping.entitites.Student;


@Repository
public interface StudentService{
	
	public List<Student> getStudent();
	
	public String addStudent(Student st);
	
	public Optional<Student> getStudentById(int id);

	public List<Student> getStudentByStream(String stream);
		

}
