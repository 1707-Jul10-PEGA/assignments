package com.as.bankingapp.commandparser;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.as.bankingapp.account.Account;
import com.as.bankingapp.admin.Admin;
import com.as.bankingapp.customer.Customer;
import com.as.bankingapp.employee.Employee;
import com.as.bankingapp.user.User;

public class CommandParser {

	//Command logging ---------------------------------------------------------------------------
	private static Logger transactionLogger = Logger.getLogger("transactionLogger");
	
	/*
	 * used to generally parse a command
	 */
	public static void parseCommand(String command, User user, List<User> l) {
		if (user instanceof Customer) {
			//call customer specific parser
			parseCustomerCommand(command, (Customer) user, l);
		} else if (user instanceof Employee) {
			//call employee specific parser
			parseEmployeeCommand(command, (Employee) user, l);
		} else if (user instanceof Admin) {
			//call admin specific parser
			parseAdminCommand(command, (Admin) user, l);
		}
	}
	
	/*
	 * Used to parse a customer command explicitly
	 */
	public static void parseCustomerCommand(String command, Customer c, List<User> l) {
		String[] arr = command.split(" ");
		if ("view".equals(arr[0])) {
			transactionLogger.info(c.getUserName() + " viewed their balance.");
			if (c.getAccount() != null) {
				Account a = c.getAccount();
				if (a.isActive()) {
					System.out.println("Your current balance is " + a.getValue());
				} else {
					System.out.println("Your account has not been approved");
				}
			} else {
				System.out.println("You do not have an account.");
			}
		} else if ("apply".equals(arr[0])) {
			//apply
			transactionLogger.info(c.getUserName() + " applied for an account.");
			if (c.getAccount() == null) {
				//find the next available id
				int nextId = 1;
				boolean changed;
				do {
					changed = false;
					//have to make at least one pass to ensure the id is unique
					for (User u: l) {
						if (u instanceof Customer) {
							Account a = ((Customer)u).getAccount();
							if (a != null) {
								if (a.getId() == nextId) {
									//if the id is updated have to make another pass to ensure it is unique
									nextId++;
									changed = true;
								}
							}
						}
					}
				} while (changed);
				
				//make the account and add it to the system
				Account newAccount = new Account(nextId, 0.0, false, c);
				c.setAccount(newAccount);
				c.setHasAccount(true);
			}
		} else if ("deposit".equals(arr[0])) {
			//deposit
			Account a = c.getAccount();
			if (a != null) {
				if (c.getAccount().isActive()) {
					c.getAccount().deposit(Double.valueOf(arr[1]));
					transactionLogger.info(c.getUserName() + " deposited " + Double.valueOf(arr[1]) + " into their account.");
				} else {
					System.out.println("You do not have an account.");
				}
			}
		} else if ("withdraw".equals(arr[0])) {
			//withdraw
			Account a = c.getAccount();
			if (a != null) {
				if (c.getAccount().isActive()) {
					c.getAccount().withdraw(Double.valueOf(arr[1]));
					transactionLogger.info(c.getUserName() + " withdrew " + Double.valueOf(arr[1]) + " from their account.");
				} else {
					System.out.println("You do not have an account.");
				}
			}
		} else if ("commands".equals(arr[0])) {
			CommandParser.printCustomerCommands();
		}
	}
	
	
	/*
	 * Used to parse a Employee command explicitly
	 */
	public static void parseEmployeeCommand(String command, Employee m, List<User> l) {
		String[] arr = command.split(" ");
		if ("approve".equals(arr[0])) {
			//approve app
			for (User u: l) {
				if (u instanceof Customer) {
					Account a = ((Customer)u).getAccount();
					if (a != null) {
						if (a.getId() == Integer.valueOf(arr[1])) {
							if (!a.isActive()) {
								m.addAccount(Integer.valueOf(arr[1]));
								a.setActive(true);
								transactionLogger.info(m.getUserName() + " has approved " + a.getOwner().getUserName() + "'s account.");
							} else {
								System.out.println("Account is already managed.");
							}
						}
					}
				}
			}
		} else if ("deny".equals(arr[0])) {
			//deny app
			Iterator<User> iter = l.iterator();
			while (iter.hasNext()) {
				User u = iter.next();
				if (u instanceof Customer) {
					Account a = ((Customer)u).getAccount();
					if (a != null) {
						if (a.getId() == Integer.valueOf(arr[1])) {
							if (a.isActive()) {
								System.out.println("Can't deny an active account.");
							} else {
								a.getOwner().setHasAccount(false);
								iter.remove();
								transactionLogger.info(m.getUserName() + " has denied " + a.getOwner().getUserName() + "'s account.");
							}
						}
					}
				}
			}
		} else if ("view".equals(arr[0])) {
			//view customer balance
			if (m.getAccountIds().contains(Integer.valueOf(arr[1]))) {
				for (User u: l) {
					if (u instanceof Customer) {
						Account a = ((Customer)u).getAccount();
						if (a != null) {
							if (a.getId() == Integer.valueOf(arr[1])) {
								System.out.println(a);
								transactionLogger.info(m.getUserName() + " is viewed " + a.getOwner().getUserName() + "'s account.");
							}
						}
					}
				}
			}
		}  else if ("commands".equals(arr[0])) {
			CommandParser.printEmployeeCommands();
		} else if ("viewp".equals(arr[0])) {
			//display pending accounts
			transactionLogger.info(m.getUserName() + " viewed all pending accounts.");
			for (User u: l) {
				if (u instanceof Customer) {
					Account a = ((Customer)u).getAccount();
					if (a != null) {
						if (!a.isActive()) {
							System.out.println(a);
						}
					}
				}
			}
		} else if ("viewmine".equals(arr[0])) {
			//display employee's currently managed accounts
			transactionLogger.info(m.getUserName() + " viewed all of their managed accounts.");
			for (User u: l) {
				if (u instanceof Customer) {
					Account a = ((Customer)u).getAccount();
					if (a != null){
						if (m.getAccountIds().contains(a.getId()) && a != null) {
							System.out.println(a);
						}
					}
				}
			}
		}
	}
	
