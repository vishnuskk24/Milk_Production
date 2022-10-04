package com.milk_production.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.milk_production.Model.Gender;


@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custmerId;
	private String customerName;
	private Long aadhaarNo;
	private Long phoneNo;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dateOfJoined;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id" ,unique = true)
	private AddressEntity addressEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id")
	private List<OrdersEntity> orderEntities;
//	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id")
	private List<MilkProductionEntity> milkProductionEntities;
//	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id" ,unique = true)
	private BankDetailsEntity bankDetailsEntity;
//	
	
	
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
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	public List<OrdersEntity> getOrderEntities() {
		return orderEntities;
	}
	public void setOrderEntities(List<OrdersEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}
	public List<MilkProductionEntity> getMilkProductionEntities() {
		return milkProductionEntities;
	}
	public void setMilkProductionEntities(List<MilkProductionEntity> milkProductionEntities) {
		this.milkProductionEntities = milkProductionEntities;
	}
	public BankDetailsEntity getBankDetailsEntity() {
		return bankDetailsEntity;
	}
	public void setBankDetailsEntity(BankDetailsEntity bankDetailsEntity) {
		this.bankDetailsEntity = bankDetailsEntity;
	}
	
	
}
