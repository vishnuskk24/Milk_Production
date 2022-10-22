package com.milk_production.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.milk_production.Entity.CustomerEntity;
import com.milk_production.Entity.ItemDetailsEntity;
import com.milk_production.Entity.OrdersEntity;
import com.milk_production.Model.Customer;
import com.milk_production.Model.Order;
import com.milk_production.Model.PaymentStatus;

@Repository(value = "orderDAO")
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
		OrdersEntity orderEntity   = entityManager.find(OrdersEntity.class , orderId);
		Order order  =null;
		if(order==null) {
			order = new Order();
		order.setOrderedDate(orderEntity.getOrderedDate());
		order.setOrderId(orderId);
		order.setOrderItemPrice(orderEntity.getOrderItemPrice());
		order.setOrderItemType(orderEntity.getOrderItemType());
		order.setPaymentStatus(orderEntity.getPaymentStatus());
		order.setQuantity(orderEntity.getQuantity());
		order.setTotalPrice(orderEntity.getTotalPrice());

		}
		return order;
	}

	@Override
	public List<Customer> getTodayOrders(LocalDate todayDate) {
		// TODO Auto-generated method stub
//		List<CustomerEntity> customerEntities = new ArrayList<>();
		 List<Customer> customers = new ArrayList<>(); 
		
		String queryString ="select c from CustomerEntity c where c.orderEntities.orderedDate = ?1";
		Query query = entityManager.createQuery(queryString);
		
		List<CustomerEntity>  customerEntities = query.getResultList();
		if(customerEntities!=null) {
			for(CustomerEntity customerEntity:customerEntities ) {
				Customer customer = new Customer();
				customer.setAadhaarNo(customerEntity.getAadhaarNo());
				customer.setAge(customerEntity.getAge());
				customer.setCustmerId(customerEntity.getCustmerId());
				customer.setCustomerName(customerEntity.getCustomerName());
				customer.setDateOfJoined(customerEntity.getDateOfJoined());
				customer.setGender(customerEntity.getGender());
				customer.setStatus(customerEntity.getStatus());
				List<OrdersEntity> customerOrders = customerEntity.getOrderEntities();
				List<Order> orders = new ArrayList<>();
				
					for(OrdersEntity customerOrder : customerOrders) {
						
						Order order = new Order();
						order.setOrderedDate(customerOrder.getOrderedDate());
						order.setOrderId(customerOrder.getOrderId());
						order.setOrderItemPrice(customerOrder.getOrderItemPrice());
						order.setOrderItemType(customerOrder.getOrderItemType());
						order.setPaymentStatus(customerOrder.getPaymentStatus());
						order.setQuantity(customerOrder.getQuantity());
						order.setTotalPrice(customerOrder.getTotalPrice());
						orders.add(order);
					}
					customer.setOrders(orders);
			customers.add(customer);
					
			}
		}
		return customers;
	}

	@Override
	public Customer getOrderByCustomerId(Integer customerId) {
		
		// TODO Auto-generated method stub
		CustomerEntity customerEntity   = entityManager.find(CustomerEntity.class , customerId);
		Customer customer =null;
		
		if(customerEntity!=null) {
			customer = new Customer();
			customer.setAadhaarNo(customerEntity.getAadhaarNo());
			customer.setAge(customerEntity.getAge());
			customer.setCustmerId(customerEntity.getCustmerId());
			customer.setCustomerName(customerEntity.getCustomerName());
			customer.setDateOfJoined(customerEntity.getDateOfJoined());
			customer.setGender(customerEntity.getGender());
			customer.setStatus(customerEntity.getStatus());
			List<OrdersEntity> customerOrders = customerEntity.getOrderEntities();
			List<Order> orders = new ArrayList<>();
			
				for(OrdersEntity customerOrder : customerOrders) {
					
					Order order = new Order();
					order.setOrderedDate(customerOrder.getOrderedDate());
					order.setOrderId(customerOrder.getOrderId());
					order.setOrderItemPrice(customerOrder.getOrderItemPrice());
					order.setOrderItemType(customerOrder.getOrderItemType());
					order.setPaymentStatus(customerOrder.getPaymentStatus());
					order.setQuantity(customerOrder.getQuantity());
					order.setTotalPrice(customerOrder.getTotalPrice());
					orders.add(order);
				}
				customer.setOrders(orders);
		}
		return customer;
	}

	@Override
	public Customer getMonthlyOrder(Integer customerId, LocalDate startDate, LocalDate lastDate) { /// face any issue in query the we resolve in java function usng localdate isBefore and isAfter
		// TODO Auto-generated method stub
//		SELECT e FROM Employee e WHERE e.salary BETWEEN 2000L AND 4000L order by e.salary");
		String queryString ="select c from CustomerEntity c where c.customerId =?1 AND c.orderEntities.orderedDate BETWEEN  ?2 AND ?3 ";
		Query query = entityManager.createQuery(queryString);
		
		List<CustomerEntity>  customerEntities = query.getResultList();
		if(customerEntities.size()!=0) {
			CustomerEntity customerEntity = customerEntities.get(0);
				if(customerEntity!=null) {
					Customer customer = new Customer();
						customer.setAadhaarNo(customerEntity.getAadhaarNo());
						customer.setAge(customerEntity.getAge());
						customer.setCustmerId(customerEntity.getCustmerId());
						customer.setCustomerName(customerEntity.getCustomerName());
						customer.setDateOfJoined(customerEntity.getDateOfJoined());
						customer.setGender(customerEntity.getGender());
						customer.setStatus(customerEntity.getStatus());
						List<OrdersEntity> customerOrders = customerEntity.getOrderEntities();
						List<Order> orders = new ArrayList<>();
						
							for(OrdersEntity customerOrder : customerOrders) {
								
								Order order = new Order();
								order.setOrderedDate(customerOrder.getOrderedDate());
								order.setOrderId(customerOrder.getOrderId());
								order.setOrderItemPrice(customerOrder.getOrderItemPrice());
								order.setOrderItemType(customerOrder.getOrderItemType());
								order.setPaymentStatus(customerOrder.getPaymentStatus());
								order.setQuantity(customerOrder.getQuantity());
								order.setTotalPrice(customerOrder.getTotalPrice());
								orders.add(order);
							}
							customer.setOrders(orders);
					
					return customer;
				}
				
			}
		return null;
	}

	@Override
	public void updateOrderQuantity(Order orderDetails) {
		// TODO Auto-generated method stub
		
		
		OrdersEntity orderEntity   = entityManager.find(OrdersEntity.class , orderDetails.getOrderId());
		orderEntity.setQuantity(orderDetails.getQuantity());
		orderEntity.setTotalPrice(orderDetails.getQuantity() * orderEntity.getOrderItemPrice());
		
		
	}

	@Override
	public Customer getCustomerPendingOrders(Integer customerId) {
		// TODO Auto-generated method stub
		CustomerEntity customerEntity   = entityManager.find(CustomerEntity.class , customerId);
		Customer customer =null;
		
		if(customerEntity!=null) {
			customer = new Customer();
			customer.setAadhaarNo(customerEntity.getAadhaarNo());
			customer.setAge(customerEntity.getAge());
			customer.setCustmerId(customerEntity.getCustmerId());
			customer.setCustomerName(customerEntity.getCustomerName());
			customer.setDateOfJoined(customerEntity.getDateOfJoined());
			customer.setGender(customerEntity.getGender());
			customer.setStatus(customerEntity.getStatus());
			List<OrdersEntity> customerOrders = customerEntity.getOrderEntities();
			List<Order> orders = new ArrayList<>();
			
				for(OrdersEntity customerOrder : customerOrders) {
					
					if(customerOrder.getPaymentStatus().equals(PaymentStatus.Pending)) {
						// pending order will get set
					
						Order order = new Order();
						order.setOrderedDate(customerOrder.getOrderedDate());
						order.setOrderId(customerOrder.getOrderId());
						order.setOrderItemPrice(customerOrder.getOrderItemPrice());
						order.setOrderItemType(customerOrder.getOrderItemType());
						order.setPaymentStatus(customerOrder.getPaymentStatus());
						order.setQuantity(customerOrder.getQuantity());
						order.setTotalPrice(customerOrder.getTotalPrice());
						orders.add(order);
					}
				}
				customer.setOrders(orders);
		}
		return customer;

	}
	
	
	
	
	
	
	

}
