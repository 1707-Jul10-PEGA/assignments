package com.dv.bankingapp;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433760983565719959L;
	
	private Customer customer = null;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void viewAccount() {
		System.out.println("\n===== Account Information =====");
		System.out.println("Account type: " + this.getType());
		System.out.println("Username : " + this.getUserName());
		System.out.println("Password : " + this.getPw());
		
		if(this.getCustomer() == null) {
			System.out.println("No customer associated.");
		}
		
		else {
			System.out.println("\n===== Assigned Customer =====");
			System.out.println("Customer: " + this.getCustomer().getUserName());
			System.out.println("Password: " + this.getCustomer().getPw());
		}
		
	}
	
	/* viewApplications
	 * print all the applications
	 */
	public void viewApplications() {
		if(Driver.appRequestList.isEmpty()) {
			System.out.println("\nThere are no pending applications at this time.");
		}
		
		else {
			System.out.println(Driver.appRequestList);
		}
	}
	
	/* changeStatus
	 * set the status for the customer
	 */
	public void changeStatus(Customer customer, int status) {
		customer.setStatus(status);
	}
	
	/* updateUser
	 * updates the user's information and saves
	 */
	public void updateUser(User authUser) {
		int i = 0;

		// get correct index of the customer
		while(!(Driver.userList.get(i).getUserName().equals(authUser.getUserName()))) {
			i++;
		}
		
		// remove the old user and save
		Driver.userList.remove(i);
		Driver.serialUser.writeUserList(Driver.userList);
		
		// update the new user and save
		Driver.userList.add(authUser);
		Driver.serialUser.writeUserList(Driver.userList);
	}

	/* approveApp
	 * approve an application for a customer
	 */
	public void approveApp(User authUser) {
		int i = 0;
		int userListSize = Driver.userList.size();
		String customerName;
		Customer customer;
		
		if(this.customer != null) {
			System.out.println("\nYou can only be assigned one customer.");
		}
		
		else if (Driver.appRequestList.isEmpty()){
			System.out.println("\nThere are no applications to approve at this time.");
		}
		
		else {
	
			// assign first user in appRequestList to employee
			customerName = Driver.appRequestList.get(0).getUserName();
			System.out.println("\nApplication for " + customerName + " found!");
			System.out.println("Assigning customer to you ...");
		
			// traverse the user list and grab the customer of the same name
			while(!(customerName.equals(Driver.userList.get(i).getUserName()))) {
				i++;
			}
			
			customer = (Customer) Driver.userList.get(i);
			this.customer = customer;
			
			changeStatus(customer, 3);
			updateUser(authUser);
			
			// update employee in userList as well as the associated customer's status
			i = 0;
			while(i<userListSize) {
				if(Driver.userList.get(i).getUserName().equals(this.getUserName())) {
				
					// remove the old employee and save
					Driver.userList.remove(i);
					Driver.serialUser.writeUserList(Driver.userList);
					
					// update the employee and save
					Driver.userList.add(this);
					Driver.serialUser.writeUserList(Driver.userList);
				}
				
				i++;
			}
			
			removeApps(customerName);
		}

	}
	
	/* updateAssociatedCustomer
	 * update the associated customer for the employee
	 */
	public void updateAssociatedCustomer() {
		int i = 0;
		int userListSize = Driver.userList.size();
		String associatedCustomerName = this.getCustomer().getUserName();
		Customer associatedCustomer;
		
		while(!(associatedCustomerName.equals(Driver.userList.get(i).getUserName()))) {
			i++;
		}
		
		// update the this employee's associated customer
		associatedCustomer = (Customer) Driver.userList.get(i);
		setCustomer(associatedCustomer);
		
		// update employee in user list
		i = 0;

		while(i<userListSize) {
			if(Driver.userList.get(i).getUserName().equals(this.getUserName())) {
			
				// remove the old employee and save
				Driver.userList.remove(i);
				Driver.serialUser.writeUserList(Driver.userList);
				
				// update the employee and save
				Driver.userList.add(this);
				Driver.serialUser.writeUserList(Driver.userList);
			}
			
			i++;
		}
		
	}
	
	/* viewBalance
	 * view the balance for the associated customer
	 */
	public void viewBalance() {
		if(this.getCustomer() == null) {
			System.out.println("\nNo customer associated.");
		}
		
		else {
		
			updateAssociatedCustomer();
		
			System.out.println("\n===== Customer Balance =====");
			System.out.println("Username: " + this.customer.getUserName());
			System.out.println("Balance: " + this.customer.getBalance());
		}
	}
	
	/* removeApps
	 * remove applications for customer
	 */
	public void removeApps(String customerName) {
		int i = 0;
		int appListSize = Driver.appRequestList.size();

		while(i<appListSize) {

			if(Driver.appRequestList.get(i).getUserName().equals(customerName)) {
				Driver.appRequestList.remove(i);
				Driver.serialAppRequest.writeAppRequestList(Driver.appRequestList);

				// update app size after every remove
				appListSize = Driver.appRequestList.size();
			}
			
			i++;
		}
	
	}
	 
	 /* denyApp
	  * deny an application for a customer
	  */
	public void denyApp() {
		int i = 0;
		String customerName;
		Customer customer;
	
		if(Driver.appRequestList.isEmpty()) {
			System.out.println("\nThere are no applications to deny at this time.");
		}
		
		else {
			// assign first user in appRequestList to employee
			customerName = Driver.appRequestList.get(0).getUserName();
			System.out.println("Denying application for " + customerName + " ...");

			// traverse the user list and grab the customer of the same name
			while(!(customerName.equals(Driver.userList.get(i).getUserName()))) {
				i++;
			}
			
			customer = (Customer) Driver.userList.get(i);
			
			changeStatus(customer, 0);
			updateUser(customer);
			
			removeApps(customerName);
		}

	}
	
}
