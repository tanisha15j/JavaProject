package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.TimeslotDao;
import com.jsp.dao.EventDao;
import com.jsp.dto.Timeslot;
import com.jsp.dto.Event;

@Component
public class TimeslotService {
	
	@Autowired
	private TimeslotDao timeslotDao;
	
	@Autowired
	private EventDao eventDao;
	
	public Timeslot saveTimeslot(Timeslot timeslot, int eid) {
		timeslot.setStatus("Available");
		Event event = eventDao.getEventById(eid);
		timeslot.setEvent(event);
		return timeslotDao.saveTimeslot(timeslot);
	}
	
	public boolean deleteTimeslotById(int id) {
		return timeslotDao.deleteTimeslotById(id);
	}
	
	public Timeslot updateTimeslotById(int id, Timeslot timeslot) {
		Timeslot t = timeslotDao.getTimeslotById(id);
		t.setTime_slot(timeslot.getTime_slot());
		return timeslotDao.updateTimeslotById(t);
	}

	public Timeslot getTimeslotById(int id) {
		return  timeslotDao.getTimeslotById(id);
	}
	
	public List<Timeslot> getAllTimeslots() {
		return timeslotDao.getAllTimeslots();
	}

	
	
}