	/*
	 * Used to parse Admin command explicitly
	 */
	public static void parseAdminCommand(String command, Admin a, List<User> l) {
		String[] arr = command.split(" ");
		if ("viewall".equals(arr[0])) {
			transactionLogger.info(a.getUserName() + " viewed all accounts.");
			Iterator<User> iter = l.iterator();
			while (iter.hasNext()) {
				User u = iter.next();
				if (u instanceof Customer) {
					if (((Customer)u).isHasAccount()) {
						System.out.println(((Customer)u).getAccount());
					}
				}
			}
		} else if ("set".equals(arr[0])) {
			Iterator<User> iter = l.iterator();
			while (iter.hasNext()) {
				User u = iter.next();
				if (u instanceof Customer) {
					if (((Customer)u).getAccount() != null) {
							if (((Customer)u).getAccount().getId() == Integer.valueOf(arr[1]) && ((Customer)u).isHasAccount()) {
								((Customer)u).getAccount().setValue(Double.valueOf(arr[2]));
								transactionLogger.info(a.getUserName() + " set " + u.getUserName() + "'s account to " + Double.valueOf(arr[2]));
							}
					}
				}
			}
		} else if ("approve".equals(arr[0])) {
			//approve app
			for (User u: l) {
				if (u instanceof Customer) {
					Account ac = ((Customer)u).getAccount();
					if (ac != null) {
						if (ac.getId() == Integer.valueOf(arr[1])) {
							if (!ac.isActive()) {
								a.addAccount(Integer.valueOf(arr[1]));
								ac.setActive(true);
								transactionLogger.info(a.getUserName() + " has approved " + ac.getOwner().getUserName() + "'s account.");
							} else {
								System.out.println("Account is already managed.");
							}
						}
					}
				}
			}
		} else if ("deny".equals(arr[0])) {
			//deny app
			Iterator<User> iter = l.iterator();
			while (iter.hasNext()) {
				User u = iter.next();
				if (u instanceof Customer) {
					Account ac = ((Customer)u).getAccount();
					if (ac != null) {
						if (ac.getId() == Integer.valueOf(arr[1])) {
							if (ac.isActive()) {
								System.out.println("Can't deny an active account.");
							} else {
								ac.getOwner().setHasAccount(false);
								iter.remove();
								transactionLogger.info(a.getUserName() + " has denied " + ac.getOwner().getUserName() + "'s account.");
							}
						}
					}
				}
			}
		} else if ("view".equals(arr[0])) {
			//view customer balance
			if (a.getAccountIds().contains(Integer.valueOf(arr[1]))) {
				for (User u: l) {
					if (u instanceof Customer) {
						Account ac = ((Customer)u).getAccount();
						if (ac != null) {
							if (ac.getId() == Integer.valueOf(arr[1])) {
								System.out.println(ac);
								transactionLogger.info(a.getUserName() + " is viewed " + ac.getOwner().getUserName() + "'s account.");
							}
						}
					}
				}
			}
		}  else if ("commands".equals(arr[0])) {
			CommandParser.printEmployeeCommands();
		} else if ("viewp".equals(arr[0])) {
			//display pending accounts
			transactionLogger.info(a.getUserName() + " viewed all pending accounts.");
			for (User u: l) {
				if (u instanceof Customer) {
					Account ac = ((Customer)u).getAccount();
					if (ac != null) {
						if (!ac.isActive()) {
							System.out.println(ac);
						}
					}
				}
			}
		} else if ("viewmine".equals(arr[0])) {
			//display employee's currently managed accounts
			transactionLogger.info(a.getUserName() + " viewed all of their managed accounts.");
			for (User u: l) {
				if (u instanceof Customer) {
					Account ac = ((Customer)u).getAccount();
					if (ac != null){
						if (a.getAccountIds().contains(ac.getId()) && ac != null) {
							System.out.println(ac);
						}
					}
				}
			}
		}
	}
	
