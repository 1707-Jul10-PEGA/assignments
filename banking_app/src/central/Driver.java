package central;

import java.util.Scanner;

import users.Admin;
import users.Customer;
import users.Employee;
import users.NewUserApp;
import users.User;
import central.AllUsers;

public class Driver {
	
	private Scanner scan;
	private AllUsers au;

	public Driver() {
		scan = new Scanner(System.in);
		au = new AllUsers();
	}
	
	public AllUsers getAu() {
		return au;
	}

	public void setAu(AllUsers au) {
		this.au = au;
	}

	public void cusLogin(String line, Scanner scan) {
		System.out.println("Now enter your username");
		line = scan.nextLine();
		for (Customer c: this.getAu().getCustomers()) {
			Customer curCus;
			if (c.getUsername().equals(line)){
				curCus = c;
				System.out.println("Now please enter your password");
				line = scan.nextLine();
				if(line.equals(c.getPassword())) {
					System.out.println("login successful");
				}
			}
			else {
				System.out.println("Invalid Username");
				cusLogin(line, scan);
			}
		}
	}
	
	private void empLogin(String line, Scanner scan2) {
		System.out.println("Now enter your username");
		line = scan.nextLine();
		for (Employee e: this.getAu().getEmployees()) {
			Employee curEmp;
			if (e.getUsername().equals(line)){
				curEmp = e;
				System.out.println("Now please enter your password");
				line = scan.nextLine();
				if(line.equals(e.getPassword())) {
					System.out.println("login successful");
				}
			}
			else {
				System.out.println("Invalid Username");
				cusLogin(line, scan);
			}
		}
	}

	private void adminLogin(String line, Scanner scan2) {
		System.out.println("Now enter your username");
		line = scan.nextLine();
		for (Admin a: this.getAu().getAdmins()) {
			Admin curAdm;
			if (a.getUsername().equals(line)){
				curAdm = a;
				System.out.println("Now please enter your password");
				line = scan.nextLine();
				if(line.equals(a.getPassword())) {
					System.out.println("login successful");
				}
			}
			else {
				System.out.println("Invalid Username");
				cusLogin(line, scan);
			}
		}
	}
	
	public void signup(String line, Scanner scan) {
		System.out.println("What type of account would you like to create?");
		System.out.println("1) Customer");
		System.out.println("2) Employee");
		System.out.println("3) Administrator");
		line = scan.nextLine();
		NewUserApp nua;
		String type;
		String un;
		String pw;
		if(line.equals("1")) {
			type = "C";
			System.out.println("Enter new username");
			line = scan.nextLine();
			un = line;
			System.out.println("Enter new password");
			line = scan.nextLine();
			pw = line;
			nua = new NewUserApp(un, pw, type, this.getAu());
		}
		else if(line.equals("2")) {
			type = "E";
			System.out.println("Enter new username");
			line = scan.nextLine();
			un = line;
			System.out.println("Enter new password");
			line = scan.nextLine();
			pw = line;
			nua = new NewUserApp(un, pw, type, this.getAu());
		}
		else if(line.equals("3")) {
			type = "A";
			System.out.println("Enter new username");
			line = scan.nextLine();
			un = line;
			System.out.println("Enter new password");
			line = scan.nextLine();
			pw = line;
			nua = new NewUserApp(un, pw, type, this.getAu());
		}
		else {
			System.out.println("Invalid input, try again");
			this.signup(line, scan);
		}
		System.out.println("Account application submitted, would you like to log in?");
		line = scan.nextLine();
	}

	public static void main(String[] args) {
		Driver d = new Driver();
		AllUsers au = new AllUsers();
		NewUserApp defaultEmployee = new NewUserApp("JohnDoe", "password", "E", au);
		System.out.println("Log in or sign up?");
		String line = d.scan.nextLine().toLowerCase();
		if(line.equals("log in")) {
			System.out.println("1) Login as existing customer");
			System.out.println("2) Login as existing employee");
			System.out.println("3) Login as existing admin");
			line = d.scan.nextLine();
			if(line.equals("1")) {
				d.cusLogin(line, d.scan);
			}
			else if(line.equals("2")) {
				d.empLogin(line, d.scan);
			}
			else if(line.equals("3")) {
				d.adminLogin(line, d.scan);
			}
		}
		else if(line.equals("sign up")) {
			d.signup(line, d.scan);
		}
		else {
			System.out.println("Invalid input");
			System.exit(0);
		}
	}

	
}
