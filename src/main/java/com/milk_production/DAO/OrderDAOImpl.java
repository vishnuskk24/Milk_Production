package com.milk_production.DAO;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.milk_production.Entity.CustomerEntity;
import com.milk_production.Entity.ItemDetailsEntity;
import com.milk_production.Entity.OrdersEntity;
import com.milk_production.Model.Order;
import com.milk_production.Model.PaymentStatus;

public class OrderDAOImpl  implements OrderDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Integer addCustomerOrder(Integer customerId, Order orderDetails) {
		// TODO Auto-generated method stub
		
		
		CustomerEntity ce   = entityManager.find(CustomerEntity.class , customerId);
		
		// adding order  to the customer list
		
			ItemDetailsEntity ide= entityManager.find(ItemDetailsEntity.class, orderDetails.getOrderItemType().toString());												//;
			
			OrdersEntity order = new OrdersEntity();
			order.setOrderItemPrice(ide.getItemPrice());
			order.setOrderItemType(orderDetails.getOrderItemType());
			order.setPaymentStatus(PaymentStatus.Pending);
			order.setQuantity(orderDetails.getQuantity());
			order.setTotalPrice(ide.getItemPrice() * orderDetails.getQuantity());
			order.setOrderedDate(LocalDate.now());
			ce.getOrderEntities().add(order);
			
			return ce.getOrderEntities().get(ce.getOrderEntities().size()-1).getOrderId();
			
	}

	@Override
	public Order getOrderDetailsByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
	
	
	
	
	
	
	

}