	/*
	 * Prints out possible customer commands
	 */
	public static void printCustomerCommands() {
		System.out.println("commands: Prints this list.");
		System.out.println("view: Displays your account balance.");
		System.out.println("apply: Applies for an account if you don't already have one.");
		System.out.println("deposit [amount]: Deposits [amount] into your account.");
		System.out.println("withdraw [amount]: Withdraws [amount] if there are enough funds.");
	}
	
	/*
	 * Prints out possible employee commands
	 */
	public static void printEmployeeCommands() {
		System.out.println("commands: Prints this list.");
		System.out.println("approve [account id]: Approves the application for an account by account with [account id].");
		System.out.println("deny [account id]: Denies the application for an account by account with [account id].");
		System.out.println("view [account id]: View the balance for account with id [account id] that you manage.");
		System.out.println("viewp: View all pending accounts to approve or deny them.");
		System.out.println("viewmine: View your currently managed accounts.");
	}
	
	/*
	 * Prints out possible admin commands 
	 */
	public static void printAdminCommands() {
		System.out.println("commands: Prints this list.");
		System.out.println("approve [account id]: Approves the application for an account by account with [account id].");
		System.out.println("deny [account id]: Denies the application for an account by account with [account id].");
		System.out.println("view [account id]: View the balance for account with id [account id] that you manage.");
		System.out.println("viewp: View all pending accounts to approve or deny them.");
		System.out.println("viewmine: View your currently managed accounts.");
		System.out.println("viewall: Displays all accounts");
		System.out.println("set [id] [amt]: Sets the account with account id [id] to an amount [amt].");
	}
}
