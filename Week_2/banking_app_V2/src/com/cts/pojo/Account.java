//Carson Stephens

package com.cts.pojo;

public class Account
{
	private int id;
	private int customer;
	private String type;
	private double balance;
	private int applied;
	private int approved;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getCustomer()
	{
		return customer;
	}
	public void setCustomer(int customer)
	{
		this.customer = customer;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public int getApplied()
	{
		return applied;
	}
	public void setApplied(int applied)
	{
		this.applied = applied;
	}
	public int getApproved()
	{
		return approved;
	}
	public void setApproved(int approved)
	{
		this.approved = approved;
	}
	public Account(int accountid, int id, String type, double balance, int applied, int approved)
	{
		super();
		this.id = accountid;
		this.customer = id;
		this.type = type;
		this.balance = balance;
		this.applied = applied;
		this.approved = approved;
	}
	
	
}
