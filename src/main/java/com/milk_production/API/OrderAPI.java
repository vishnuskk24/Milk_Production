package com.milk_production.API;


import java.time.LocalDate;
import java.util.List;

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

import com.milk_production.Model.Customer;
import com.milk_production.Model.ItemType;
import com.milk_production.Model.MilkDetails;
import com.milk_production.Model.Order;
import com.milk_production.Model.PaymentStatus;
import com.milk_production.Service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderAPI {
	
	@Autowired
	Environment environment;
	@Autowired
	OrderService orderService;
	
	@PutMapping("/order/{customerId}")
	public ResponseEntity<String> customerOrder(@PathVariable Integer customerId,@RequestBody Order orderDetails) throws Exception{
		try {
			Integer orderId = orderService.customerOrder(customerId,orderDetails);
			String msg = "API.ORDER_SUCCESSFULLY_DONE";
			
			return new ResponseEntity<String>(environment.getProperty(msg) + " " + orderId, HttpStatus.CREATED);
			
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
	
			
	
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getOrdersByCustomerId(@PathVariable Integer customerId) throws Exception{
		try {
			Customer customerOrders = orderService.getOrdersByCustomerId(customerId);
			
			
			return new ResponseEntity<Customer>(customerOrders, HttpStatus.OK);
			
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
	
			
	
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> getOrdersByOrderId(@PathVariable Integer orderId) throws Exception{
		try {
			Order customerOrderDetails = orderService.getOrdersByOrderId(orderId);
			
			
			return new ResponseEntity<Order>(customerOrderDetails, HttpStatus.OK);
			
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
	
			
	
	}
	@GetMapping("/todayorder/")
	public ResponseEntity<List<Customer>> getTodayOrder() throws Exception{
		try {
			List<Customer> todayOrder = orderService.getTodayOrder();
			
			
			return new ResponseEntity<List<Customer>>(todayOrder, HttpStatus.OK);
			
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
	}

//	@GetMapping("/getmyorders/{customerId}")
//	public ResponseEntity<Customer> getMyOrder(@PathVariable Integer customerId) throws Exception{
//		try {
//			Customer todayOrder = orderService.getMyOrder(customerId);
//			
//			
//			return new ResponseEntity<Customer>(todayOrder, HttpStatus.OK);
//			
//			
//		}catch(Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
//		}
//	
//	}
	@GetMapping("/getmy monthlyorder/{customerId}/{month}")
	public ResponseEntity<Customer> getThisMonthOrder(@PathVariable Integer customerId,@PathVariable Integer month) throws Exception{
		try {
			Customer monthlyOrder = orderService.getMonthlyOrder(customerId,month);
			
			
			return new ResponseEntity<Customer>(monthlyOrder, HttpStatus.OK);
			
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
	
	}
	
																								//	private Integer orderId;
	@PutMapping("/update/quantity")
	public ResponseEntity<String> updateOrderQuantity(@RequestBody Order orderDetails) throws Exception{
		
		try {
			
		}catch(Exception e) {
			String updateOrderResp = orderService.updateOrderQuantity(orderDetails);
			
		}
		return null;
	}
	@GetMapping("/getpendingorder/{customerId}")
	public ResponseEntity<Customer> getCustomerPendingOrders(@PathVariable Integer customerId){
		try {
			Customer customerOrders = orderService.getCustomerPendingOrders(customerId);
			
			
			return new ResponseEntity<Customer>(customerOrders, HttpStatus.OK);
			
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
		}
		
	}
																								//	private ItemType orderItemType;
																								//	
																	 							//	private Double orderItemPrice;
																								//	private LocalDate orderedDate;
																								//	
																								//	private PaymentStatus paymentStatus; 
																								//	private Integer quantity;
																								//	
																								//	private Double totalPrice;
}


