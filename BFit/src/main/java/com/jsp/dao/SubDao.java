package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Subscription;

@Component
public class SubDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Subscription saveSubscription(Subscription sub) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(sub);
		entityTransaction.commit();		
		return sub;
	}
	
	public boolean deleteSubscriptionById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Subscription sub = entityManager.find(Subscription.class, id);
		if(sub!=null) {
			entityTransaction.begin();
			entityManager.remove(sub);
			entityTransaction.commit();	
			return true;
		}
		else {
			return false;
		}		
	}
	
	public Subscription updateSubscriptionById(Subscription sub) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(sub);
		entityTransaction.commit();		
		return sub;		
	}
	
	public Subscription getSubscriptionById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Subscription.class, id);
	}
	
	public List<Subscription> getAllSubscriptions() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT s from Subscription s");
		return query.getResultList();
	}	
	
}
