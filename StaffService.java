package com.project.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.dao.StaffDAO;
import com.project.demo.entities.Staff;

@Service
public class StaffService {
	@Autowired
	StaffDAO staffDAO;
	
	public String addStaff(Staff staff) {
		return staffDAO.addstaff(staff);
	}
	
	public String deleteStaff(int staff_id) {
		return staffDAO.deletestaff(staff_id);
	}
	
	public Staff getsingleStaff(int staff_id) {
		return staffDAO.getsingledata(staff_id);
	}
	
	public List<Staff> getallStaff() {
		return staffDAO.getAllStaff();
	}
	public Staff updateStaff(Staff staff) {
		return staffDAO.updateStaff(staff);
	}

	
	

	
	 
}
