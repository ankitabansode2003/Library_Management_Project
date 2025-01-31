package com.project.demo.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.demo.entities.Fine;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



@Repository
public class FineDAO {
	@Autowired
	SessionFactory sf;
	
	public String addfine(Fine fine) {
		Session session=null;
		String message=null;
		try {
			session=sf.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(fine);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		} 
		return message="data inserted successfully";
	}
	
	public Fine updateFine(Fine fine) {
		Session session = null;
		Fine newfine = null;
		
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(fine);
			transaction.commit();
			newfine = fine;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newfine;
	}
	
	public String deleteFine(int id) {
		Session session = null;
		Transaction tr=null;
		String msg = null;
		try {
				session=sf.openSession();
				tr=session.beginTransaction();
				Fine fine = session.get(Fine.class, id);
				if(fine!= null) {
			   session.remove(fine); 
			   tr.commit();
			   msg = "data deleted successfully"; 
				 }
			else {
			      msg = "data not found"; 
			     }

				} catch (Exception e) {
				if(tr!=null) {
					tr.rollback();
				}
			  e.printStackTrace();
				} finally {
					session.close();
				}
				return msg;
			}
	
	public List<Fine> getAllFine() {
		Session session = null;
		Transaction tr=null;
		List<Fine> list = null;
		try {
			session = sf.openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Fine> criteriaQuery = criteriaBuilder.createQuery(Fine.class);
			Root<Fine> root = criteriaQuery.from(Fine.class);
			criteriaQuery.select(root);
			 Query<Fine> query = session.createQuery(criteriaQuery);
	         list = query.getResultList();
	         tr.commit();
		}catch(Exception e) {
			if(tr!=null) {
				tr.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
}
	
	public Fine getSingleFine(int id) {
		Session session=null;
		Transaction transaction=null;
		Fine fine=null;
		
		try {
			session=sf.openSession();
			transaction=session.beginTransaction();
			fine=session.get(Fine.class, id);
			if(fine == null) {
				System.out.println("data not found with id " + id);
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
		return fine;
	}
}

