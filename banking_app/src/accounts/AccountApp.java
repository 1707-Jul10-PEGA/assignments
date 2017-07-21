package accounts;

import java.util.ArrayList;
import central.AllAccounts;
import central.AllUsers;
import users.Customer;
import users.Employee;

public class AccountApp {
	
	private boolean approval;
	private String key;
	private Customer requester;
	private AllUsers au;

	public AccountApp(AllUsers au) {
		approval = false;
		this.au = au;
	}
	
	public AccountApp(Customer r, String k) {
		this.key = k;
		this.setRequester(r);
		ArrayList<Employee> ae = this.au.getEmployees();
		Employee minEmp = null;
		for (Employee e: ae) {
			if(minEmp == null) {
				minEmp = e;
			}
			else if(minEmp.getCustomers().size() > e.getCustomers().size()) {
				minEmp = e;
			}
			else {
				continue;
			}
		}
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public Customer getRequester() {
		return requester;
	}

	public void setRequester(Customer requester) {
		this.requester = requester;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void approve() {
		approval = true;
		ArrayList<Account> ala = requester.getAccounts();
		ala.add(new Account(this.getRequester(), this.key));
		requester.setAccounts(ala);
		ArrayList<Account> all = AllAccounts.getAlla();
		all.add(ala.get(ala.size() - 1));
		AllAccounts.setAlla(all);
	}
}
