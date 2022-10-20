package com.milk_production.DAO;

import java.time.LocalDate;
import java.util.List;

import com.milk_production.Model.Customer;
import com.milk_production.Model.Order;

public interface OrderDAO {

	Integer addCustomerOrder(Integer customerId, Order orderDetails);

	Order getOrderDetailsByOrderId(Integer orderId);

	List<Customer> getTodayOrders(LocalDate todayDate);

	Customer getOrderByCustomerId(Integer customerId);

}
