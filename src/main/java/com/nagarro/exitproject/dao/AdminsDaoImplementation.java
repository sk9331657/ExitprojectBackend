package com.nagarro.exitproject.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nagarro.exitproject.models.Admins;
import com.nagarro.exitproject.models.Sellers;

@Repository
public class  AdminsDaoImplementation implements AdminsDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public Admins getUserDetails(String username) {
		Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();  
		Admins user = (Admins) session.load(Admins.class, username);
		tx.commit();
		return user;
	}
	
	@Override
	@Transactional
	public Boolean userAuthentication(String username, String password) {

               Session session = this.sessionFactory.getCurrentSession();
               Transaction tx = session.beginTransaction();  

               try {
            	    Admins user = (Admins) session.get(Admins.class, username);
            	   tx.commit();
                   if (user.getName() != null && user.getPassword().equals(password))
                	   return true;
                   else
                	   return false;
                   
            	   
               }
               catch(Exception e) {
            	   return false;
               }
               
    }


}
