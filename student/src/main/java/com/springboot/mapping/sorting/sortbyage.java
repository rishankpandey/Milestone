package com.springboot.mapping.sorting;

import java.util.Comparator;


import com.springboot.mapping.entitites.Student;

public class sortbyage implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o2.getAge()- o1.getAge();
	}

}
