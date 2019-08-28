package com.zaloni.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaloni.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomer() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery =currentSession.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> theCustomer = theQuery.getResultList();
		return theCustomer;
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theCustomer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, theId);
		return customer;
	}

}
