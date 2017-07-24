package com.TS.banking.pojo;

public class LoginInfo {
	private String loginID;
	private String loginPassword;
	private int position;
	
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "LoginInfo [loginID=" + loginID + ", loginPassword=" + loginPassword + ", position=" + position + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginID == null) ? 0 : loginID.hashCode());
		result = prime * result + ((loginPassword == null) ? 0 : loginPassword.hashCode());
		result = prime * result + position;
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
		LoginInfo other = (LoginInfo) obj;
		if (loginID == null) {
			if (other.loginID != null)
				return false;
		} else if (!loginID.equals(other.loginID))
			return false;
		if (loginPassword == null) {
			if (other.loginPassword != null)
				return false;
		} else if (!loginPassword.equals(other.loginPassword))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	
	public LoginInfo(String loginID, String loginPassword, int position) {
		super();
		this.loginID = loginID;
		this.loginPassword = loginPassword;
		this.position = position;
	}
	
	public LoginInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
