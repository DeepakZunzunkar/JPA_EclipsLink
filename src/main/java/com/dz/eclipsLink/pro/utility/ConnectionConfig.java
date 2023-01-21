package com.dz.eclipsLink.pro.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionConfig {

	private static EntityManagerFactory emfactory;
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager(){
		
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("employeeCurd");
		if(entityManager==null) {
	        entityManager = emfactory.createEntityManager();
		}				
		return entityManager;
	}
	
	public static void closeConnections(EntityManager entityManager) {
		
		entityManager.close();
		if(emfactory!= null) {
			emfactory.close();
		}
	      
		
	}
}
