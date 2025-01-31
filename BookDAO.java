package com.project.demo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.demo.entities.Book;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Repository
public class BookDAO {
	@Autowired
	SessionFactory sf;
	
	public String addBook(Book b) {
		Session session=null;
		Transaction transaction=null;
		String msg=null;
		try {
			session=sf.openSession();
			transaction=session.beginTransaction();
			session.save(b);
			transaction.commit();
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
			return  msg="Data inserted successfully";
		}
	
		public String deletebook(int id) {
			Session session=null;
			Transaction transaction=null;
			String msg=null;
			try {
				session=sf.openSession();
				transaction=session.beginTransaction();
				Book book=session.get(Book.class, id);
				 if(book!= null) {
			       session.remove(book); 
			       transaction.commit();
			       msg = "data deleted successfully"; 
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
		
		public Book getsingledata(int id) {
			Session session=null;
			Transaction transaction=null;
			Book book=null;
			
			try {
				session=sf.openSession();
				transaction=session.beginTransaction();
				book=session.get(Book.class, id);
				if(book == null) {
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
			  return book;
		}
		
		public String updatedata(Book book,int id) {
			Session session=null;
			Transaction transaction=null;
			String msg=null;
			try {
				session=sf.openSession();
				transaction=session.beginTransaction();
				Book newbook=session.get(Book.class, id);
				newbook.setId(book.getId());;
				newbook.setTitle(book.getTitle());
				newbook.setAuthor(book.getAuthor());
				newbook.setPublishedYear(book.getPublishedYear());
				newbook.setLanguage(book.getLanguage());
				newbook.setAvailableQuantity(book.getAvailableQuantity());
				 if (book!= null) {
			            session.update(newbook); 
			            transaction.commit();
			            msg = "data updated successfully"; 
			        } else {
			            msg = "data not found"; 
			        }
			     }catch(Exception e) {
			    	 if(transaction!=null) {
			    		 transaction.commit();
			    	 }
			    	 e.printStackTrace();
			     }finally{
			    	 if(session!=null) {
			    		 session.close();
			    	 }
			     }
			return msg="data updated successfully..";
		}
		
		public List<Book> getalldata() {
			Session session = null;
			Transaction transaction=null;
			List<Book> list = null;
			try {
				session = sf.openSession();
				 CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		         CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
		         criteriaQuery.from(Book.class); 
		         Query<Book> query = session.createQuery(criteriaQuery);
		         list = query.getResultList(); 
			} catch (Exception e) {
				if(transaction!=null) {
					transaction.commit();
				}
				e.printStackTrace();
			} finally {
				
				if(session!=null) {
				session.close();
			}
			}
			return list;
		}
}
	
