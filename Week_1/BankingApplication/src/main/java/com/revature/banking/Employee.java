package com.revature.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends User{

	private ArrayList<Integer> customerList = new ArrayList<Integer>();
	public Employee(String firstName, String lastName, int age, String phone, String address, String username,
			String password, ArrayList<Integer> customerList) {
		super(firstName, lastName, age, phone, address, username, password, "employee");
		this.customerList = customerList;
	}
	public void viewCustomerAccount(int index) {
		if(checkIfCustomer(index)) {
			Customer current = (Customer)Main.getCustomerBA().get(index);
			for(int i: current.getAcctIndex()) {
				System.out.println(Main.getBankAcc().get(i));
			}
			
		}
		else {
			System.out.println("Invalid: You have no access to this customer information");
		}
	}
	
	public boolean checkIfCustomer(int index) {
		for(Integer i: customerList) {
			if(index == i) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove the application from the application ArrayList at index
	 * @param index index of the application in the application arrayList in Main
	 */
	public void approveApplication(int index) {
		Application app = Main.application.get(index);
		Scanner input = new Scanner(System.in);
		System.out.println("Please input name of account:");
		String name = input.nextLine();
		String type = app.getType();
		Double savingInterest = 0.0;
		if("saving".equals(type)) {
			System.out.println("Please input interest in double:");
			savingInterest = Double.parseDouble(input.nextLine());
		}
		new BankAccountFactory().createBankAccount(name, type, app.getAmount(), savingInterest);
		int customerIndex = ((Customer)app.getUser()).getCustomerIndex();
		Customer currentCustomer = ((Customer)app.getUser());
		ArrayList<Integer> newAccList = currentCustomer.getAcctIndex();
		newAccList.add(Main.bankAcc.size()-1);
		currentCustomer.setAcctIndex(newAccList);
		Main.customerBA.set(customerIndex, currentCustomer);
		Main.application.remove(index);
		
	}
	
	public void denyApplication(int index) {
		Main.application.remove(index);
	}
	public ArrayList<Integer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Integer> customerList) {
		this.customerList = customerList;
	}
	
	
}
