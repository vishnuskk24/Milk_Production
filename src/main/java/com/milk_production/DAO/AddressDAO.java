package com.milk_production.DAO;

import com.milk_production.Model.Address;

public interface AddressDAO {

	Address getAddressDetails(Integer addressId);

	void updateAddress(Integer addressId, Address addressDetails);

}
