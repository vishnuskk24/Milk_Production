package com.milk_production.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.milk_production.Model.ItemType;
import com.milk_production.Model.PaymentStatus;

@Entity
@Table(name = "itemdetails")

public class ItemDetailsEntity {
	@Id
	private String itemName;
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	private Double itemPrice;
	
						//	private 													private Integer orderId;
							
						//	private ItemType orderItemType;
						//	
						//	private Double orderItemPrice;
						//	private LocalDate orderedDate;
						//	
						//	private PaymentStatus paymentStatus; 
						//	private Integer quantity;
						//	
						//	private Double totalPrice;

	

}
