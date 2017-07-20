package com.cts.driver;

public class Account
{
	
	float balance;
	boolean accepted;
	boolean applied;
	
	public Account(float balance)
	{
		this.balance = balance;
		this.accepted = false;
	}


	public boolean isApplied()
	{
		return applied;
	}



	public void setApplied(boolean applied)
	{
		this.applied = applied;
	}



	public float getBalance()
	{
		return balance;
	}



	public void setBalance(float balance)
	{
		this.balance = balance;
	}



	public boolean isAccepted()
	{
		return accepted;
	}



	public void setAccepted(boolean accepted)
	{
		this.accepted = accepted;
	}
}
