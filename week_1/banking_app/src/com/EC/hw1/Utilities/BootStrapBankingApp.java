package com.EC.hw1.Utilities;

import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;

public class BootStrapBankingApp {

	public static void main(String[] args) {
		
		/*File [] user = new File("Users/").listFiles();
		File [] employee = new File("Employees/").listFiles();
		
		for(File file : user){
			Path pth = Paths.get(file.getPath());
			BankUtilities.deleteUser(pth);
		}
		
		for(File file : employee){
			Path pth = Paths.get(file.getPath());
			BankUtilities.deleteUser(pth);
		}
		
		
		
		
		
		BankAccount ba1 = new BankAccount();
		BankAccount ba2 = new BankAccount();
		BankAccount ba3 = new BankAccount();
		
		Customer c1 = new Customer("Elliot","Chen","ejchen","password",ba1);
		Customer c2 = new Customer("Wendell","Phipps","wpipps","password", ba2);
		Customer c3 = new Customer("Andrew","S","adrew","password",ba3);
		c1.setActive(true);
		c2.setActive(true);
		c2.setActive(true);
		
		Account a1 = new Account("employee1@gmail.com");
		Account a2 = new Account("admin1@gmail.com");
		Account a3 = new Account("employee2@gmail.com");
		
		Employee e1 = new Employee("Nick","Jurzych","nicj","password",a1,new LinkedList<Customer>());
		Employee e2 = new Employee("Blake","G","blazing","password",a3,new LinkedList<Customer>());
		
		Admin ad1 = new Admin("Rovy","Tech", "rtech", "password", a2);
		
		BankUtilities.writeEmployee(e1);
		BankUtilities.writeUser(e1);
		BankUtilities.writeUser(c1);
		BankUtilities.writeUser(ad1);
		BankUtilities.writeEmployee(e2);
		BankUtilities.writeUser(e2);
		BankUtilities.writeUser(c2);
		BankUtilities.writeUser(c3);*/
		
		Employee e1 = (Employee) BankUtilities.readUser("blazing");
		Customer c1 = (Customer) BankUtilities.readUser("ejchen");
		Customer c2 = e1.getCustList().get(0);
		
//		System.out.println(e1.getCustList().get(0));
//		System.out.println(c1.toString());
		System.out.println(c1.equals(c2));
		
		
	}
	

}
