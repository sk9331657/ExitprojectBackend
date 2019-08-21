package com.nagarro.exitproject.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nagarro.exitproject.models.Admins;
import com.nagarro.exitproject.models.Products;
import com.nagarro.exitproject.models.Sellers;

@Repository
@Transactional
public class SellersDaoImplementation implements SellersDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public Sellers login(String Email, String Password) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Sellers.class);
		cr.add(Restrictions.eq("Email", Email));
		cr.add(Restrictions.eq("Password", Password));
		Sellers seller = (Sellers)cr.uniqueResult();
		tx.commit();
		return seller;

	}

	@Override
	@Transactional
	public String register(String Email, String CompanyName, String Address, String GST, String Mobile, String Password,
			String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Sellers seller = new Sellers();
		seller.setUserName(userName);
		seller.setEmail(Email);
		seller.setAddress(Address);
		seller.setCompanyName(CompanyName);
		seller.setMobile(Mobile);
		seller.setStatus("NEW");
		seller.setPassword(Password);
		seller.setUserName(userName);
		session.save(seller);
		tx.commit();
		return "Created";
	}
	

	@Override
	@Transactional
	public String getsellers() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Sellers.class);
		List<Sellers> list = cr.list();
		tx.commit();
		return list.toString();
	}

	@Override
	public String searchsellers(String query, String options) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Sellers.class);

		// Filter by Name
		if(options.equals("1") ) {
			cr.add(Restrictions.like("CompanyName", query));
		}
		//Filter by Seller Product Code
		else if ( options.equals("2")){
			cr.add(Restrictions.eq("Username", query));	
		}
		//Filter By YourMart Code
		else {
			cr.add(Restrictions.eq("Mobile", query));				
		}	
		List<Products> list  = cr.list();
		tx.commit();
		return list.toString();
	}

	@Override
	public String filtersellers(String query, String options) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Sellers.class);
		cr.add(Restrictions.eq("Status", query));
		List<Sellers> list  = cr.list();
		tx.commit();
		return list.toString();
	}
	
	@Override
	public String sortsellers(String query, String options) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Sellers.class);
		cr.add(Restrictions.eq("Status", query));
		List<Sellers> list  = cr.list();
		tx.commit();
		return list.toString();
	}


	@Override
	public String getseller(String sellerid) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria cr = session.createCriteria(Sellers.class);
	    Sellers seller = (Sellers)cr.uniqueResult();
		tx.commit();
		return seller.toString();
	}




}