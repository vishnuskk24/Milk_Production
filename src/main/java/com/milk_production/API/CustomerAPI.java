package com.milk_production.API;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
			
		}																// getting  detail by providing aadhaar number
	@GetMapping(value = "/getcustomerdetail/aadharno")
	public ResponseEntity<Customer> getCustomerDetailsByAadharNo(@RequestBody Customer customer) throws Exception{
		try {
			
			Customer customerDetail = customerService.getCustomerDetailByAadhaarNo(customer.getAadhaarNo());
			
			return new ResponseEntity<Customer>(customerDetail,HttpStatus.OK);
			
		}catch(Exception e) {
		
		
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
	
	}																// getting  detail by providing Phone number
	@GetMapping(value = "/getcustomerdetail/phoneno")
	public ResponseEntity<Customer> getCustomerDetailsByPhoneNo(@RequestBody Customer customer) throws Exception{
	try {
			
			Customer customerDetail = customerService.getCustomerDetailByPhoneNo(customer.getPhoneNo());
			
			return new ResponseEntity<Customer>(customerDetail,HttpStatus.OK);
		}catch(Exception e) {
		
		
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
	}
			
	}
							// getting  detail by providing customer id 
		@GetMapping(value = "/getcustomerdetail/id")
		public ResponseEntity<Customer> getCustomerDetailsByCustomerId(@RequestBody Customer customer) throws Exception{
			try {
				
				Customer customerDetail = customerService.getCustomerDetail(customer.getCustmerId());
				
				return new ResponseEntity<Customer>(customerDetail,HttpStatus.OK);
				 
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
		}
			
			
		}
		

		
		
		@PutMapping(value = "/update/customername/{customerId}")
		public ResponseEntity<String> updateCustomerNameByCustomerId(@PathVariable Integer customerId , @RequestBody Customer customer) throws Exception{
			try {
				
				String Msg = customerService.updateCustomerNameById(customerId , customer.getCustomerName());
				
				return new ResponseEntity<String>(enviroment.getProperty(Msg),HttpStatus.OK);
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
		}
			
			
		}
		
		
		
		@PutMapping(value = "/update/age/{customerId}")
		public ResponseEntity<String> updateAgeByCustomerId(@PathVariable Integer customerId , @RequestBody Customer customer) throws Exception{
			try {
				
				String Msg = customerService.updateCustomerAgeById(customerId , customer.getAge());
				
				return new ResponseEntity<String>(enviroment.getProperty(Msg),HttpStatus.OK);
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
		}
			
			
		}
		
		
		@PutMapping(value = "/update/phoneno/{customerId}")
		public ResponseEntity<String> updatePhoneNoByCustomerId(@PathVariable Integer customerId , @RequestBody Customer customer) throws Exception{
			try {
				
				String Msg = customerService.updateCustomerPhoneNoById(customerId , customer.getPhoneNo());
				
				return new ResponseEntity<String>(enviroment.getProperty(Msg),HttpStatus.OK);
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
		}
			
		
		}

		
		@PutMapping(value = "/update/aadhaarno/{customerId}")
		public ResponseEntity<String> updateAadhaarNoByCustomerId(@PathVariable Integer customerId , @RequestBody Customer customer) throws Exception{
			try {
				
				String Msg = customerService.updateCustomerAadhaarNoById(customerId , customer.getAadhaarNo());
				
				return new ResponseEntity<String>(enviroment.getProperty(Msg),HttpStatus.OK);
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
		}
			
		
		}
		@PutMapping(value = "/update/customerstatus/{customerId}")
		public ResponseEntity<String> deactivateCustomerByCustomerId(@PathVariable Integer customerId ) throws Exception{
			try {
				
				String Msg = customerService.deactivateCustomerByCustomerId(customerId);
				
				return new ResponseEntity<String>(enviroment.getProperty(Msg),HttpStatus.OK);
			}catch(Exception e) {
			
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
		}
			
		
		}
		
}
