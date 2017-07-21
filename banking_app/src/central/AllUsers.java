package central;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import users.Admin;
import users.Customer;
import users.Employee;
import users.User;

public class AllUsers{
	
	ArrayList<Employee> employees;
	ArrayList<Customer> customers;
	ArrayList<Admin> admins;

	public AllUsers() {
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		admins = new ArrayList<Admin>();
		//this.read();
	}

//	public void refresh() {
//		try {
//	         FileOutputStream fileOut = new FileOutputStream("PasswordDB");
//	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
//	         out.writeObject(users);
//	         out.close();
//	         fileOut.close();
//	         System.out.printf("Serialized data is saved in PasswordDB");
//	      }catch(IOException i) {
//	         i.printStackTrace();
//	      }
//	}
	
//	public void read() {
//		try {
//	         FileInputStream fileIn = new FileInputStream("PasswordDB");
//	         ObjectInputStream in = new ObjectInputStream(fileIn);
//	         this.setUsers((ArrayList<User>) in.readObject());
//	         in.close();
//	         fileIn.close();
//	      }catch(IOException i) {
//	         i.printStackTrace();
//	         return;
//	      }catch(ClassNotFoundException c) {
//	         System.out.println("Employee class not found");
//	         c.printStackTrace();
//	         return;
//	      }
//	}
	
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<Admin> admins) {
		this.admins = admins;
	}

	public void sortUsers() {
		
	}
}
