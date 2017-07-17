package com.WilliamLewis.BankingApp.AccountFactory;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;

public class AccountFactory {
	private static Logger log = Logger.getRootLogger();
	public static int createAccount(String type, String Username)

	{
		Account ba;
		type = type.toLowerCase();
		Integer myId = (int) (Math.random()*10000);
		while(BankData.getInstance().checkID(myId))
		{
			myId = (int) (Math.random()*100000);
		}
		
		switch (type) {
		case "basic":
			ba = new Account(Username, myId);
			ba.initialize();
			return myId;
		default: log.error("Improper account type selected");
				return 0;
		}

	}
}
