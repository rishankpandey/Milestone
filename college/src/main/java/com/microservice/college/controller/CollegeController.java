package com.microservice.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.college.dao.collegedao;
import com.microservice.college.entities.RestTemplateVO;
import com.microservice.college.entities.college;
import com.microservice.college.exception.MaxEmpReached;
import com.microservice.college.services.CollegeService;


@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	private CollegeService depts;
	
	@Autowired 
	private collegedao depdao;

	@GetMapping("/")
	public List<college> getCollege()
	{
		
		return this.depts.getCollege();
		
	}

	@PostMapping(consumes="application/json")
	public college addCollege( @RequestBody college dt)
	{
		
		return this.depts.addCollege(dt);
	 
	}
	
	@GetMapping("/{collegeid}")
	public college getCollegeById(@PathVariable("collegeid") int collegeid)
	{
		
		return this.depts.getCollegeById(collegeid);
	}
	
	
	@GetMapping("/collegewithstudent")
	public List<RestTemplateVO> getcollegementwithstudent()
	{
		return this.depts.getCollegewithstudent();
	}
	
	@GetMapping("/collegewithstudent/{collegeid}")
	public RestTemplateVO getcollegewithstudentbyid(@PathVariable("collegeid") int collegeid)
	{
		return this.depts.getcollegewithstudentbyid(collegeid);
	}
	
	
	@GetMapping("/studentadd/{cid}")
	public void addstud(@PathVariable("cid") int cid)
	{
		college temp=depdao.findById(cid).get();
		int c=temp.getTotalcountofstudents();
		temp.setTotalcountofstudents(c+1);
		depdao.save(temp);
		
	}

	@PutMapping("/{collegeid}/{name}")
	public college updatedepartment(@PathVariable(value="collegeid") int deptid,@PathVariable(value="name") String collegename)
	{
		return this.depts.updateColleget(deptid,collegename);
	}
	
	@DeleteMapping("/{deptid}")
	public void deletedepartment(@PathVariable(value="deptid") int deptid)
	{
		this.depts.deleteCollege(deptid);
	}
	
	

}
