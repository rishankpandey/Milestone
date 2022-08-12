package com.microservice.department;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_DEFAULTS;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.college.dao.collegedao;
import com.microservice.college.entities.college;
import com.microservice.college.services.CollegeServiceImpl;

@SpringBootTest(classes= {collegetest.class})
public class collegetest {
	
	
	@Mock
	private collegedao cod;
	
	@InjectMocks
	private CollegeServiceImpl collegeService;
	
	
	@Test
	public void getCollegeTest() throws Exception {
		
	 
		 List<college> mockcollege= new ArrayList<college>();
		college temp=new college(1,"IITK",2);
		mockcollege.add(temp);
	
		Mockito.when(collegeService.getCollege()).thenReturn(mockcollege);
		
		assertEquals(1,collegeService.getCollege().size());
		
	}
	
	@Test
	public void getallCollegeTest()
	{
		List<college> mockcollege= new ArrayList<college>();
		college temp=new college(1,"IITK",2);
		mockcollege.add(temp);
		
		Mockito.when(cod.findAll()).thenReturn(mockcollege);
		assertEquals(mockcollege,collegeService.getCollege());
	}
	
	@Test
	public void addCollegeTest()
	{
		college temp=new college(1,"IITK",2);
		
		Mockito.when(cod.save(temp)).thenReturn(temp);
		
		assertEquals(temp,collegeService.addCollege(temp));	
	}

}
