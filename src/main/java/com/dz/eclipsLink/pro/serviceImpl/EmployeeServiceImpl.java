package com.dz.eclipsLink.pro.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.dz.eclipsLink.pro.model.Employee;
import com.dz.eclipsLink.pro.service.EmployeeService;
import com.dz.eclipsLink.pro.utility.ConnectionConfig;

public class EmployeeServiceImpl implements EmployeeService{

	public void intiliseConnection() {
		EntityManager entityManager= ConnectionConfig.getEntityManager();
	}
	
	
	
	public Employee registerEmployee(Employee employee) {
		
		EntityManager entityManager= ConnectionConfig.getEntityManager();
		
		  entityManager.getTransaction( ).begin( );

	      entityManager.persist(employee);
	      entityManager.getTransaction( ).commit( );

	      ConnectionConfig.closeConnections(entityManager);
	      
		return employee;
	}



	public List<Employee> loadRecentRegistEmployee() {
		
		return null;
	}


	

}
