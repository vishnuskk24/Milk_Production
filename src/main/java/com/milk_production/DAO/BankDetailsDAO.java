package com.milk_production.DAO;

import com.milk_production.Model.BankDetails;

public interface BankDetailsDAO {

	public BankDetails getBankRecord(Integer bankId);

	public void updateIfscCodeByBankId(Integer bankId, BankDetails bankDetails);

	public void updateAccountNoByBankId(Integer bankId, BankDetails bankDetails);

	public void updateBranchNameByBankId(Integer bankId, BankDetails bankDetails);

}
