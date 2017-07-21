package accounts;

import users.Customer;

public class Account {
	
	private double balance;
	private Customer holder;
	private String key;

	public Account() {
		balance = 0;
		holder = null;
		key = "savings";
	}
	
	public Account(Customer h, String k) {
		balance = 0;
		holder = h;
		key = k;
	}

	public Customer getHolder() {
		return holder;
	}

	public void setHolder(Customer holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double current) {
		this.balance = current;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
