package com.project.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.entities.Staff;
import com.project.demo.service.StaffService;


@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffService staffservice;
	
	@PostMapping("/addstaff")
	public String addStaff(@RequestBody Staff staff) {
		return staffservice.addStaff(staff);
	}
	
	@DeleteMapping("/deletestaff/{staff_id}")
	public String deleteStaff(@PathVariable int staff_id) {
		return staffservice.deleteStaff(staff_id);
	}
	
	@GetMapping("/getsinglestaff/{staff_id}")
	public Staff getsingleStaff(@PathVariable int staff_id) {
		return staffservice.getsingleStaff(staff_id);
	}
	
	@GetMapping("alldatastaff")
	public List<Staff> getallStaff() {
		return staffservice.getallStaff();
	}
	@PutMapping("/updatesubject")
	public Staff updateSubject(@RequestBody Staff staff) {
		return staffservice.updateStaff(staff);
	}
}
