package com.milk_production.DAO;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.milk_production.Entity.AddressEntity;
import com.milk_production.Entity.BankDetailsEntity;
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
//		adding customer with address and bank detils
		
		
		CustomerEntity customerEntity = new CustomerEntity();	 //setting customer values from model to entity
		customerEntity.setAadhaarNo(customer.getAadhaarNo());
		customerEntity.setAge(customer.getAge());
		customerEntity.setCustomerName(customer.getCustomerName());
		customerEntity.setDateOfJoined(LocalDate.now());
		customerEntity.setGender(customer.getGender());
		customerEntity.setPhoneNo(customer.getPhoneNo());
		
//		setting  bank details
		
		BankDetailsEntity bankDetailsEntity = new BankDetailsEntity();
		bankDetailsEntity.setAccountNo(customer.getBankDetails().getAccountNo());
		bankDetailsEntity.setBankName(customer.getBankDetails().getBankName());
		bankDetailsEntity.setBranchName(customer.getBankDetails().getBranchName());
		bankDetailsEntity.setIfscCode(customer.getBankDetails().getIfscCode());
		
//		 setting address details
		AddressEntity addressEntity  = new AddressEntity();
		addressEntity.setDistrict(customer.getAddress().getDistrict());
		addressEntity.setHouseNo(customer.getAddress().getHouseNo());
		addressEntity.setPinCode(customer.getAddress().getPinCode());
		addressEntity.setPlace(customer.getAddress().getPlace());
		addressEntity.setStreetName(customer.getAddress().getStreetName());
		addressEntity.setTaluk(customer.getAddress().getTaluk());
		
//		 settign address detail to customer Entity
		customerEntity.setAddressEntity(addressEntity);
		
//		setting bank details to customerEntity object
		customerEntity.setBankDetailsEntity(bankDetailsEntity);
//		adding the all values to databases
		entityManager.persist(customerEntity);
		
		return customerEntity.getCustmerId();
	}
	@Override
	public Customer getCustomerDetail(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getCustomerIdByAadhaarNo(Long aadhaarNo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
