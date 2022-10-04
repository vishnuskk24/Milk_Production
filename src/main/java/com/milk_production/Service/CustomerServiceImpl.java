package com.milk_production.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milk_production.DAO.CustomerDAO;
import com.milk_production.Model.Customer;

@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	public Integer addCustomer(Customer registrationDetails) throws Exception{
		
		Customer customer = customerDAO.getCustomerByAadhaarNo(registrationDetails.getAadhaarNo());
		
		if(customer!=null) { 					// customer is already available
			
			throw new Exception("Service.CUSTOMER_ALREADY_EXIST");
		}else { 								// customer is not available
			
			Integer customerId =customerDAO.registerCustomer(customer);
			
			return customerId;
		}
		
		
	}
	@Override
	public Customer getCustomerDetail(Integer customerId) throws Exception{

		Customer customer = customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}
		
		return customer;
	}

	@Override
	public Customer getCustomerDetailByAadhaarNo(Long aadhaarNo) throws Exception{

		Integer customerId = customerDAO.getCustomerIdByAadhaarNo(aadhaarNo);
		
		Customer customer = customerDAO.getCustomerDetail(customerId);
		
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}
		return customer;
	}
	
}
