package com.milk_production.Entity;
 
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.milk_production.Model.Session;

@Entity
@Table(name = "milk_production")
public class MilkDetailsEntity {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long milkProvidingId;
	private Double quality;
	private Double price;
	private Double totalPrice;
	private Float SNFValue;
	private Float  fat;
	private String remarks;	
	private LocalDate producingDate;
	@Enumerated(EnumType.STRING)
	private Session session;
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
