package com.dz.eclipsLink.pro.service;

import java.util.List;

import com.dz.eclipsLink.pro.model.Employee;

public interface EmployeeService {

	void intiliseConnection();
	Employee registerEmployee(Employee employee);
	List<Employee> loadRecentRegistEmployee();
//	Boolean terminateEmployee();
	
	
}
