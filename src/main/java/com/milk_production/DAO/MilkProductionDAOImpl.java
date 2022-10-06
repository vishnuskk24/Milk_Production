package com.milk_production.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.milk_production.Entity.CustomerEntity;
import com.milk_production.Entity.MilkDetailsEntity;
import com.milk_production.Model.MilkDetails;

@Repository
public class MilkProductionDAOImpl implements MilkProducionDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<MilkDetails> getMilkDetailsByOwnerId(Integer ownerId) {
		List<MilkDetails> milkReport=null;
		
		CustomerEntity ce  = entityManager.find(CustomerEntity.class, ownerId);
			if(ce!=null) {
				milkReport=new ArrayList<>();
				List<MilkDetailsEntity> milkEntityReport = ce.getMilkProductionEntities();
					if(milkEntityReport.size()!=0) {
						
					
							for(MilkDetailsEntity milkDetailsEntity:milkEntityReport) {
								
								MilkDetails milkDetails = new MilkDetails();
								milkDetails.setFat(milkDetailsEntity.getFat());
								milkDetails.setMilkProvidingId(milkDetailsEntity.getMilkProvidingId());
								milkDetails.setPrice(milkDetailsEntity.getPrice());
								milkDetails.setProducingDate(milkDetailsEntity.getProducingDate());
								milkDetails.setQuality(milkDetailsEntity.getQuality());
								milkDetails.setRemarks(milkDetailsEntity.getRemarks());
								milkDetails.setSession(milkDetailsEntity.getSession());
								milkDetails.setSNFValue(milkDetailsEntity.getSNFValue());
								milkDetails.setTotalPrice(milkDetailsEntity.getTotalPrice());
								milkReport.add(milkDetails);
								
							}
					}
				
			}
		
		
		// TODO Auto-generated method stub
		return milkReport;
	}

	@Override
	public Long addMilkDetails(Integer ownerId, MilkDetails milkDetails) {
		// TODO Auto-generated method stub
		CustomerEntity ce  = entityManager.find(CustomerEntity.class, ownerId);
		MilkDetailsEntity milkDetailEntity  = new MilkDetailsEntity();
		milkDetailEntity.setFat(milkDetails.getFat());
		milkDetailEntity.setPrice(milkDetails.getPrice());
		milkDetailEntity.setProducingDate(milkDetails.getProducingDate());
		milkDetailEntity.setQuality(milkDetails.getQuality());
		milkDetailEntity.setRemarks(milkDetails.getRemarks());
		milkDetailEntity.setSession(milkDetails.getSession());
		milkDetailEntity.setSNFValue(milkDetails.getSNFValue());
		milkDetailEntity.setTotalPrice(milkDetails.getTotalPrice());
		ce.getMilkProductionEntities().add(milkDetailEntity);
		return ce.getMilkProductionEntities().get(ce.getMilkProductionEntities().size()-1).getMilkProvidingId();
		
	}

	@Override
	public MilkDetails getMilkDetails(Long milkId) {
		// TODO Auto-generated method stub
		MilkDetailsEntity milkDetailsEntity = entityManager.find(MilkDetailsEntity.class, milkId);
		MilkDetails milkDetails =null;
		if(milkDetailsEntity!=null) {
			milkDetails = new MilkDetails();
			milkDetails.setFat(milkDetailsEntity.getFat());
			milkDetails.setMilkProvidingId(milkDetailsEntity.getMilkProvidingId());
			milkDetails.setPrice(milkDetailsEntity.getPrice());
			milkDetails.setProducingDate(milkDetailsEntity.getProducingDate());
			milkDetails.setQuality(milkDetailsEntity.getQuality());
			milkDetails.setRemarks(milkDetailsEntity.getRemarks());
			milkDetails.setSession(milkDetailsEntity.getSession());
			milkDetails.setSNFValue(milkDetailsEntity.getSNFValue());
			milkDetails.setTotalPrice(milkDetailsEntity.getTotalPrice());
		}
		
		return milkDetails;
	}

	@Override
	public Double updateMilkQuantity(Long milkId, MilkDetails milkDetails) {
		// TODO Auto-generated method stub
		MilkDetailsEntity milkDetailsEntity = entityManager.find(MilkDetailsEntity.class, milkId);
		milkDetailsEntity.setQuality(milkDetails.getQuality());
		milkDetailsEntity.setRemarks(milkDetails.getRemarks());
		milkDetailsEntity.setTotalPrice(milkDetails.getPrice()*milkDetails.getQuality());
		
		return milkDetails.getPrice()*milkDetails.getQuality();   // returning total price for confirmation
		
	
	}

	@Override
	public Double updateMilkPrice(Long milkId, MilkDetails milkDetails) {
		// TODO Auto
		// TODO Auto-generated method stub
				MilkDetailsEntity milkDetailsEntity = entityManager.find(MilkDetailsEntity.class, milkId);
				milkDetailsEntity.setQuality(milkDetails.getPrice());
				milkDetailsEntity.setRemarks(milkDetails.getRemarks());
				milkDetailsEntity.setTotalPrice(milkDetails.getPrice()*milkDetails.getQuality());
				
				return milkDetails.getPrice()*milkDetails.getQuality();  
		
	}

}
