package com.revature.bankingapp.dao.interfaces;

import java.sql.SQLException;
import java.util.UUID;

import com.revature.bankingapp.entities.user.Customer;
import com.revature.bankingapp.entities.user.SystemUser;

public interface CustomerDaoInterface extends DaoInterface{

	boolean isCustomer(UUID id) throws SQLException;
	boolean isCustomer(String id) throws SQLException;
	Customer getCustomerById(UUID id) throws SQLException;
	Customer getCustomerById(String id) throws SQLException;
	
	
}
