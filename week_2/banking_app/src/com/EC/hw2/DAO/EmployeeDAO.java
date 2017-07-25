package com.EC.hw2.DAO;

import com.EC.hw1.Model.Employee;

public interface EmployeeDAO {
	public void getAllCustomer(Employee e);
	public Employee getEmployee(String username);
	public boolean aproveApplication(int u_id);
	public boolean denyApplication(int u_id);
}
