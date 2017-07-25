package com.EC.hw1.driver;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.EC.hw1.Model.Admin;
import com.EC.hw1.Model.Customer;
import com.EC.hw1.Model.Employee;
import com.EC.hw1.Model.User;
import com.EC.hw1.Utilities.DAOUtilities;
import com.EC.hw2.DAO.AdminDAO;
import com.EC.hw2.DAO.CustomerDAO;
import com.EC.hw2.DAO.EmployeeDAO;
import com.EC.hw2.DAO.UserDAO;

public class Driver {

	// private Set<Employee> empList = new HashSet<Employee>();
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = Logger.getRootLogger();
	public static void main(String[] args) {

		startApp();

	}

	private static void startApp() {

		boolean valid = true;

		while (valid) {
			printWelcome();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 3) {
					// switch case
					switch (tmp) {
					case 1:
						login();
						break;
					case 2:
						createAccount();
						break;
					case 3:
						scan.close();
						System.out.println("Good-bye!");
						valid = false;
					}
				} 
			} else {
				// clear invalid input
				scan.next();
			}

		}
	}

	private static void createAccount() {
		UserDAO dao = DAOUtilities.getUserDAO();
		System.out.println("Please enter the following information to make an account");
		System.out.println("First name:");
		String firstName = scan.next();
		System.out.println("Last name: ");
		String lastName = scan.next();
		String username = null;
		for (boolean valid = true; valid;) {
			System.out.println("username: ");
			username = scan.next();
			if (dao.usernameExist(username)) {
				System.out.println("This username already exist. Please choose another one");
			} else {
				valid = false;
			}
		}
		System.out.println("password: ");
		String password = scan.next();
		
		
		User u = new User(firstName,lastName,username,password);
		u.setPriveledge(1);
		
		if (dao.applyForAccount(u)) {//if successful, assign a banker
			if(dao.assignBanker(u.getUser_id())){
				System.out.println("A banker is looking at your application now. Please wait for us to contact you.\nThanks!");
			}else{
				System.out.println("Please contact customer service. We were unable to assign you a banker");
				log.trace("A customer was created, but a employee was not assigned to that customer");
			}
			
			
		} else {
			System.out.println("Was unable to proccess you application. Please try again!");
			log.trace("Unable to submit application");
		}

	}

	private static void login() {

		boolean valid = true;

		while (valid) {
			printLogin();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 3) {
					// swtich case
					switch (tmp) {
					case 1:
						customerLogic();
						valid = false;
						break;
					case 2:
						employeeLogic();
						valid = false;
						break;
					case 3:
						adminLogic();
						valid = false;
						break;
					case 4:
						valid = false;
						break;
					}
				}
			} else {
				// clear invalid input
				scan.next();
			}
		}

	}

	private static void adminLogic() {
		AdminDAO dao = DAOUtilities.getAdminDAO();//connect to DB
		boolean valid = true;
		System.out.println("Please enter your user name");
		String username = scan.next();
		Admin admin = dao.getAdmin(username);
		
		if(admin == null){
			System.out.println("Could not find user");
			return;
		}
		
		if(!verifyPassword(admin)){
			System.out.println("Incorrect password!");
			return;
		}
		
		if(admin.getPriveledge()!=3){
			System.out.println("You are not a Admin");
			return;
		}
		
		System.out.println("Last Login: " + admin.getAccount().getLastLogin());
		log.trace("LOGINED: \n" + admin.toString());
		admin.getAccount().setLastLogin();
		
		while (valid) {
			printAdminOptions();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 4) {
					// switch case
					switch (tmp) {
					case 1:
						admin.viewAllAccounts();
						break;
					case 2:
						admin.editAccount();
						break;
					case 3:
						valid = false;
						break;
					}
				}
			} else {
				//printAdminOptions();
				// clear invalid input
				scan.next();
			}

		}

	}

	private static void employeeLogic() {
		EmployeeDAO dao = DAOUtilities.getEmployeeDAO();//connect to DB
		boolean valid = true;
		System.out.println("Please enter your user name");
		String username = scan.next();
		Employee e = dao.getEmployee(username);
		
		if(e == null){
			System.out.println("Could not find user");
			return;
		}
		
		if(!verifyPassword(e)){
			System.out.println("Incorrect password!");
			return;
		}
		
		if(e.getPriveledge()!=2){
			System.out.println("You are not a employee");
			return;
		}
		dao.getAllCustomer(e);	
		System.out.println("Last Login: " + e.getAccount().getLastLogin());
		log.trace("LOGINED:\n" + e.toString());

		while (valid) {
			printEmployeeOptions();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 4) {
					// switch case
					switch (tmp) {
					case 1:
						e.checkApplications();
						break;
					case 2:
						System.out.println("Customer's username:");
						String cusUserName = scan.next();
						e.viewCustomerAsset(cusUserName);
						break;
					case 3:
						e.viewCustomerList();
						break;
					case 4:
						valid = false;
						break;
					}
				} 
			} else {
				// clear invalid input
				scan.next();
			}

		}

	}

	private static void customerLogic() {
		CustomerDAO dao = DAOUtilities.getCustomerDAO();//connect to DB
		boolean valid = true;
		System.out.println("Please enter your user name");
		String username = scan.next();
		Customer c = dao.getCustomer(username);
		
		if(c == null){
			System.out.println("Could not find user");
			return;
		}
		
		if(!verifyPassword(c)){
			System.out.println("Incorrect password!");
			return;
		}
		
		if(c.getPriveledge()!=1){
			System.out.println("You are not a customer");
			return;
		}
		
		if(!c.getBankAccount().isActive()){
			System.out.println("Your account has not been activated");
		}
		
		System.out.println("Last Login: " + c.getBankAccount().getLastLogin());
		log.trace("LOGINED:\n" + c.toString());
		c.getBankAccount().setLastLogin();
		
		while (valid) {
			printCustomerOptions();
			if (scan.hasNextInt()) {
				int tmp = scan.nextInt();
				if (tmp >= 1 && tmp <= 4) {
					// switch case
					switch (tmp) {
					case 1:
						System.out.println("Enter Amount $XXXX");
						if (scan.hasNextDouble()) {
							double money = scan.nextDouble();
							c.deposit(money);
							
						}
						break;
					case 2:
						System.out.println("Enter Amount $XXXX");
						if (scan.hasNextDouble()) {
							double money = scan.nextDouble();
							c.withdraw(money);
							
						}
						break;
					case 3:
						c.viewBalance();
						break;
					case 4:
						valid = false;
						break;
					}
				} 
			} else {
				// clear invalid input
				scan.next();
			}

		}
	}

	private static void printLogin() {
		System.out.println("Please pick a number between 1-4 to continue");
		System.out.println("(1)Customer");
		System.out.println("(2)Employee");
		System.out.println("(3)Admin");
		System.out.println("(4)Back");
	}

	private static void printWelcome() {
		System.out.println("Please pick a number between 1-3 to continue");
		System.out.println("(1)Login");
		System.out.println("(2)New Customer");
		System.out.println("(3)Close App");
	}

	private static void printAdminOptions() {
		System.out.println("Please enter a number between 1-3 to continue");
		System.out.println("(1)View All Accounts");
		System.out.println("(2)Edit an account");
		System.out.println("(3)Logout");
	}

	private static void printCustomerOptions() {
		System.out.println("Please pick a number between 1-4");
		System.out.println("(1)Deposit Money");
		System.out.println("(2)Withdraw Money");
		System.out.println("(3)View Bank Account");
		System.out.println("(4)Logout");

	}

	private static void printEmployeeOptions() {
		System.out.println("Please enter a number between 1-4 to continue");
		System.out.println("(1)Check Applications");
		System.out.println("(2)View a Customer's Asset");
		System.out.println("(3)Look at list of clients");
		System.out.println("(4)Logout");
	}

	private static boolean verifyPassword(User u) {
		
		System.out.println("Please enter your user password");
		String password = scan.next();
		if (u == null) {
			return false;
		}
		if (u.getPassword().equals(password)) {
			return true;
		} else {
			log.trace("objects password:" +  u.getPassword());
			log.trace("scanner value: " + password);
			System.out.println("Incorrect password!");
			return false;
		}

	}

}
