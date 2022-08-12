package com.microservice.college.sorting;

import java.util.Comparator;

import com.microservice.college.entities.Student;

public class sortbyname  implements Comparator<Student>{

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		return a.getName().compareTo(b.getName());
	}

}
