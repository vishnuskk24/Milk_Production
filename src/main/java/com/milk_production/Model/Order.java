package com.milk_production.Model;

import java.time.LocalDate;

public class Order {

private Integer orderId;
	
	private String orderItemType;
	
	private Double orderItemPrice;
	private LocalDate orderedDate;
	
	private PaymentStatus paymentStatus; 
	private Integer quantity;
	
	private Double totalPrice;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderItemType() {
		return orderItemType;
	}

	public void setOrderItemType(String orderItemType) {
		this.orderItemType = orderItemType;
	}

	public Double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(Double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	} 
}
