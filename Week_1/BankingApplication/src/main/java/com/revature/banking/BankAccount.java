package com.revature.banking;

public abstract class BankAccount {
	private String acctName;
	private double balance;
	private String type;
	
	public BankAccount(String name, double balance, String type) {
		super();
		this.acctName = name;
		this.balance = balance;
		this.type = type;
	}
	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "\nAccount Name=" + acctName + " balance=" + balance + ", type=" + type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	public double deposit(double amount) {
		double newBalance = this.balance + amount;
		setBalance(newBalance);
		return newBalance;
	}
	public double withdraw(double amount) {
		double newBalance = this.balance - amount;
		setBalance(newBalance);
		return newBalance;
	}

	

}
