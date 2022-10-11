package com.milk_production.API;

import java.util.List;

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
import com.milk_production.Model.MilkDetails;
import com.milk_production.Service.MilkProductionService;


@RestController
@RequestMapping(value = "/milk")
public class MilkProductionApI {

	@Autowired
	private MilkProductionService milkProductionService; 
	@Autowired
	Environment environment;
	
	@PostMapping("/insert/{ownerId}")
	public ResponseEntity<String> addMilkDetails(@PathVariable Integer ownerId ,@RequestBody MilkDetails milkDetails) throws Exception{
		try {
	Long resp =	milkProductionService.addMilkDetails(ownerId,milkDetails);
	String msg = "MILK_DETAILS_INSERT_SUCCESS";
	return new ResponseEntity<String>(environment.getProperty(msg) + " " +resp ,HttpStatus.CREATED);
	
//		return null;
		}
		catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	@GetMapping("/getmilkreport/{ownerId}")
	public ResponseEntity<List<MilkDetails>> getMilkDetails(@PathVariable Integer ownerId ) throws Exception{
		try {
	List<MilkDetails> resp =	milkProductionService.getMilkDetails(ownerId);
	
	return new ResponseEntity<List<MilkDetails>>(resp,HttpStatus.OK);
	
//		return null;
		}
		catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
	@PutMapping("/updatequantity/{milkid}")
	public ResponseEntity<String> updateMilkQuantity(@PathVariable Long milkid ,@RequestBody MilkDetails milkDetails) throws Exception{
		try {
			Double resp =	milkProductionService.updateMilkQuantity(milkid,milkDetails);
			String msg = "MILK_QUANTITY_UPDATE_SUCCESS";
			return new ResponseEntity<String>(environment.getProperty(msg) + " " +resp ,HttpStatus.OK);
	
//		return null;
		}
		catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	@PutMapping("/updateprice/{milkid}")
	public ResponseEntity<String> updateMilkPrice(@PathVariable Long milkid ,@RequestBody MilkDetails milkDetails) throws Exception{
		try {
			Double resp =	milkProductionService.updateMilkPrice(milkid,milkDetails);
			String msg = "MILK_PRICE_UPDATE_SUCCESS";
			return new ResponseEntity<String>(environment.getProperty(msg) + resp ,HttpStatus.OK);
	
//		return null;
		}
		catch(Exception e) {
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
}
