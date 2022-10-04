package com.milk_production.API;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.milk_production.Model.Customer;
import com.milk_production.Service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerAPI {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	Environment enviroment;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> addCustomer(@RequestBody Customer registrationDetails) throws Exception{
		try {
			Integer customerId = customerService.addCustomer(registrationDetails);
			
			String msg  = registrationDetails.getCustomerName() + enviroment.getProperty("REGISTRATION_SUCCESS")+customerId;
			
			
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
			
		}catch(Exception e) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			
		}
			
		}
	@GetMapping(value = "/getcustomerdetail/aadharno")
	public ResponseEntity<Customer> getCustomerDetailsByAadharNo(@RequestBody Customer customer) throws Exception{
		try {
			
			Customer customerDetail = customerService.getCustomerDetailByAadhaarNo(customer.getAadhaarNo());
			
			return new ResponseEntity<Customer>(customerDetail,HttpStatus.OK);
			
		}catch(Exception e) {
		
		
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
	
	}
	@GetMapping(value = "/getcustomerdetail/phoneno")
	public ResponseEntity<Customer> getCustomerDetailsByPhoneNo(@RequestBody Customer customer) throws Exception{
	try {
			
			Customer customerDetail = customerService.getCustomerDetailByPhoneNo(customer.getPhoneNo());
			
			return new ResponseEntity<Customer>(customerDetail,HttpStatus.OK);
		}catch(Exception e) {
		
		
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
			
	}
							// getting 
		@GetMapping(value = "/getcustomerdetail/id")
		public ResponseEntity<Customer> getCustomerDetailsByCustomerId(@RequestBody Customer customer) throws Exception{
			try {
				
				Customer customerDetail = customerService.getCustomerDetail(customer.getCustmerId());
				
				return new ResponseEntity<Customer>(customerDetail,HttpStatus.OK);
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
			
			
		}
		

}
