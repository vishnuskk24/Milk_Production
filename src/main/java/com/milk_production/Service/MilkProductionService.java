package com.milk_production.Service;

import java.util.List;

import com.milk_production.Model.MilkDetails;

public interface MilkProductionService {

	public Long addMilkDetails(Integer ownerId, MilkDetails milkDetails) throws Exception;

	public Double updateMilkQuantity(Long milkid, MilkDetails milkDetails) throws Exception;

	public Double updateMilkPrice(Long milkid, MilkDetails milkDetails) throws Exception;

	List<MilkDetails> getMilkDetails(Integer ownerId) throws Exception;

}
