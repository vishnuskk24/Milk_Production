package com.milk_production.Service;

import com.milk_production.Model.Customer;

public interface CustomerService {

	public Integer addCustomer(Customer customer)  throws Exception;
	public Customer getCustomerDetail(Integer CustomerId) throws Exception;
	public Customer getCustomerDetailByAadhaarNo(Long aadhaarNo) throws Exception;
	public Customer getCustomerDetailByPhoneNo(Long aadhaarNo) throws Exception;
	
}
