package com.milk_production.Service;

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
	

}
