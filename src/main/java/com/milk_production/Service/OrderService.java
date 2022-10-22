package com.milk_production.Service;

import java.util.List;

import com.milk_production.Model.Customer;
import com.milk_production.Model.Order;

public interface OrderService {

	Integer customerOrder(Integer customerId, Order orderDetails) throws Exception;

	Customer getOrdersByCustomerId(Integer customerId) throws Exception;

	Order getOrdersByOrderId(Integer orderId) throws Exception;

	List<Customer> getTodayOrder() throws Exception;


	Customer getMonthlyOrder(Integer customerId, Integer month) throws Exception;

	String updateOrderQuantity(Order orderDetails) throws Exception;

	Customer getCustomerPendingOrders(Integer customerId) throws Exception;
}
