package users;

import java.util.ArrayList;

import accounts.Account;
import central.AllAccounts;

public class Admin extends User {

	public Admin() {
		this.setType("A");
	}

	public Admin(String un, String pw) {
		super(un, pw);
		this.setType("A");
	}
	
	public ArrayList<Account> viewAcc(String un) {
		ArrayList<Account> al = new ArrayList<Account>();
		for(Account a: AllAccounts.getAlla()) {
			if(a.getHolder().getUsername() == un) {
				al.add(a);
			}
		}
		return al;
	}
	
	public Account selectAcc(ArrayList<Account> ala, String k) {
		boolean found = false;
		for(Account a: ala) {
			if(a.getKey().equals(k)) {
				found = true;
				return a;
			}
		}
		if(!found) {
			System.out.println("No account with that key");
			return null;
		}
		else {
			return null;
		}
	}
	
	public void editAcc(Account a, double ed) {
		double current = a.getBalance();
		current += ed;
		a.setBalance(current);
	}

}
