package com.manish.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.manish.soap.webservices.soapcoursemanagement.soap.bean.Course;
import org.springframework.stereotype.Component;




@Component
public class CourseDetailsService {

	private static List<Course> courses= new ArrayList<>(); 
	
	static {
		Course course1 = new Course(1,"Spring","N Steps");
		courses.add(course1);
		
		Course course2 = new Course(2,"Spring2","N 2Steps");
		courses.add(course2);
		
		Course course3 = new Course(3,"3Spring","N3 Steps");
		courses.add(course3);
		
		Course course4 = new Course(4,"4Spring","N 4Steps");
		courses.add(course4);
	}
	
	public Course findById(int id) {
		for(Course course:courses) {
			if(course.getId()==id)
				return course;
		}
		
		return null;
	}
	
	public List<Course> findAll(){
		return courses;
	}
	
	
	public int deleteById(int id) {
		Iterator<Course> iterator =courses.iterator();
		
		while(iterator.hasNext()) {
			Course course =iterator.next();
			if(course.getId()==id) {
				iterator.remove();
				return 1;
			}
			
		}
		return 0;
	}
	
	
	
	
}
