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
}
