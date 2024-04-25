package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Admin;

@Component
public class AdminDao {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Admin saveAdmin(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();		
		return admin;
	}
	
	public boolean deleteAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Admin admin = entityManager.find(Admin.class, id);
		if(admin!=null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();	
			return true;
		}
		else {
			return false;
		}		
	}
	
	public Admin updateAdminById(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();		
		return admin;		
	}
	
	public Admin getAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Admin.class, id);
	}
	
	public List<Admin> getAllAdmins() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT a from Admin a");
		return query.getResultList();
	}
	
	
	public Admin adminLogin(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();		
		return admin;		
	}
	
}
