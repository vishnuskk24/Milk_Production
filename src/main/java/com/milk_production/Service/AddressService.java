package com.milk_production.Service;

import com.milk_production.Model.Address;

public interface AddressService {

	String updateAddress(Integer addressId, Address addressDetails) throws Exception;

	Address getAddressDetails(Integer addressId) throws Exception;

}
