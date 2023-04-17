package com.jsp.hospital.branch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDriver {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setName("Hinduja");
		hospital.setGst("123abc");
		
		Branch branch1=new Branch();
		branch1.setLocation("Ghatkopar");
		branch1.setName("Hinduja-1");
		
		Branch branch2=new Branch();
		branch2.setLocation("Mumbai");
		branch2.setName("Hinduja-2");
		
		Branch branch3=new Branch();
		branch3.setLocation("Navimumbai");
		branch3.setName("Hinduja-3");
		
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
		
	}

}
