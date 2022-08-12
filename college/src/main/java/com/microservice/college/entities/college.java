package com.microservice.college.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="college")
@Builder
public class college {
	
	@Id
	private int collegeid;
	private String collegename;
	private int totalcountofstudents;
	
	
	public college() {
		super();
		// TODO Auto-generated constructor stub
	}


	public college(int collegeid, String collegename,int totalcountofstudents) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.totalcountofstudents=totalcountofstudents;
	}


	public int getCollegeid() {
		return collegeid;
	}


	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}


	public String getCollegename() {
		return collegename;
	}


	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}


	public int getTotalcountofstudents() {
		return totalcountofstudents;
	}


	public void setTotalcountofstudents(int totalcountofstudents) {
		this.totalcountofstudents = totalcountofstudents;
	}


	@Override
	public String toString() {
		return "college [collegeid=" + collegeid + ", collegename=" + collegename + ", totalcountofstudents="
				+ totalcountofstudents + "]";
	}
	

}

