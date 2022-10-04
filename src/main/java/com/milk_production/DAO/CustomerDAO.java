package com.milk_production.DAO;

import com.milk_production.Model.Customer;

public interface CustomerDAO {

	public Customer getCustomerByAadhaarNo(Long aadhaarNo);
	public Integer registerCustomer(Customer customer);
	public Customer getCustomerDetail(Integer customerId);
//	public Integer getCustomerIdByAadhaarNo(Long aadhaarNo);
	public Customer getCustomerByPhoneNo(Long phoneNo);
}
