package com.milk_production.Service;

import com.milk_production.Model.Order;

public interface OrderService {

	Integer customerOrder(Integer customerId, Order orderDetails) throws Exception;

}
