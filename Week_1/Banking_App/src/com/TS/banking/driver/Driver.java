package com.TS.banking.driver;

import java.io.File;
import java.io.FileNotFoundException;

import com.TS.banking.actions.Admin;
import com.TS.banking.actions.Customer;
import com.TS.banking.actions.Employee;
import com.TS.banking.actions.LoginAction;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		while(!LoginAction.login())
		{ 
			if (LoginAction.ERROR == true)
			{ return; }
		}
		
		switch(LoginAction.privilege)
		{
		case 1:
			Customer.menuAction();
			break;
		case 2:
			Employee.menuAction();
			break;
		case 3:
			Admin.menuAction();
			break;
		case 4:
			System.out.println("\nI hope you will apply for my app next time, goodbye!\n");
			return;
		default:
			LoginAction.error();
			return;
		}
		System.out.println("\nThank you for using my Banking App!\n");
	}

}
