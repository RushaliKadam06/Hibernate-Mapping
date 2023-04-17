package com.jsp.map.cascadejoincolumn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDriver {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushali");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=new Bank();
		bank.setBankName("SBI");
		
		Branch branch1=new Branch();
		branch1.setBranchName("SBI-1");
		branch1.setIFSCcode("SBI600");
		
		Branch branch2=new Branch();
		branch2.setBranchName("SBI-2");
		branch2.setIFSCcode("SBI700");
		
		Branch branch3=new Branch();
		branch3.setBranchName("SBI-3");
		branch3.setIFSCcode("SBI800");
		
		List<Branch> branchs=new ArrayList<Branch>();
		branchs.add(branch3);
		branchs.add(branch2);
		branchs.add(branch1);
		
		bank.setBranches(branchs);
		branch1.setBank(bank);
		branch2.setBank(bank);
		branch3.setBank(bank);
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch3);
		entityTransaction.commit();
	}

}
