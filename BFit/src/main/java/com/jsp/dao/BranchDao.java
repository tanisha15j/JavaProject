package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Branch;

@Component
public class BranchDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Branch saveBranch(Branch branch) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();		
		return branch;
	}
	
	public boolean deleteBranchById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();	
			return true;
		}
		else {
			return false;
		}		
	}
	
	public Branch updateBranchById(Branch branch) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();		
		return branch;		
	}
	
	public Branch getBranchById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Branch.class, id);
	}
	
	public List<Branch> getAllBranchs() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT b from Branch b");
		return query.getResultList();
	}	

	
}