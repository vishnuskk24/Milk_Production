package com.milk_production.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.milk_production.Entity.AddressEntity;
import com.milk_production.Model.Address;

@Repository(value = "addressDAO")
public class AddressDAOImpl implements AddressDAO {
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public Address getAddressDetails(Integer addressId) {
		// TODO Auto-generated method stub
		AddressEntity addressEntity =entityManager.find(AddressEntity.class, addressId);
		Address address = null;
		if(addressEntity!=null) {
			 address = new Address();

		address.setAddressId(addressEntity.getAddressId());
		address.setDistrict(addressEntity.getDistrict());
		address.setHouseNo(addressEntity.getHouseNo());
		address.setPinCode(addressEntity.getPinCode());
		address.setPlace(addressEntity.getPlace());
		address.setStreetName(addressEntity.getStreetName());
		address.setTaluk(addressEntity.getTaluk());
		}
		return address;
	}


	@Override
	public void updateAddress(Integer addressId, Address address) {
		
		AddressEntity addressEntity =entityManager.find(AddressEntity.class, addressId);
		addressEntity.setAddressId(addressEntity.getAddressId());
		addressEntity.setDistrict(addressEntity.getDistrict());
		addressEntity.setHouseNo(addressEntity.getHouseNo());
		addressEntity.setPinCode(addressEntity.getPinCode());
		addressEntity.setPlace(addressEntity.getPlace());
		addressEntity.setStreetName(addressEntity.getStreetName());
		addressEntity.setTaluk(addressEntity.getTaluk());
		
		
		
	}

}
