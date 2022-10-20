package com.milk_production.DAO;

import com.milk_production.Model.Order;

public interface OrderDAO {

	Integer addCustomerOrder(Integer customerId, Order orderDetails);

	Order getOrderDetailsByOrderId(Integer orderId);

}
