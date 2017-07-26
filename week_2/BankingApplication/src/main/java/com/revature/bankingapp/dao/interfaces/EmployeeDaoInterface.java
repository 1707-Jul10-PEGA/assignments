package com.revature.bankingapp.dao.interfaces;

import java.util.UUID;

import com.revature.bankingapp.entities.user.Employee;

public interface EmployeeDaoInterface extends DaoInterface {

	Employee getMyAssignedBanker(UUID customerId);
	
	
	
}
