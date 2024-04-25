package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Timeslot;

@Component
public class TimeslotDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Timeslot saveTimeslot(Timeslot timeslot) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(timeslot);
		entityTransaction.commit();		
		return timeslot;
	}
	
	public boolean deleteTimeslotById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Timeslot timeslot = entityManager.find(Timeslot.class, id);
		if(timeslot!=null) {
			entityTransaction.begin();
			entityManager.remove(timeslot);
			entityTransaction.commit();	
			return true;
		}
		else {
			return false;
		}		
	}
	
	public Timeslot updateTimeslotById(Timeslot timeslot) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(timeslot);
		entityTransaction.commit();		
		return timeslot;		
	}
	
	public Timeslot getTimeslotById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Timeslot.class, id);
	}
	
	public List<Timeslot> getAllTimeslots() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT t from Timeslot t");
		return query.getResultList();
	}	
	
	public boolean bookTimeslot(Timeslot timeslot) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(timeslot);
		entityTransaction.commit();
		return true;
	}  
	
	
}
