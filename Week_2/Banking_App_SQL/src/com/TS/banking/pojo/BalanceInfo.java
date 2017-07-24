package com.TS.banking.pojo;

public class BalanceInfo {
	private String applicationStatus;
	private String loginID;
	private String firstName;
	private String lastName;
	private Double balance;
	
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "BalanceInfo [applicationStatus=" + applicationStatus + ", loginID=" + loginID + ", firstName="
				+ firstName + ", lastName=" + lastName + ", balance=" + balance + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationStatus == null) ? 0 : applicationStatus.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((loginID == null) ? 0 : loginID.hashCode());
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
		BalanceInfo other = (BalanceInfo) obj;
		if (applicationStatus == null) {
			if (other.applicationStatus != null)
				return false;
		} else if (!applicationStatus.equals(other.applicationStatus))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loginID == null) {
			if (other.loginID != null)
				return false;
		} else if (!loginID.equals(other.loginID))
			return false;
		return true;
	}
	
	public BalanceInfo(String applicationStatus, String loginID, String firstName, String lastName, Double balance) {
		super();
		this.applicationStatus = applicationStatus;
		this.loginID = loginID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	public BalanceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
