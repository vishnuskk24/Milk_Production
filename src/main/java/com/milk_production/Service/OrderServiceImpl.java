package com.milk_production.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milk_production.DAO.CustomerDAO;
import com.milk_production.DAO.OrderDAO;
import com.milk_production.Model.Customer;
import com.milk_production.Model.Order;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	CustomerDAO customerDAO;
	@Autowired
	OrderDAO orderDAO;

	@Override
	public Integer customerOrder(Integer customerId, Order orderDetails) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer =customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
		}else {
			if(orderDetails==null) {
				throw new Exception("Service.ORDER_DETAILS_NOT_AVAILABLE");
			}
			Integer orderId = orderDAO.addCustomerOrder(customerId,orderDetails);
			return orderId;
		}
		
		
	}

	@Override
	public Customer getOrdersByCustomerId(Integer customerId) throws Exception {
		Customer customer =orderDAO.getOrderByCustomerId(customerId);
		if(customer==null) {
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
		}else if(customer.getOrders().size()==0) {
			throw new Exception("Service.CUSTOMER_HAVE_NO_ORDERS");
			
		}else {
			
 			
			return customer;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrdersByOrderId(Integer orderId) throws Exception {
		// TODO Auto-generated method stub
		Order orderDetails = orderDAO.getOrderDetailsByOrderId(orderId);
		if(orderDetails==null ) {
			throw new Exception("Service.ORDER_NOT_AVAILABLE");

		}
		return orderDetails;
	}

	@Override
	public List<Customer> getTodayOrder() throws Exception {
		// TODO Auto-generated method stub
		LocalDate todayDate =  LocalDate.now();
		List<Customer> customers = orderDAO.getTodayOrders(todayDate);
		if(customers.size()==0) {
			throw new Exception("Service.TODAY_ORDER_NOT_FOUND");
		}
		
		return customers;
	}

	@Override
	public Customer getMonthlyOrder(Integer customerId, Integer month) throws Exception{
		
		
		LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), month, 1);
		LocalDate currentDate = LocalDate.now();
		LocalDate lastDate  = startDate.withDayOfMonth(startDate.getMonth().length(startDate.isLeapYear()));
		
		Customer cust =customerDAO.getCustomerDetail(customerId);
		if(cust==null) {
			throw new Exception("Service.CUSTOMER_NOT_AVAILABLE");
		}else {
			Customer customer = orderDAO.getMonthlyOrder( customerId, startDate,lastDate);
			if(customer.getOrders().size()==0) {
				throw new Exception("Service.ORDER_NOT_AVAILABLE");
			}
			return customer;
		}
		// TODO Auto-generated method stub
		
	}
	
	
	

}
