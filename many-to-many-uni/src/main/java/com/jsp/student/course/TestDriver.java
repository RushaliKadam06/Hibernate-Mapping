package com.jsp.student.course;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDriver {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student s1 = new Student();
		s1.setName("xyz");
		s1.setEmail("xyz@gmail.com");
		
		Course course1=new Course();
		course1.setName("SQL");
		course1.setDuration("1 Month");
		
		Course course2=new Course();
		course2.setName("SQL");
		course2.setDuration("1 Month");
		
		Course course3=new Course();
		course3.setName("SQL");
		course3.setDuration("1 Month");
		
		ArrayList<Course> courses=new ArrayList<Course>();
		courses.add(course3);
		courses.add(course2);
		courses.add(course1);
		
		s1.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
	}

}
