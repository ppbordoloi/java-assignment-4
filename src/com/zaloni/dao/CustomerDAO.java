package com.zaloni.dao;

import java.util.List;

import com.zaloni.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomerById(int theId);
}
