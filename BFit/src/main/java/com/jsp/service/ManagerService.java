package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.BranchDao;
import com.jsp.dao.ManagerDao;
import com.jsp.dao.UserDao;
import com.jsp.dto.Branch;
import com.jsp.dto.Manager;
import com.jsp.dto.User;

@Component
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BranchDao branchDao;
	
	public Manager saveManager(Manager manager, int bid) {
		manager.setStatus("Unauthorized");
		Branch branch = branchDao.getBranchById(bid);
		manager.setBranch(branch);
		return managerDao.saveManager(manager);
	}
	
	public boolean deleteManagerById(int id) {
		return managerDao.deleteManagerById(id);
	}
	
	public Manager updateManagerById(int id, Manager manager) {
		Manager m = managerDao.getManagerById(id);
		m.setName(manager.getName());
		m.setEmail(manager.getEmail());
		return managerDao.updateManagerById(m);
	}

	public Manager getManagerById(int id) {
		return managerDao.getManagerById(id);
	}
	
	public List<Manager> getAllManagers() {
		return managerDao.getAllManagers();
	}
	
	public boolean managerLogin(int id, Manager manager) {
		Manager m = managerDao.getManagerById(id);		
		if(m!=null && m.getUsername().equals(manager.getUsername()) 
				&& m.getPassword().equals(manager.getPassword())
				&& m.getStatus().equalsIgnoreCase("Authorized")) {		

			managerDao.managerLogin(m);
			System.out.println("Login Successful");
			return true;
		}
		else {
	        System.out.println("Invalid Login"); 
	    	return false;
		}	
	}
	
	
}
