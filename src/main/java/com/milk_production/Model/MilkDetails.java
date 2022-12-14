package com.milk_production.Model;

import java.time.LocalDate;

public class MilkDetails {

	private Long milkProvidingId;
	private Double quality;
	private Double price;
	private Double totalPrice;
	private Float SNFValue;
	private Float  fat;
	private String remarks;
	private Session session;  
	private LocalDate producingDate;
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	public Long getMilkProvidingId() {
		return milkProvidingId;
	}

	public void setMilkProvidingId(Long milkProvidingId) {
		this.milkProvidingId = milkProvidingId;
	}

	public Double getQuality() {
		return quality;
	}

	public void setQuality(Double quality) {
		this.quality = quality;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Float getSNFValue() {
		return SNFValue;
	}

	public void setSNFValue(Float sNFValue) {
		SNFValue = sNFValue;
	}

	public Float getFat() {
		return fat;
	}

	public void setFat(Float fat) {
		this.fat = fat;
	}

	public LocalDate getProducingDate() {
		return producingDate;
	}

	public void setProducingDate(LocalDate producingDate) {
		this.producingDate = producingDate;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
}
