package com.bank.user;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7780000071986403836L;
	
	private String fName;
	
	private String lName;
	
	private String uName;
	
	private String pass;
	
	private String position;
	
	private int dbID;

	public int getDb_id() {
		return dbID;
	}

	public void setdbID(int db_id) {
		this.dbID = db_id;
	}

	public String getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "User [dbID=" + dbID + ", fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", pass=" + pass + ", position="
				+ position + "]";
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getfName() {
		return fName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
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
		User other = (User) obj;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		return true;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}