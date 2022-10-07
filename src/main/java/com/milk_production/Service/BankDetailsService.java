package com.milk_production.Service;

import java.util.List;

import com.milk_production.Model.BankDetails;
import com.milk_production.Model.MilkDetails;

public interface BankDetailsService {

	public BankDetails getBankDetails(Integer ownerId) throws Exception;

	String updateAccountNoByBankId(Integer BankId,BankDetails bankDetails) throws Exception;

	String updateIfscCodeByBankId(Integer BankId,BankDetails bankDetails) throws Exception;

	String updateBranchNameByBankId(Integer BankId,BankDetails bankDetails) throws Exception;

}
