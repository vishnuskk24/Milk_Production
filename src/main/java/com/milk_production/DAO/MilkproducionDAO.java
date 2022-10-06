package com.milk_production.DAO;

import java.util.List;

import com.milk_production.Model.MilkDetails;

public interface MilkProducionDAO {

	List<MilkDetails> getMilkDetailsByOwnerId(Integer ownerId);

	Long addMilkDetails(Integer ownerId, MilkDetails milkDetails);

	MilkDetails getMilkDetails(Long milkId);

	Double updateMilkQuantity(Long milkId, MilkDetails milkDetails);

	Double updateMilkPrice(Long milkId, MilkDetails milkDetails);

}
