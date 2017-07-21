package central;

import java.util.ArrayList;

import accounts.Account;

public class AllAccounts {
	
	static ArrayList<Account> alla;

	public AllAccounts() {
	}

	public static ArrayList<Account> getAlla() {
		return alla;
	}

	public static void setAlla(ArrayList<Account> a) {
		alla = a;
	}
	
}
