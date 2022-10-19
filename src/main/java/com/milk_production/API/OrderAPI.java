package com.milk_production.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milk_production.Model.MilkDetails;
import com.milk_production.Model.Order;
import com.milk_production.Service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderAPI {
	
	
	@Autowired
	OrderService orderService;
	
	@PutMapping("/order/{customerId}")
	public ResponseEntity<String> customerOrder(@PathVariable Integer customerId,@RequestBody Order orderDetails) throws Exception{
		try {
			Integer orderId = orderService.customerOrder(customerId,orderDetails);
			
			
			
		}catch(Exception e) {
			
		}
		return null;
	
			
	
	}

	
}
