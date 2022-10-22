package com.milk_production.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milk_production.DAO.BankDetailsDAO;
import com.milk_production.DAO.CustomerDAO;
import com.milk_production.Model.BankDetails;
import com.milk_production.Model.Customer;

@Service("bankDetailsService")
@Transactional
public class BankDetailsServiceImpl implements BankDetailsService {
	
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private BankDetailsDAO bankDetilsDAO;

	@Override
	public BankDetails getBankDetails(Integer customerId) throws Exception {
		Customer customer =customerDAO.getCustomerDetail(customerId);
		if(customer==null) {
			throw new Exception("CUSTOMER_NOT_FOUND");
			
		}
		return customer.getBankDetails();
		
	}
	
	@Override
	public String updateAccountNoByBankId(Integer bankId,BankDetails bankDetails) throws Exception {
		BankDetails bankDetail = bankDetilsDAO.getBankRecord(bankId);
		if(bankDetail==null) {
			throw new Exception("Service.BANK_DETAILS_NOT_FOUND");
		}else {
			bankDetilsDAO.updateAccountNoByBankId(bankId,bankDetails);
			return "ACCOUNT_NUMBER_UPDATED_SUCCESSFULY";
		}
		
		
	}
	@Override
	public String updateIfscCodeByBankId(Integer bankId,BankDetails bankDetails) throws Exception {
		BankDetails bankDetail = bankDetilsDAO.getBankRecord(bankId);
		
		if(bankDetail==null) {
			throw new Exception("Service.BANK_DETAILS_NOT_FOUND");
		}else {
			bankDetilsDAO.updateIfscCodeByBankId(bankId,bankDetails);
			return "IFSC_CODE_UPDATED_SUCCESSFULY";
		}
		
		
	}
	@Override
	public String updateBranchNameByBankId(Integer bankId,BankDetails bankDetails) throws Exception {
		BankDetails bankDetail = bankDetilsDAO.getBankRecord(bankId);
		
		if(bankDetail==null) {
			throw new Exception("Service.BANK_DETAILS_NOT_FOUND");
		}else {
			bankDetilsDAO.updateBranchNameByBankId(bankId,bankDetails);
			return "BRANCH_NAME_UPDATED_SUCCESSFULY";
		}
//		return null;
			}
}
