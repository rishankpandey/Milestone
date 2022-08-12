package com.microservice.department;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.college.controller.CollegeController;
import com.microservice.college.entities.college;
import com.microservice.college.services.CollegeService;

@ComponentScan(basePackages= "com.microservice.college")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {ControllerTest.class})
public class ControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	private CollegeService collegeservice;
	
	@InjectMocks
	private CollegeController cc;
	
	@BeforeEach
	public void setUp()
	{
		mockMvc=MockMvcBuilders.standaloneSetup(cc).build();
	}
	
	@Test
	public void getCollegetest() throws Exception
	{
		List<college> mockcollege= new ArrayList<college>();
		college temp=new college(1,"IITK",2);
		mockcollege.add(temp);
		
		Mockito.when(collegeservice.getCollege()).thenReturn(mockcollege);
		
		RequestBuilder requestbuilder= MockMvcRequestBuilders.get("http://localhost:8083/college/").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestbuilder).andReturn();
		
		String outputinjson= result.getResponse().getContentAsString();
	    System.out.println(outputinjson);
		String expected= this.mapToJson(mockcollege);
		
		JSONAssert.assertEquals(expected, outputinjson, false);	
		
	}	
	
	private String mapToJson(Object object) throws JsonProcessingException
	{
		ObjectMapper objectmapper= new ObjectMapper();
		return objectmapper.writeValueAsString(object);
	}
		
	}
