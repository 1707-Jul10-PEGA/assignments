package com.as.bankingapp.account;

import java.io.Serializable;

import com.as.bankingapp.customer.Customer;

public class Account implements Serializable{

	private static final long serialVersionUID = -6614705024406425070L;
	
	private int id;
	
	private boolean active;

	private double value;
	
	private Customer owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	public Account(int id, double value, boolean status, Customer owner) {
		super();
		this.id = id;
		this.value = value;
		this.active = status;
		this.owner = owner;
	}

	public Account() {
		super();
		this.id = 0;
		this.value = 0;
		this.active = false;
		this.owner = null;
	}
	
	/*
	 * Deposit money into the account
	 */
	public void deposit(double amt) {
		if (this.isActive()) {
			if (amt < 0) {
				System.out.println("Amount must be positive.");
			} else {
				this.setValue(this.getValue() + amt);
			}
		} else {
			System.out.println("This account is not active.");
		}
	}
	
	/*
	 * withdraw money from the account
	 */
	public void withdraw(double amt) {
		if (this.isActive()) {
			if  (amt < 0) {
				System.out.println("Amount must be positive.");
			} else {
				if (value < amt) {
					System.out.println("Insufficient funds.");
				} else {
					this.setValue(this.getValue() - amt);
				}
			}
		} else {
			System.out.println("This account is not active.");
		}
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", active=" + active + ", value=" + value + ", owner=" + owner + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
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
		Account other = (Account) obj;
		if (active != other.active)
			return false;
		if (id != other.id)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

		
}
