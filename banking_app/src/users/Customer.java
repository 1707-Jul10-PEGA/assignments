package users;

import java.util.ArrayList;
import accounts.Account;
import accounts.AccountApp;

public class Customer extends User {
	
	private Employee emp;
	private ArrayList<Account> accounts;

	public Customer() {
		super();
		this.setType("C");
	}

	public Customer(String un, String pw) {
		super(un, pw);
		this.setType("C");
	}
	
	public Customer(String un, String pw, Employee e) {
		super(un, pw);
		this.setEmp(e);
		this.setType("C");
	}
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void withdraw(Account a, double out) {
		double current = a.getBalance();
		current -= out;
		a.setBalance(current);
	}
	
	public void deposit(Account a, double in) {
		double current = a.getBalance();
		current += in;
		a.setBalance(current);
	}
	
	public void requestAccount(String k) {
		AccountApp aa = new AccountApp(this, k);
		ArrayList<AccountApp> alaa = emp.getPendingAcc();
		alaa.add(aa);
		emp.setPendingAcc(alaa);
	}
}
