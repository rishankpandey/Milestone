package com.microservice.college.entities;

import java.util.List;

public class RestTemplateVO {
	private college co;
	private List<Student> stud;
	public college getCo() {
		return co;
	}
	public void setCo(college co) {
		this.co = co;
	}
	public List<Student> getStud() {
		return stud;
	}
	public void setStud(List<Student> stud) {
		this.stud = stud;
	}
	public RestTemplateVO(college co, List<Student> stud) {
		super();
		this.co = co;
		this.stud = stud;
	}
	public RestTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RestTemplateVO [co=" + co + ", stud=" + stud + "]";
	}
		

}
