package com.revature.bankingapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import com.revature.bankingapp.dao.interfaces.BankAccountDaoInterface;
import com.revature.bankingapp.utils.ConnectionFactory;

public class BankAccountDao implements BankAccountDaoInterface{

	Connection conn = null;
	ResultSet resultSet = null;
	ConnectionFactory connFactory = null;
	
	@Override
	public void setup() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		connFactory = ConnectionFactory.getInstance();
	}
	
	public BankAccountDao() {
		try {
			setup();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
