package com.milk_production.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milk_production.DAO.AddressDAO;
import com.milk_production.Model.Address;
@Service(value = "addressService")
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDAO addressDAO;

	@Override
	public String updateAddress(Integer addressId, Address addressDetails) throws Exception {
		// TODO Auto-generated method stub
		Address address = addressDAO.getAddressDetails(addressId);
		if(address==null) {
			throw new Exception("Service.ADDRESS_NOT_AVAILABLE");
		}
		addressDAO.updateAddress(addressId ,addressDetails);
		String resp = "Service.ADDRESS_UPDATED_SUCCESFULLY";
		return resp;
	}

	@Override
	public Address getAddressDetails(Integer addressId) throws Exception {
		// TODO Auto-generated method stub
		Address address = addressDAO.getAddressDetails(addressId);
		if(address==null) {
			throw new Exception("Service.ADDRESS_NOT_AVAILABLE");
		}
				return address;
	}

}

