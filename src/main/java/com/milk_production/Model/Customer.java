 package com.milk_production.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.milk_production.Entity.AddressEntity;
import com.milk_production.Entity.BankDetailsEntity;
import com.milk_production.Entity.MilkDetailsEntity;
import com.milk_production.Entity.OrdersEntity;

public class Customer {

	
	private Integer custmerId;
	private String customerName;
	private Long aadhaarNo;
	private Long phoneNo;
	private Integer age;
	private Gender gender;
	private CustomerStatus status;
	
	private LocalDate dateOfJoined;
	private Address address;
	private List<Order> orders;
	private List<MilkDetails> milkProductions;
//	
	private BankDetails bankDetails;
	
	public Integer getCustmerId() {
		return custmerId;
	}
	public void setCustmerId(Integer custmerId) {
		this.custmerId = custmerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(Long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfJoined() {
		return dateOfJoined;
	}
	public void setDateOfJoined(LocalDate dateOfJoined) {
		this.dateOfJoined = dateOfJoined;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<MilkDetails> getMilkProductions() {
		return milkProductions;
	}
	public void setMilkProductions(List<MilkDetails> milkProductions) {
		this.milkProductions = milkProductions;
	}
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
}
