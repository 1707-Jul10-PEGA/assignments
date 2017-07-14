package com.EC.hw1.Model;

import java.util.LinkedList;
import java.util.List;

public class Admin extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7689680374583441970L;
	private List<Employee>empList = new LinkedList<Employee>();
	
	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String userName ,Account account, List<Customer>cusList, List <Employee> emplList){
		super(firstName,lastName,userName,account,cusList);
		this.empList = emplList;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	
}
