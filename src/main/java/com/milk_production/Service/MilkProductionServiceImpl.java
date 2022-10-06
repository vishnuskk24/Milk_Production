package com.milk_production.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milk_production.DAO.MilkProducionDAO;
import com.milk_production.Model.MilkDetails;
import com.milk_production.Validator.Validator;

@Service
@Transactional
public class MilkProductionServiceImpl implements MilkProductionService {
	@Autowired
	private MilkProducionDAO milkProductionDAO;

	@Override
	public Long addMilkDetails(Integer ownerId, MilkDetails milkDetails) throws Exception {
		
		// TODO Auto-generated method stubb
		List<MilkDetails> milkReports=milkProductionDAO.getMilkDetailsByOwnerId(ownerId);
		if(milkReports==null) {
			throw new Exception("CUSTOMER_NOT_FOUND");
		}
		else if(milkReports.size()==0){
			throw new Exception("NO_MILK_RECORD_FOUND");
		}
		for(MilkDetails milkDetail : milkReports) {
			if(milkDetail.getProducingDate().equals(LocalDate.now())) {
				if(milkDetail.getSession().equals(Validator.getSession())) {
					throw new Exception("SERVICE."+ Validator.getSession() +"_PRODUCTION_RATE_IS_ALREADY_INSERATED");
				}
				
			}
		}
		milkDetails.setProducingDate(LocalDate.now());
		milkDetails.setSession(Validator.getSession());
		milkDetails.setTotalPrice(milkDetails.getPrice()*milkDetails.getQuality());
		
		Long milkProducingId =milkProductionDAO.addMilkDetails(ownerId,milkDetails);
		
		return milkProducingId;
	}
	@Override
	public List<MilkDetails> getMilkDetails(Integer ownerId) throws Exception {
		List<MilkDetails> milkReports=milkProductionDAO.getMilkDetailsByOwnerId(ownerId);
		if(milkReports==null) {
			throw new Exception("CUSTOMER_NOT_FOUND");
		}
		else if(milkReports==null) {
			throw new Exception("NO_MILK_RECORD_FOUND");
		}
		return milkReports;
	}

	@Override
	public Double updateMilkQuantity(Long milkId, MilkDetails milkDetails) throws Exception {
		// TODO Auto-generated method stub
		MilkDetails milkDetail = milkProductionDAO.getMilkDetails(milkId);
		if(milkDetail==null) {
			throw new Exception("NO_MILK_RECORD_FOUND");
		}else {
			if(milkDetails.getRemarks()==null) {
				throw new Exception("PROVIDE_REMARKS_UPDATE_MILK_QUANTITY");
			}else {
				Double totalPrice =milkProductionDAO.updateMilkQuantity(milkId,milkDetails);
				return totalPrice;
			}
		}
		
	}
	@Override
	public Double updateMilkPrice(Long milkId, MilkDetails milkDetails) throws Exception {
		
		MilkDetails milkDetail = milkProductionDAO.getMilkDetails(milkId);
		if(milkDetail==null) {
			throw new Exception("NO_MILK_RECORD_FOUND");
		}else {
			if(milkDetails.getRemarks()==null) {
				throw new Exception("PROVIDE_REMARKS_UPDATE_MILK_PRICE");
			}else {
				Double totalPrice =milkProductionDAO.updateMilkPrice(milkId,milkDetails);
				return totalPrice;
			}
		}
	}

}
