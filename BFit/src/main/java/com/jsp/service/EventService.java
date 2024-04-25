package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.BranchDao;
import com.jsp.dao.EventDao;
import com.jsp.dao.ManagerDao;
import com.jsp.dao.SubDao;
import com.jsp.dto.Branch;
import com.jsp.dto.Event;
import com.jsp.dto.Manager;
import com.jsp.dto.Subscription;

@Component
public class EventService {

	@Autowired
	private EventDao eventDao;
	
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private SubDao subDao;
	
	public Event saveEvent(Event event, int mid, int bid, int sid) {
		Manager manager = managerDao.getManagerById(mid);
		Branch branch = branchDao.getBranchById(bid);
		Subscription subscription = subDao.getSubscriptionById(sid);
		event.setManager(manager);
		event.setBranch(branch);
		event.setSubscription(subscription);
		return eventDao.saveEvent(event);
	}
	
	public boolean deleteEventById(int id) {
		return eventDao.deleteEventById(id);
	}
	
	public Event updateEventById(int id, Event event, int sid) {
		Event e = eventDao.getEventById(id);
		Subscription s = subDao.getSubscriptionById(sid);
		e.setName(event.getName());
		e.setSubscription(s);
		return eventDao.updateEventById(e);
	}

	public Event getEventById(int id) {
		return  eventDao.getEventById(id);
	}
	
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}
	
}
