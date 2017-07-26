package com.revature.bankingapp.dao.interfaces;

import java.util.List;
import java.util.UUID;

import com.revature.bankingapp.entities.account.BankAccount;

public interface BankAccountDaoInterface extends DaoInterface {

	List<BankAccount> getAllAccountsForCustomerWithId(UUID customerId);
	
	
}
