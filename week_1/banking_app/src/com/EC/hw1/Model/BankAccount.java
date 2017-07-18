package com.EC.hw1.Model;

public class BankAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8180240208218125726L;
	private double cashAccount;
	private double savingAccount;
	private double creditAccount;

	public BankAccount() {
		super();
	}

	public BankAccount(String email, double cashAccount, double savingAccount, double creditAccount) {
		super(email);
		setCashAccount(cashAccount);
		setSavingAccount(savingAccount);
		setCreditAccount(creditAccount);
	}

	public double getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(double cashAccount) {
		this.cashAccount = cashAccount;
	}

	public double getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(double savingAccount) {
		this.savingAccount = savingAccount;
	}

	public double getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(double creditAccount) {
		this.creditAccount = creditAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cashAccount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(creditAccount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(savingAccount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(cashAccount) != Double.doubleToLongBits(other.cashAccount))
			return false;
		if (Double.doubleToLongBits(creditAccount) != Double.doubleToLongBits(other.creditAccount))
			return false;
		if (Double.doubleToLongBits(savingAccount) != Double.doubleToLongBits(other.savingAccount))
			return false;
		return true;
	}


	
	
	

}
