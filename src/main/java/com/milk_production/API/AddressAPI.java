package com.milk_production.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.milk_production.Model.Address;
import com.milk_production.Model.MilkDetails;
import com.milk_production.Service.AddressService;
import com.milk_production.Service.CustomerService;
@RestController
@RequestMapping(value = "/address")
public class AddressAPI {
	@Autowired
	AddressService addressService;
	@Autowired
	Environment environment;
	
	
	@PutMapping("/updateaddress/{addressId}")
	public ResponseEntity<String> updateMilkPrice(@PathVariable Integer addressId ,@RequestBody Address addressDetails) throws Exception{
		try {
			String msg = 	addressService.updateAddress(addressId,addressDetails);
			
			return new ResponseEntity<String>(environment.getProperty(msg) + addressId ,HttpStatus.OK);
	
//		return null;
		}
		catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	
	@GetMapping("/{addressId}")
	public ResponseEntity<Address> updateMilkPrice(@PathVariable Integer addressId ) throws Exception{
		try {
			Address address = 	addressService.getAddressDetails(addressId);
			
			return new ResponseEntity<Address>(address,HttpStatus.OK);
	
//		return null;
		}
		catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
