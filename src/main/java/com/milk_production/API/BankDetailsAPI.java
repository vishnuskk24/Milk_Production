package com.milk_production.API;

import javax.print.DocFlavor.READER;

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

import com.milk_production.Model.BankDetails;
import com.milk_production.Service.BankDetailsService;

@RestController
@RequestMapping(value = "/bank")
public class BankDetailsAPI {
	@Autowired
	Environment environment;
	@Autowired
	private BankDetailsService bankDetailService;

	@GetMapping(value = "/{customerId}")
	public ResponseEntity<BankDetails> getBankDetails( @PathVariable Integer customerId) throws Exception{
		try {
			BankDetails bankDetails =bankDetailService.getBankDetails(customerId);
			return null;
		}catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
		@PutMapping(value = "/updateacno/")
		public ResponseEntity<String> updateAccountNoByBankId( @RequestBody BankDetails bankDetails) throws Exception{
			try {
				String msg =bankDetailService.updateAccountNoByBankId(bankDetails.getBankId(),bankDetails);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}catch(Exception e) {
				  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}
		}
		
		
		@PutMapping(value = "/updatebranchname/")
		public ResponseEntity<String> updateBranchNameByBankId( @RequestBody BankDetails bankDetails) throws Exception{
			try {
				String msg =bankDetailService.updateBranchNameByBankId(bankDetails.getBankId(),bankDetails);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			}catch(Exception e) {
				  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}	
		
	}
		@PutMapping(value = "/updateifsc/")
		public ResponseEntity<String> updateIfscCodeByBankId(@RequestBody BankDetails bankDetails) throws Exception{
			try {
				String msg =bankDetailService.updateIfscCodeByBankId(bankDetails.getBankId(),bankDetails);
				return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			}catch(Exception e) {
				  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
			}	
		
	}
}
