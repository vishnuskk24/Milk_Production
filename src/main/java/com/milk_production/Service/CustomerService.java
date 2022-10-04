package com.milk_production.Service;

import com.milk_production.Model.Customer;

public interface CustomerService {

	public Integer addCustomer(Customer customer)  throws Exception;
	public Customer getCustomerDetail(Integer CustomerId) throws Exception;
	public Customer getCustomerDetailByAadhaarNo(Long aadhaarNo) throws Exception;
	public Customer getCustomerDetailByPhoneNo(Long aadhaarNo) throws Exception;
	public String updateCustomerNameById(Integer customerId, String customerName) throws Exception;
	public String updateCustomerAgeById(Integer customerId, Integer age) throws Exception;
	public String updateCustomerPhoneNoById(Integer customerId, Long phoneNo) throws Exception;
	public String updateCustomerAadhaarNoById(Integer customerId, Long aadhaarNo) throws Exception;
	public String deactivateCustomerByCustomerId(Integer customerId) throws Exception;
	
}
