package com.bank.admin;

import com.bank.employee.Employee;

public class Admin extends Employee{

	public Admin(int db_id, String getfName, String getlName, String getuName, String pass, String position) {
		// TODO Auto-generated constructor stub
		this.setdbID(db_id);
		this.setfName(getfName);
		this.setlName(getlName);
		this.setPass(pass);
		this.setPosition(position);
		this.setuName(getuName);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2431070943999780177L;
//simply an employee that will be given access to additional withdraw/deposit options
	
}
