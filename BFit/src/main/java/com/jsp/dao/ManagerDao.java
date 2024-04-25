package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Branch;
import com.jsp.dto.Manager;

@Component
public class ManagerDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public Manager saveManager(Manager manager) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();		
		return manager;
	}
	
	public boolean deleteManagerById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Manager manager = entityManager.find(Manager.class, id);
		if(manager!=null) {
			entityTransaction.begin();
			entityManager.remove(manager);
			entityTransaction.commit();	
			return true;
		}
		else {
			return false;
		}		
	}
	
	public Manager updateManagerById(Manager manager) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();		
		return manager;		
	}
	
	public Manager getManagerById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Manager.class, id);
	}
	
	public List<Manager> getAllManagers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT m from Manager m");
		return query.getResultList();
	}
	
	
	public Manager managerLogin(Manager manager) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();		
		return manager;		
	}
	
	public boolean approveManager(Manager manager) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return true;
	}  
	
}
