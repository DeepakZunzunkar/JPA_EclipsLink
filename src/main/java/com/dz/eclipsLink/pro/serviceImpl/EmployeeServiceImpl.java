package com.dz.eclipsLink.pro.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dz.eclipsLink.jpa.repository.DzJpaRepository;
import com.dz.eclipsLink.pro.model.Employee;
import com.dz.eclipsLink.pro.service.EmployeeService;
import com.dz.eclipsLink.pro.utility.ConnectionConfig;

public class EmployeeServiceImpl implements EmployeeService {

	public void intiliseConnection() {
		EntityManager entityManager = ConnectionConfig.getEntityManager();
	}

	public Employee registerEmployee(Employee employee) {

		EntityManager entityManager = ConnectionConfig.getEntityManager();
		if (entityManager != null) {

			entityManager.getTransaction().begin();

			entityManager.persist(employee);
			entityManager.getTransaction().commit();
//				ConnectionConfig.closeConnections(entityManager);
		}

		return employee;
	}

	// in load data or get data from DB we don't need to do begin transaction and
	// close
	// when i used ConnectionConfig.closeConnections(entityManager);
	// here it close connection but when i start another transaction like register
	// employee then it throw null pointer exception
	// so now i comment all close connection call and it is working fine now .

	public List<Employee> loadRecentRegistEmployeeByNativeQuery() {

		EntityManager entityManager = ConnectionConfig.getEntityManager();
//		 entityManager.getTransaction( ).begin( );

		Query q = entityManager.createQuery("select s from Employee s");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = q.getResultList();
//		entityManager.getTransaction( ).commit( );
//		ConnectionConfig.closeConnections(entityManager);
		return employeeList;
	}

	public List<Employee> loadRecentRegistEmployee() {

		
				
		return null;
	}

}
