package users;

import java.util.ArrayList;

import central.AllUsers;

public class NewUserApp {
	
	private String username;
	private String password;
	private String type;
	private AllUsers au;

	public NewUserApp(AllUsers au) {
		this.approve();
		this.au = au;
	}
	
	public NewUserApp(String un, String pw, String t, AllUsers au) {
		this.setUsername(un);
		this.setPassword(pw);
		this.setType(t);
		this.au = au;
		this.approve();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void approve() {
		switch(this.getType()){
		
		case "Customer": Customer cus = new Customer(this.getUsername(), this.getPassword());
		ArrayList<Customer> allCus = au.getCustomers();
		Employee minEmp = null;
		for(Employee e: au.getEmployees()) {
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
		cus.setEmp(minEmp);
		allCus.add(cus);
		au.setCustomers(allCus);
		
		case "Employee": Employee emp = new Employee();
		ArrayList<Employee> allEmp = au.getEmployees();
		allEmp.add(emp);
		au.setEmployees(allEmp);
		
		case "Admin": Admin adm = new Admin();
		ArrayList<Admin> allAdm = au.getAdmins();
		allAdm.add(adm);
		au.setAdmins(allAdm);
		}
	}
}
