package com.springboot.mapping.entitites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	private int id;
	private String name;
	private String gender;
	private int age;
	private int collegeid;
	private String Stream;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public Student(int id, String name,String gender,int age, int collegeid,String Stream) {
		super();
		this.id = id;
		this.name = name;
		this.gender=gender;
		this.age=age;
		this.collegeid = collegeid;
		this.Stream=Stream;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStream() {
		return Stream;
	}
	public void setStream(String stream) {
		Stream = stream;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", collegeid="
				+ collegeid + ", Stream=" + Stream + "]";
	}
	
	
	
		
	}
	

