package com.EC.hw1.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.EC.hw1.ImplementationsAndInterfaces.AdminImpl;
import com.EC.hw1.ImplementationsAndInterfaces.CustomerImpl;
import com.EC.hw1.ImplementationsAndInterfaces.EmployeeImpl;
import com.EC.hw1.Model.User;

public class BankUtilities {

	/*
	 * //Create and update files public static void writeCustomer(Customer c){
	 * String customerFile =
	 * "Customers/"+c.getBankAccount().getUserName()+".txt";
	 * try(ObjectOutputStream oos = new ObjectOutputStream(new
	 * FileOutputStream(customerFile))){
	 * System.out.println("Attempting to write customer to file");
	 * oos.writeObject(c);
	 * System.out.println("Successfully wrote customer to file"); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * public static void writeEmployee(Employee emp){ String customerFile =
	 * "Employees/"+emp.getAccount().getUserName()+".txt";
	 * try(ObjectOutputStream oos = new ObjectOutputStream(new
	 * FileOutputStream(customerFile))){
	 * System.out.println("Attempting to write employee to file");
	 * oos.writeObject(emp);
	 * System.out.println("Successfully wrote employee to file"); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * public static void writeAdmin(Admin a){ String customerFile =
	 * "Admin/"+a.getAccount().getUserName()+".txt"; try(ObjectOutputStream oos
	 * = new ObjectOutputStream(new FileOutputStream(customerFile))){
	 * System.out.println("Attempting to write admin to file");
	 * oos.writeObject(a);
	 * System.out.println("Successfully wrote admin to file"); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * public static void updateCustomerConfig(Set<Customer> config){ String
	 * customerFile = "Customers/config.txt"; try(ObjectOutputStream oos = new
	 * ObjectOutputStream(new FileOutputStream(customerFile))){
	 * System.out.println("Attempting to write customer's configuration file");
	 * oos.writeObject(config);
	 * System.out.println("Successfully updated customer's configuration file");
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * public static void updateEmployeeConfig(Set<Employee> config){ String
	 * customerFile = "Employee/config.txt"; try(ObjectOutputStream oos = new
	 * ObjectOutputStream(new FileOutputStream(customerFile))){
	 * System.out.println("Attempting to write customer's configuration file");
	 * oos.writeObject(config);
	 * System.out.println("Successfully updated customer's configuration file");
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * public static void updateUserConfig(Set<User> config){ String usersFile =
	 * "Users/config.txt"; try(ObjectOutputStream oos = new
	 * ObjectOutputStream(new FileOutputStream(usersFile))){
	 * System.out.println("Attempting to write user's configuration file");
	 * oos.writeObject(config);
	 * System.out.println("Successfully updated user's configuration file"); }
	 * catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * //Read files public static Customer readCustomer(String username){ String
	 * customerFile = "Customers/"+username+".txt"; try(ObjectInputStream ois =
	 * new ObjectInputStream(new FileInputStream(customerFile))){ try {
	 * System.out.println("Trying to access customer account"); Customer c =
	 * (Customer) ois.readObject();
	 * System.out.println("Successfully access customer account"); return c; }
	 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 * 
	 * public static Employee readEmployee(String username){ String customerFile
	 * = "Employees/"+username+".txt"; try(ObjectInputStream ois = new
	 * ObjectInputStream(new FileInputStream(customerFile))){ try {
	 * System.out.println("Trying to access employee account"); Employee emp =
	 * (Employee) ois.readObject();
	 * System.out.println("Successfully access employee account"); return emp; }
	 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 * 
	 * public static Admin readAdmin(String username, String password){ String
	 * customerFile = "Admin/"+username+".txt"; try(ObjectInputStream ois = new
	 * ObjectInputStream(new FileInputStream(customerFile))){ try {
	 * System.out.println("Trying to access employee account"); Admin a =
	 * (Admin) ois.readObject();
	 * System.out.println("Successfully access employee account"); return a; }
	 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 */

	// Write and update user's txt file

	public static void writeUser(User u) {
		String filename = "Users/" + u.getUserName() + ".txt";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(u);
			System.out.println("Successfully wrote to text file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static User readUser(String username){
		String filename = "Users/"+username+".txt";
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			User u = (User)ois.readObject();
			return u;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// return DAO objects
	public static AdminImpl getAdminDAO() {
		return new AdminImpl();
	}

	public static CustomerImpl getCustomnerDAO() {
		return new CustomerImpl();
	}

	public static EmployeeImpl getEmployeeDAO() {
		return new EmployeeImpl();
	}
}
