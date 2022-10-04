package com.milk_production.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milk_production.DAO.CustomerDAO;
import com.milk_production.Model.Customer;
import com.milk_production.Model.CustomerStatus;

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

		Customer customer = customerDAO.getCustomerByAadhaarNo(aadhaarNo);
		
//		Customer customer = customerDAO.getCustomerDetail(customerId);
		
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}
		return customer;
	}
	@Override
	public Customer getCustomerDetailByPhoneNo(Long aadhaarNo) throws Exception{

		Customer customer = customerDAO.getCustomerByPhoneNo(aadhaarNo);
		
//		Customer customer = customerDAO.getCustomerDetail(customerId);
		
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}
		return customer;
	}
	@Override
	public String updateCustomerNameById(Integer customerId, String customerName) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}else {
			Boolean resp = customerDAO.updateCustomerNameById( customerId,  customerName);
						
			String respMsg ="Service.CUSTOMERNAME_UPDATED_SUCCESFULLY";
			
			return respMsg;
				
			
		}
		
//		return null;
	}
	@Override
	public String updateCustomerAgeById(Integer customerId, Integer age) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}else {
			Boolean resp = customerDAO.updateCustomerAgeById( customerId,  age);
						
			String respMsg ="Service.CUSTOMERAGE_UPDATED_SUCCESFULLY";
			
			return respMsg;
				
			
		}
	}
	@Override
	public String updateCustomerPhoneNoById(Integer customerId, Long phoneNo) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}else {
			Boolean resp = customerDAO.updateCustomerPhoneNoById( customerId,  phoneNo);
						
			String respMsg ="Service.CUSTOMER_PHONE_NO_UPDATED_SUCCESFULLY";
			
			return respMsg;
				
			
		}
	}
	@Override
	public String updateCustomerAadhaarNoById(Integer customerId, Long aadhaarNo)throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}else {
			Boolean resp = customerDAO.updateCustomeraadhaarNoById( customerId, aadhaarNo);
						
			String respMsg ="Service.CUSTOMER_AADHAAR_NO_UPDATED_SUCCESFULLY";
			
			return respMsg;
				
			
		}
	}
	@Override
	public String deactivateCustomerByCustomerId(Integer customerId) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
		
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
					
		}else {
			if(customer.getStatus().equals(CustomerStatus.Deactivated)) {
				throw new Exception("Service.CUSTOMER_WAS_ALREADY_DEACTIVATED");
			}else {
			Boolean resp = customerDAO.deactivateCustomerByCustomerId( customerId);
						
			String respMsg ="Service.CUSTOMER_DEACTIVATED_SUCCESFULLY";
			
			return respMsg;
			}	
			
		}
	}
	
	
	}
