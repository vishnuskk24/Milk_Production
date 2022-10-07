package com.milk_production.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.milk_production.Entity.BankDetailsEntity;
import com.milk_production.Model.BankDetails;

@Repository
public class BankDetailsDAOImpl implements BankDetailsDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public BankDetails getBankRecord(Integer bankId) {
		BankDetailsEntity bankEntity = entityManager.find(BankDetailsEntity.class, bankId);
		BankDetails bankDetails = null;
		if(bankEntity!=null) {
			bankDetails = new BankDetails();
			bankDetails.setAccountNo(bankEntity.getAccountNo());
			bankDetails.setBankId(bankEntity.getBankId());
			bankDetails.setBankName(bankEntity.getBankName());
			bankDetails.setBranchName(bankEntity.getBranchName());
			bankDetails.setIfscCode(bankEntity.getIfscCode());
			
		}
		// TODO Auto-generated method stub
		return bankDetails;
	}

	@Override
	public void updateIfscCodeByBankId(Integer bankId, BankDetails bankDetails) {
		// TODO Auto-generated method stub
		BankDetailsEntity bankEntity = entityManager.find(BankDetailsEntity.class, bankId);
		bankEntity.setIfscCode(bankDetails.getIfscCode());
		
	}

	@Override
	public void updateAccountNoByBankId(Integer bankId, BankDetails bankDetails) {
		// TODO Auto-generated method stub\
		BankDetailsEntity bankEntity = entityManager.find(BankDetailsEntity.class, bankId);
		bankEntity.setAccountNo(bankDetails.getAccountNo());
		
	}

	@Override
	public void updateBranchNameByBankId(Integer bankId, BankDetails bankDetails) {
		// TODO Auto-generated method stub
		BankDetailsEntity bankEntity = entityManager.find(BankDetailsEntity.class, bankId);
		bankEntity.setBranchName(bankDetails.getBranchName());
		
	}

	
}
