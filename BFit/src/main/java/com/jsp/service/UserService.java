package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.TimeslotDao;
import com.jsp.dao.UserDao;
import com.jsp.dto.Manager;
import com.jsp.dto.Timeslot;
import com.jsp.dto.User;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TimeslotDao timeslotDao;
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	public boolean deleteUserById(int id) {
		return userDao.deleteUserrById(id);
	}
	
	public User updateUserById(int id, User user) {
		User u = userDao.getUserById(id);
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		return userDao.updateUserById(u);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public boolean userLogin(int id, User user) {
		User u = userDao.getUserById(id);		
		if(u!=null && u.getUsername().equals(user.getUsername()) 
				&& u.getPassword().equals(user.getPassword())) {			
			u.setStatus("Logged-In");
			userDao.userLogin(u);
			System.out.println("Login Successful");
			return true;
		}
		else {
	        System.out.println("Invalid Login"); 
	    	return false;
		}	
	}
	
	public boolean buySubscription(User user, int uid) {
		User u = userDao.getUserById(uid);		
		System.out.println(u);
		if(u!=null) {			
			u.setStatus("Subscribed");
			userDao.userSubscription(u);
			System.out.println("Subscribed Successfully");
			return true;
		}
		else {
	        System.out.println("Not subscribed yet"); 
	    	return false;
		}	
	}

	public boolean bookEvent(int uid, User user) {
		User u = userDao.getUserById(uid);	
		if(u!=null && u.getStatus().equals("Subscribed")) {			
			System.out.println("Subscribed Successfully");
			return true;
		}
		else {
	        System.out.println("Not subscribed yet"); 
	    	return false;
		}	
	}
	
	public boolean bookTimeslot(int tid, int uid) {
		Timeslot t = timeslotDao.getTimeslotById(tid);
		User u = userDao.getUserById(uid);
		if(t!=null) {	
			t.setStatus("Booked");
			t.setUser(u);
			timeslotDao.bookTimeslot(t);
			return true;
		}
		else {
	    	return false;
		}	
	}
	
	public boolean cancelTimeslot(int tid, int uid) {
		Timeslot t = timeslotDao.getTimeslotById(tid);
		User u = userDao.getUserById(uid);
		if(t!=null) {	
			t.setStatus("Available");
			t.setUser(null);
			timeslotDao.bookTimeslot(t);
			return true;
		}
		else {
	    	return false;
		}	
	}
	
}
