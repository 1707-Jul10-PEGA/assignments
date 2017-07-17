package com.nc.banking_app.users;

import java.io.Serializable;

public abstract class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract String getType();
	public abstract void setType(String type);
	public abstract String getName();
	public abstract void setName(String name);
	public abstract double getBalance();
	public abstract void setBalance(double balance);
	public abstract int getMemeber();
	public abstract void setMemeber(int memeber);
	public abstract String toString();
}
