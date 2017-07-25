package com.nc.banking_app.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Account> account= new ArrayList<Account>();
	public abstract String getType();
	public abstract void setType(String type);
	public abstract String getName();
	public abstract void setName(String name);
	public abstract String toString();
	public abstract List<Account> getAccount();
}
