package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.AdminDao;
import com.jsp.dao.BranchDao;
import com.jsp.dto.Admin;
import com.jsp.dto.Branch;

@Component
public class BranchService {

	
	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private AdminDao adminDao;
	
	public Branch saveBranch(Branch branch, int aid) {
		Admin admin = adminDao.getAdminById(aid);
		branch.setAdmin(admin);
		return branchDao.saveBranch(branch);
	}
	
	public boolean deleteBranchById(int id) {
		return branchDao.deleteBranchById(id);
	}
	
	public Branch updateBranchById(int id, Branch branch) {
		Branch b = branchDao.getBranchById(id);
		b.setLoc(branch.getLoc());
		b.setCno(branch.getCno());
		b.setCapacity(branch.getCapacity());
		return branchDao.updateBranchById(b);
	}

	public Branch getBranchById(int id) {
		return branchDao.getBranchById(id);
	}
	
	public List<Branch> getAllBranchs() {
		return branchDao.getAllBranchs();
	}
	
}
