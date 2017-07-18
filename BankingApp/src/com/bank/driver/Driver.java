package com.bank.driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bank.admin.Admin;
import com.bank.customer.Customer;
import com.bank.employee.Employee;
import com.bank.menu.StartingMenuClass;
import java.sql.*;



public class Driver {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Welcome to Wendell's Bank!");

		//loading all bank user info
		
//		Admin myAdmin = new Admin();
//		myAdmin.setfName("Blake");
//		myAdmin.setlName("Trainer");
//		myAdmin.setPass("pass");
//		myAdmin.setuName("nick");
//		myAdmin.setPosition("admin");
//		
//		Customer jo = new Customer();
//		jo.setfName("Troy");
//		jo.setlName("Aikman");
//		jo.setuName("troy");
//		jo.setPass("pass");
//		jo.setPosition("customer");
//		
//		Customer them = new Customer();
//		them.setfName("first");
//		them.setlName("last");
//		them.setuName("first");
//		them.setPass("pass");
//		them.setPosition("customer");
//		
//		Employee me = new Employee();
//		me.setfName("Wendell");
//		me.setlName("Phipps");
//		me.setuName("wendell");
//		me.setPass("pass");
//		me.setPosition("employee");
//		
//		Employee you = new Employee();
//		you.setfName("Master");
//		you.setlName("Chief");
//		you.setPass("pass");
//		you.setuName("chief");
//		you.setPosition("employee");
//
//		you.addAccount(them, "C120983", you);

	
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

//		Customer ps = new Customer();
//		ps.setPosition("customer");
//		ps.setfName("Joseph");
//		ps.setlName("Khabbaz");
//		ps.setuName("joseph");
//		ps.setPass("pass");
//		customers.add(ps);
//		
//		toApp = new ArrayList<String[]>();
//		String[] toGo = new String[2];
//		toGo[0] = "C1234567";
//		toGo[1] = "joseph";
//		toApp.add(toGo);
//		String[] tog = new String[2];
//		tog[0] = "C9876543";
//		tog[1] = "joseph";
//		toApp.add(tog);
//
//		customers.add(them);
//		customers.add(jo);
//		employees.add(me);
//		employees.add(you);

		
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
