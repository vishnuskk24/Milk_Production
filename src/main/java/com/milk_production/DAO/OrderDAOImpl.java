package com.milk_production.DAO;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.milk_production.Entity.CustomerEntity;
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
		
															//		
															//		private Integer orderId;
															//		
															//		private String orderItemType;
															//		
															//		private Double orderItemPrice;
															//		private LocalDate orderedDate;
															//		
															//		private PaymentStatus paymentStatus; 
															//		private Integer quantity;
															//		
															//		private Double totalPrice;
		
		return null;
	}

}
