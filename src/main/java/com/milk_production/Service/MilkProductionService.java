package com.milk_production.Service;

import com.milk_production.Model.MilkDetails;

public interface MilkProductionService {

	public Long addMilkDetails(Integer ownerId, MilkDetails milkDetails) throws Exception;

	public Double updateMilkQuantity(Long milkid, MilkDetails milkDetails) throws Exception;

	public Double updateMilkPrice(Long milkid, MilkDetails milkDetails) throws Exception;

}
