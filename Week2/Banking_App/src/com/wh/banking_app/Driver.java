package com.wh.banking_app;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Driver {

    private static Logger Log = Logger.getRootLogger();
    private static User user;
    private static boolean run = true;

    public static void main(String[] args) throws Exception {
	try {
	    Log.info("Program started.");
	    /*if (!ListManager.load()) {
		ListManager.save();
	    }*/
	    Scanner scan = new Scanner(System.in);
	    while (run) {
		firstChoice(scan);
		Log.info("Exited first choice and setup user.");
		if (user != null) {
		    System.out.println("Hello " + user.getName() + "!");
		    userActions(scan);
		}
		user = null;
	    }
	    scan.close();
	} finally {
	    //ListManager.save();
	    ConnectionFactory.getInstance().getConnection().close();
	}
    }

    private static void firstChoice(Scanner scan) throws SQLException {
	boolean running = true;
	Log.info("Entering first choice while loop.");
	System.out.println("Hello!, are you a new user(NEW) or an existing user(EXISTING)");
	while (running) {
	    String str = "";
	    str = userInputString(scan);
	    switch (str) {
	    case "N":
	    case "NE":
	    case "NEW":
		System.out.println("Hello new user.");
		newUser(scan);
		if (user != null) {
		    running = false;
		}
		break;
	    case "E":
	    case "EX":
	    case "EXI":
	    case "EXIS":
	    case "EXIST":
	    case "EXISTI":
	    case "EXISTIN":
	    case "EXISTING":
		System.out.println("Hello existing user");
		existingUser(scan);
		if (user != null) {
		    running = false;
		}
		break;
	    case "Q":
	    case "QU":
	    case "QUI":
	    case "QUIT":
		System.out.println("Good Bye!");
		run = false;
		running = false;
		break;
	    default:
		System.out.println("Invalid command. Try NEW(N) or EXISTING(E)");
		break;
	    }
	}
    }

    private static void newUser(Scanner scan) throws SQLException {
	boolean running = true;
	while (running) {
	    String name = "";
	    String type = "";
	    Integer id = 0;
	    System.out.println("Input name.");
	    name = userInputString(scan);

	    System.out.println("Input #ID.");
	    id = userInputInteger(scan);
	    boolean running2 = true;
	    while (running2) {
		System.out.println("Input user type.(CUSTOMER(C), EMPLOYEE(E), ADMIN(A)");
		type = userInputString(scan);
		switch (type) {
		case "C":
		case "CUSTOMER":
		    if ((user = UserFactory.createCustomer(name, id)) != null) {
			running = false;
			running2 = false;
			break;
		    }
		    System.out.println("Name taken. Try again.");
		    running2 = false;
		    break;
		case "E":
		case "EMPLOYEE":
		    if ((user = UserFactory.createEmployee(name, id)) != null) {
			running = false;
			running2 = false;
			break;
		    }
		    System.out.println("Name taken. Try again.");
		    running2 = false;
		    break;
		case "A":
		case "ADMIN":
		    if ((user = UserFactory.createAdmin(name, id)) != null) {
			running = false;
			running2 = false;
			break;
		    }
		    System.out.println("Name taken. Try again.");
		    running2 = false;
		    break;
		default:
		    System.out.println("Try again.");
		}
	    }
	}

    }

    private static void existingUser(Scanner scan) throws SQLException{
	boolean running = true;
	while (running) {
	    String name = "";
	    Integer id = 0;
	    System.out.println("Input name. (QUIT) to exit to main.");
	    name = userInputString(scan);
	    if ("QUIT".equalsIgnoreCase(name) || "QUI".equalsIgnoreCase(name) || "Q".equalsIgnoreCase(name)) {
		System.out.println("Hello!, are you a new user(NEW) or an existing user(EXISTING)");
		break;
	    }

	    System.out.println("Input #ID.");
	    id = userInputInteger(scan);

	    if (DaoManager.getUserDao().getUser(name, id) != null) {
		user = DaoManager.getUserDao().getUser(name, id);
		if(user.getClass() == Customer.class) {
		    Account acc = DaoManager.getAccountDao().getAccount(((Customer)user));
		    ((Customer)user).setCheckingAccount(acc);;
		} else if (user.getClass() == Employee.class){
		    
		}
		running = false;
	    } else {
		System.out.println("Failed to find user. Try again.");
	    }
	}
    }

    private static void userActions(Scanner scan) throws SQLException {
	Log.info("Entered userChoices.");
	if (user.getClass() == Customer.class) {
	    customerActions(scan);
	} else if (user.getClass() == Employee.class) {
	    employeeActions(scan);
	} else if (user.getClass() == Admin.class) {
	    adminActions(scan);
	} else {
	    Log.error("User made without being assigned a type.");
	    System.out.println("Not a valid user. Restarting from main.");
	}
    }

    private static void customerActions(Scanner scan) {
	user = (Customer) user;
	boolean running = true;
	while (running) {
	    String str = "";
	    Integer i = 0;
	    if ("NO APPLICATION".equalsIgnoreCase(((Customer) user).applicationStatus())) {
		System.out.println("No application. Would you like to apply? (Y/N)");
		str = userInputString(scan);
		switch (str) {
		case "Y":
		case "YES":
		    ((Customer) user).apply();
		    System.out.println("Thank you for applying. Please contact the nearest employee.");
		    running = false;
		    break;
		case "N":
		case "NO":
		    System.out.println("Thank you for stopping by!");
		    running = false;
		    break;
		default:
		    System.out.println("Invalid command. Try again.");
		}
	    } else if ("PENDING".equalsIgnoreCase(((Customer) user).applicationStatus())) {
		System.out.println("Welcome! Your application is still pending. Please talk to an employee.");
		running = false;
	    } else if ("DENIED".equalsIgnoreCase(((Customer) user).applicationStatus())) {
		System.out.println("Sorry! Your application has been denied.");
		running = false;
	    } else if ("APPROVED".equalsIgnoreCase(((Customer) user).applicationStatus())) {
		System.out.println("What would you like to do? VIEWBALANCE(V),WITHDRAW(W),DEPOSIT(D),QUIT(Q)");
		str = userInputString(scan);
		switch (str) {
		case "V":
		case "VIEWBALANCE":
		    System.out.println(((Customer) user).viewBalance());
		    break;
		case "W":
		case "WITHDRAW":
		    System.out.println("$" + ((Customer) user).viewBalance() + " availiabe.");
		    System.out.println("How much would you like to withdraw?");
		    i = userInputInteger(scan);
		    double amount = ((Customer) user).withdraw(i);
		    if (amount == -1) {
			System.out.println("Withdrawing failed. Not enough cash in account.");
		    } else {
			System.out.println("Withdrawing successful. Withdrew: $" + amount);
		    }
		    break;
		case "D":
		case "DEPOSIT":
		    System.out.println("$" + ((Customer) user).viewBalance() + " availiabe.");
		    System.out.println("How much would you like to deposit?");
		    i = userInputInteger(scan);
		    if (((Customer) user).deposit(i)) {
			System.out.println("Depositing successful. balance: $" + i);
		    } else {
			System.out.println("Depositing failed. balance: $" + i);
		    }
		    break;
		case "Q":
		case "QUIT":
		    System.out.println("Thank you for stopping by!");
		    running = false;
		    break;
		default:
		    System.out.println("Invalid command. Try again.");
		}
	    }
	}
    }

    private static void employeeActions(Scanner scan) throws SQLException {
	boolean running = true;
	while (running) {
	    String str = "";
	    System.out.println("What would you like to do? NEXTAPPLICATION(A), VIEWCUSTOMERBALANCE(V),QUIT(Q)");
	    str = userInputString(scan);
	    switch (str) {
	    case "A":
	    case "NEXTAPPLICATION":
		CheckingAccount acc = (CheckingAccount)DaoManager.getAccountDao().getPendingAccount();
		Customer cust = (Customer)DaoManager.getUserDao().getUser(acc.getUserID());
		acc.setCustomer(cust);
		// Customer customer =
		// ListManager.getCustomer(application.getCustomer().getName());
		// application = customer.getApplication();
		Log.info(acc);
		if (acc != null) {
		    System.out.println(acc.getCustomer().toString());
		    boolean running2 = true;
		    while (running2) {
			System.out.println("APPROVE(A) or DENY(D)?");
			str = userInputString(scan);
			switch (str) {
			case "A":
			case "APPROVE":
			    System.out.println("Application approved for " + acc.getCustomer().getName());
			    ((Employee) user).approve(acc);
			    running2 = false;
			    break;
			case "D":
			case "DENY":
			    System.out.println("Application denied for " + acc.getCustomer().getName());
			    ((Employee) user).deny(acc);
			    running2 = false;
			    break;
			default:
			    System.out.println("Invalid command.");
			}
		    }
		    break;
		} else {
		    System.out.println("No applications in waiting.");
		}
		break;
	    case "V":
	    case "VIEWCUSTOMERBALANCE":
		if (ListManager.getCustomerList().isEmpty()) {
		    System.out.println("No customers :(");
		} else {
		    System.out.println("List of users:" + ListManager.getCustomerList().toString());
		    boolean running2 = true;
		    while (running2) {
			System.out.println("Who's account would you like to see?");
			str = userInputString(scan);
			Customer c1 = ListManager.getCustomer(str);
			if (c1 != null) {
			    System.out.println(c1.toString());
			    running2 = false;
			} else {
			    System.out.println("Customer not found!");
			}
		    }
		}
		break;
	    case "Q":
	    case "QUIT":
		System.out.println("Thank you for stopping by!");
		running = false;
		break;
	    default:
		System.out.println("Invalid command. Try again.");
	    }
	}

    }

    private static void adminActions(Scanner scan) {
	boolean running = true;
	while (running) {
	    String str = "";
	    System.out.println("What would you like to do? EDIT(E), VIEWALL(V), QUIT(Q)");
	    str = userInputString(scan);
	    switch (str) {
	    case "E":
	    case "EDIT":
	    case "V":
	    case "VIEWALL": ListManager.getUserList();
	    case "Q":
	    case "QUIT":
		System.out.println("Logout(L) or Exit(E) program? Anything else goes back to admin inputs.");
		str = userInputString(scan);
		switch (str) {
		case "L":
		case "LOGOUT":
		    running = false;
		    break;
		case "E":
		case "EXIT":
		    run = false;
		    running = false;
		    break;
		default:
		}
		break;
	    default:
		System.out.println("Invalid command. Try again.");
	    }
	}

    }

    private static Integer userInputInteger(Scanner scan) {
	Log.info("Entered userInputInteger Method");
	Integer i = 0;
	while (i.equals(0)) {
	    // Log.info("Inside userInputIntger while loop");
	    if (scan.hasNextInt()) {
		i = scan.nextInt();
	    } else {
		scan.next();
	    }
	}
	return i;
    }

    private static String userInputString(Scanner scan) {
	Log.info("Entered userInputString Method");
	String str = "";
	while (str.isEmpty()) {
	    // Log.info("Inside userInputString while loop");
	    str = scan.nextLine();
	}
	return str.toUpperCase();
    }
}
