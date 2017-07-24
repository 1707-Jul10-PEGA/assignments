package com.WilliamLewis.BankingApp.AccountFactory;

import org.apache.log4j.Logger;

import com.WilliamLewis.BankingApp.BankData.BankData;
import com.WilliamLewis.BankingApp.BankData.Accounts.Account;
import com.WilliamLewis.BankingApp.Users.User;

/**
 * 
 * @author William class responsible for creating userAccounts and generating a
 *         unique ID for them At the moment only one type of account exists:
 *         basic accounts, which have no interest, only hold money.
 *
 */
public class AccountFactory {
	private static Logger log = Logger.getRootLogger();

	public static int createAccount(String type, User owner) {
		Account ba;
		type = type.toLowerCase();

		// Random Int generation, technically this means we can only have 10000
		// accounts, could change IDs to work with a hashing function later if
		// we need to upscale
		Integer myId = (int) (Math.random() * 100000);
		while (!BankData.getInstance().freeID(myId)) {
			myId = (int) (Math.random() * 100000);
		}
		// Add cases for other account types as needed,
		switch (type) {
		case "basic":
			ba = new Account(owner, myId);
			ba.initialize();
			return myId;
		default:
			log.error("Improper account type selected");
			return 0;
		}

	}
}
