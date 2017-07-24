//Carson Stephens

package com.cts.pojo;

import java.util.List;

public class Customer extends User
{
	private int employee;
	private List<Account> accounts;
	
	public Customer()
	{
		
	}
	
	public Customer(int id, String username, String password, String firstname, String lastname, int employee,
			List<Account> accounts)
	{
		super(id, username, password, firstname, lastname);
		this.employee = employee;
		this.accounts = accounts;
	}
	
	public int getEmployee()
	{
		return employee;
	}
	public void setEmployee(int employee)
	{
		this.employee = employee;
	}
	public List<Account> getAccounts()
	{
		return accounts;
	}
	public void setAccounts(List<Account> accounts)
	{
		this.accounts = accounts;
	}
	
	
}
