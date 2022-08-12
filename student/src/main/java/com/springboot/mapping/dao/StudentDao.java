package com.springboot.mapping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.springboot.mapping.entitites.Student;
 
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	List<Student> findBycollegeid(int collegeid);
	

}
