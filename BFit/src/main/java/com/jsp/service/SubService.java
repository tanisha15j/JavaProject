package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.ManagerDao;
import com.jsp.dao.SubDao;
import com.jsp.dto.Manager;
import com.jsp.dto.Subscription;

@Component
public class SubService {

	@Autowired
	private SubDao subDao;
	
	@Autowired
	private ManagerDao managerDao;
	
	public Subscription saveSubscription(Subscription sub, int mid) {
		Manager manager = managerDao.getManagerById(mid);
		sub.setManager(manager);
		return subDao.saveSubscription(sub);
	}
	
	public boolean deleteSubscriptionById(int id) {
		return subDao.deleteSubscriptionById(id);
	}
	
	public Subscription updateSubscriptionById(int id, Subscription sub) {
		Subscription s = subDao.getSubscriptionById(id);
		s.setName(sub.getName());
		s.setPrice(sub.getPrice());
		s.setType(sub.getType());
		return subDao.updateSubscriptionById(sub);
	}

	public Subscription getSubscriptionById(int id) {
		return subDao.getSubscriptionById(id);
	}
	
	public List<Subscription> getAllSubscriptions() {
		return subDao.getAllSubscriptions();
	}
	
}
