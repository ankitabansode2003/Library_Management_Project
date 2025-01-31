package com.project.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.demo.entities.Book;
import com.project.demo.entities.Staff;



@Repository
public class StaffDAO {
	@Autowired
	SessionFactory sessionfactory;
	
	public String addstaff(Staff staff) {
		Session session=null;
		Transaction transaction=null;
		String message=null;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
				session.save(staff);
				transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return  message="Staff Data Inserted successfully";
	}
	
	public String deletestaff(int staff_id) {
		Session session=null;
		Transaction transaction=null;
		String msg=null;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Staff staff=session.get(Staff.class, staff_id);
			 if(staff!= null) {
		       session.remove(staff); 
		       transaction.commit();
		       msg = "deleted successfully"; 
			 }
			 else {
		            msg = "data not found"; 
		           }
			
		     }catch(Exception e) {
			    if(transaction!=null) {
				transaction.rollback();
			    }
			    e.printStackTrace();
		     }
			finally {
				if(session!=null) {
					session.close();
				}
			}
		return  msg="Data deleted successfully";
	}
	
	public Staff getsingledata(int staff_id) {
		Session session=null;
		Transaction transaction=null;
		Staff staff=null;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			staff=session.get(Staff.class, staff_id);
			if(staff == null) {
				System.out.println("data not found with id " + staff_id);
			}else {
				System.out.println("data fetched successfully.");
			}
		 }catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		 }
		 finally {
			if(session!=null) {
				session.close();
			}
		}
		  return staff;
	}
	
	public List<Staff> getAllStaff() {
		Session session = null;
		List<Staff> list = null;
		try {
			session = sessionfactory.openSession();
			String hql = "FROM Staff"; 
	        Query<Staff> query = session.createQuery(hql, Staff.class);
	        list = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
		
	public  Staff updateStaff(Staff staff) {
		Session session = null;
		Staff newstaff = null;
		
		try {
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(staff);
			transaction.commit();
			newstaff = staff;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newstaff;
	}	 	
}
