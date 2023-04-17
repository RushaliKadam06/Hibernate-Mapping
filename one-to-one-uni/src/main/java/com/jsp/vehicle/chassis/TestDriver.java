package com.jsp.vehicle.chassis;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDriver {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setName("Nexon");
		vehicle.setBrand("TATA");
		vehicle.setColor("White");
		vehicle.setPrice(1300000);
		
		Chassis chassis=new Chassis();
		chassis.setChassis_No("4567MHB");
		vehicle.setChassis(chassis);
		System.out.println(vehicle.getChassis().getChassis_No());
		entityTransaction.begin();
		entityManager.persist(vehicle);
		entityManager.persist(chassis);
		entityTransaction.commit();
	}

}
