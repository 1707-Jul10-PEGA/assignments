package com.bank.driver;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.bank.admin.Admin;
import com.bank.customer.Customer;
import com.bank.employee.Employee;
import com.bank.menu.StartingMenuClass;
import com.bank.user.User;

public class Driver {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Welcome to Wendell's Bank!");
		//loading all bank user info
		
		
		Admin myAdmin = new Admin();
		myAdmin.setfName("Blake");
		myAdmin.setlName("Trainer");
		myAdmin.setPass("pass");
		myAdmin.setuName("nick");
		myAdmin.setPosition("admin");

//		myEmp.addAccount(myCust, myCust.getAccountsToProcess().get(0).toString(), myEmp);

	
		ArrayList<Admin> admins = new ArrayList<Admin>();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<String[]> toApp = new ArrayList<String[]>();
		
	try {
			FileInputStream custIn = new FileInputStream("./customers.txt");
			ObjectInputStream cIn = new ObjectInputStream(custIn);
			FileInputStream empIn = new FileInputStream("./employees.txt");
			ObjectInputStream eIn = new ObjectInputStream(empIn);
//			FileInputStream adIn = new FileInputStream("./admins.txt");
//			ObjectInputStream aIn = new ObjectInputStream(adIn);
			FileInputStream appIn = new FileInputStream("./applicants.txt");
			ObjectInputStream apIn = new ObjectInputStream(appIn);
			
			customers =  (ArrayList<Customer>) cIn.readObject();
			employees = (ArrayList<Employee>) eIn.readObject();
//			admins = (ArrayList<Admin>) aIn.readObject();
//			System.out.println(admins.toString());
			toApp = (ArrayList<String[]>) apIn.readObject();
			
//			aIn.close();
			cIn.close();
			eIn.close();
//			adIn.close();
			custIn.close();
			empIn.close();
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("class not found");
			c.printStackTrace();
			return;
			
		}

 
		
//		String[] toGo = new String[2];
//		toGo[0] = "C1234567";
//		toGo[1] = "jkhabbaz";
//		toApp.add(toGo);
//		String[] tog = new String[2];
//		tog[0] = "C9876543";
//		tog[1] = "jkhabbaz";
//		toApp.add(toGo);
		
		System.out.println(toApp.get(1)[0].toString());
		StartingMenuClass sMC = new StartingMenuClass();
		sMC.menuHandler(admins, employees, (ArrayList<Customer>) customers, toApp);

				
		customers = (ArrayList<Customer>) sMC.getPrivateC();
		employees = (ArrayList<Employee>) sMC.getPrivateE();		
		toApp = (ArrayList<String[]>) sMC.getToApprove();

		//rewriting the output files
		try {
			FileOutputStream cusOut = new FileOutputStream("./customers.txt");
			ObjectOutputStream cOut= new ObjectOutputStream(cusOut);
			FileOutputStream empOut = new FileOutputStream("./employees.txt");
			ObjectOutputStream eOut = new ObjectOutputStream(empOut);
			FileOutputStream appOut = new FileOutputStream("./applicants.txt");
			ObjectOutputStream apOut = new ObjectOutputStream(appOut);
			
			cOut.writeObject(customers);
			eOut.writeObject(employees);
			apOut.writeObject(toApp);
			
			apOut.close();
			eOut.close();
			empOut.close();
			cOut.close();
			cusOut.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
		
	}
	
}
