package users;

import java.util.ArrayList;

import accounts.AccountApp;

public class Employee extends User {
	
	private ArrayList<Customer> customers;
	private ArrayList<AccountApp> pendingAcc;
	private ArrayList<NewUserApp> pendingUser;

	public Employee() {
		this.setType("E");
	}

	public Employee(String un, String pw) {
		super(un, pw);
		this.setType("E");
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
	public ArrayList<AccountApp> getPendingAcc() {
		return pendingAcc;
	}

	public void setPendingAcc(ArrayList<AccountApp> pendingAcc) {
		this.pendingAcc = pendingAcc;
	}

	public ArrayList<NewUserApp> getPendingUser() {
		return pendingUser;
	}

	public void setPendingUser(ArrayList<NewUserApp> pendingUser) {
		this.pendingUser = pendingUser;
	}

	public void approveApp(Customer r, String k) {
		boolean found = false;
		for(AccountApp aa: this.getPendingAcc()) {
			if (aa.getRequester().getUsername().equals(r.getUsername())) {
				if (aa.getKey().equals(k)) {
					aa.approve();
					found = true;
					this.pendingAcc.remove(aa);
					break;
				}
			}
		}
		if (!found) {
			System.out.println("No such accountApp");
		}
	}
	
	public void approveUser(String un, String t) {
		boolean found = false;
		for(NewUserApp nua: this.getPendingUser()) {
			if(nua.getUsername().equals(un)) {
				if(nua.getType().equals(t)) {
					nua.approve();
					found = true;
					this.pendingUser.remove(nua);
					break;
				}
			}
		}
		if(!found) {
			System.out.println("No such NewUserApp");
		}
	}
}
