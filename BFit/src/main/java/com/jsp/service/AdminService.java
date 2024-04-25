package com.jsp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.AdminDao;
import com.jsp.dao.BranchDao;
import com.jsp.dao.EventDao;
import com.jsp.dao.ManagerDao;
import com.jsp.dto.Admin;
import com.jsp.dto.Branch;
import com.jsp.dto.Event;
import com.jsp.dto.Manager;

@Component
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private EventDao eventDao;
	
	
	
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}
	
	public boolean deleteAdminById(int id) {
		return adminDao.deleteAdminById(id);
	}
	
	public Admin updateAdminById(int id, Admin admin) {
		Admin a = adminDao.getAdminById(id);
		a.setName(admin.getName());
		a.setEmail(admin.getEmail());
		return adminDao.updateAdminById(a);
	}

	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}
	
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}
	

	public boolean adminLogin(int id, Admin admin) {
		Admin a = adminDao.getAdminById(id);		
		if(a!=null && a.getUsername().equals(admin.getUsername()) 
				&& a.getPassword().equals(admin.getPassword())) {			
			a.setStatus("Logged-In");
			adminDao.adminLogin(a);
			System.out.println("Login Successful");
			return true;
		}
		else {
	        System.out.println("Invalid Login"); 
	    	return false;
		}	
	}
	
	public boolean approveManagerById(int mid, int aid) {
		Manager manager = managerDao.getManagerById(mid);
		Admin admin = adminDao.getAdminById(aid);

		if (manager != null && admin != null) {
			manager.setStatus("Authorized");
			manager.setAdmin(admin);
			manager.setApproval_Date(LocalDate.now());
			managerDao.approveManager(manager);
			return true;
		}
		return false;
	}
	
	public boolean rejectManagerById(int mid, int aid) {
		Manager manager = managerDao.getManagerById(mid);
		Admin admin = adminDao.getAdminById(aid);

		if (manager != null && admin != null) {
			manager.setStatus("Rejected");
			manager.setAdmin(admin);
			manager.setApproval_Date(LocalDate.now());
			managerDao.approveManager(manager);
			return true;
		}
		return false;
	}
	
	public boolean approveEventById(int eid, int aid) {
		Event event = eventDao.getEventById(eid);
		Admin admin = adminDao.getAdminById(aid);

		if (event != null && admin != null) {
			event.setStatus("Approved");
			event.setAdmin(admin);
			event.setApproval_Date(LocalDate.now());
			eventDao.approveEvent(event);
			return true;
		}
		return false;
	}
	
	
}
