package com.bank.factory;

import java.io.Serializable;

import com.bank.employee.Employee;

public interface BankAccount extends Serializable {

	public Employee getNameOfStarter();
	public double viewBalance();
	public void withdraw(double amount);
	public void deposit(double amount);
	public String getID();
}
