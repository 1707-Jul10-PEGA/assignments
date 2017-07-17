package com.nc.banking_app.users;

public class UserFactory{

	public Users getType(String userType, String name, double balance, int memeber){
		
		if(userType == null){
			return null;
		}
		if("CUSTOMER".equalsIgnoreCase(userType)){
			return new Customer(name, balance, memeber);
		}
		else if("EMPLOYEE".equalsIgnoreCase(userType)){
			return new Employee(name, balance, memeber);
		}
		else if("ADMIN".equalsIgnoreCase(userType)){
			return new Admin(name, balance, memeber);
		}
		return null;
	}
}
