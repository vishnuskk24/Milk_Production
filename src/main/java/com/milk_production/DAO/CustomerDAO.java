package com.milk_production.DAO;

import com.milk_production.Model.Customer;

public interface CustomerDAO {

	public Customer getCustomerByAadhaarNo(Long aadhaarNo);
	public Integer registerCustomer(Customer customer);
	public Customer getCustomerDetail(Integer customerId);
//	public Integer getCustomerIdByAadhaarNo(Long aadhaarNo);
	public Customer getCustomerByPhoneNo(Long phoneNo);
	public Boolean updateCustomerNameById(Integer customerId, String customerName);
	public Boolean updateCustomerAgeById(Integer customerId, Integer age);
	public Boolean updateCustomerPhoneNoById(Integer customerId, Long phoneNo);
	public Boolean updateCustomeraadhaarNoById(Integer customerId, Long aadhaarNo);
	public Boolean deactivateCustomerByCustomerId(Integer customerId);
}
