package com.milk_production.DAO;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.milk_production.Entity.CustomerEntity;
import com.milk_production.Model.Customer;

@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Customer getCustomerByAadhaarNo(Long aadhaarNo) {
		
		String queryString  =  "select c from CustomerEntity c where c.aadhaarNo=?1";
		Query query  = entityManager.createQuery(queryString);
		query.setParameter(1, aadhaarNo);
		CustomerEntity customerEntity =  (CustomerEntity) query.getSingleResult();
		Customer customer = null;
		if(customerEntity!=null) {
			customer = new Customer();
			customer.setAadhaarNo(customerEntity.getAadhaarNo());
			customer.setAge(customerEntity.getAge());
			customer.setCustmerId(customerEntity.getCustmerId());
			customer.setCustomerName(customerEntity.getCustomerName());
			customer.setDateOfJoined(customerEntity.getDateOfJoined());
			customer.setGender(customerEntity.getGender());
			
		}
		
		
		// TODO Auto-generated method stub
		return customer;
	}
	@Override
	public Integer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		CustomerEntity customerEntity = new CustomerEntity();	 //setting customer values from model to entity
		customerEntity.setAadhaarNo(customer.getAadhaarNo());
		customerEntity.setAge(customer.getAge());
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setDateOfJoined(LocalDate.now());
		customerEntity.setGender(customer.getGender());
		customerEntity.setPhoneNo(customer.getPhoneNo());
		
		
		return null;
	}
	

}
