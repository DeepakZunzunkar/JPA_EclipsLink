package com.dz.eclipsLink.pro;

import java.sql.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.dz.eclipsLink.pro.model.BaseProperties;
import com.dz.eclipsLink.pro.model.Employee;
import com.dz.eclipsLink.pro.service.EmployeeService;
import com.dz.eclipsLink.pro.serviceImpl.EmployeeServiceImpl;
import com.dz.eclipsLink.pro.utility.DateUtils;
import com.dz.eclipsLink.pro.utility.Constant.EmployeeStatus;
import com.dz.eclipsLink.pro.utility.Constant.Gender;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc =new Scanner(System.in);
    	String status;
    	EmployeeService eservice;

    	System.out.println("\n*********************************\n");
		loader();
		do
		{
			// display active , inactive and terminated count and recent register list of employee with pagination
			// button to register employee
			// button to exit and terminate the employee
			
			eservice = new EmployeeServiceImpl();
			intiateLandingPage();
			
			Employee empTrn= registerEmployeeForm(sc);
			loader();
			System.out.println("\n\tbefore persist "+empTrn+"\n");
			empTrn = eservice.registerEmployee(empTrn);
			System.out.println("\n\tafter persist "+empTrn);
			System.out.println("\n\n\tDo u want to continue other operation (yes[y] / no[n] ) ? : ");
			status=sc.next();	
		
		
		}while(status.equalsIgnoreCase("yes") || status.equalsIgnoreCase("y"));
    }

	private static Employee registerEmployeeForm(Scanner sc) {
		
		Employee trn =new Employee();
		
		System.out.println("First Name________:\n");
		trn.setFirstName(sc.next());
		
		System.out.println("Last Name_________:\n");
		trn.setLastName(sc.next());
		
		System.out.println("Gender \n 1.Male\n 2.Female : ");
		int gChoice =sc.nextInt();
		switch (gChoice)
		{
			case 1:	
					trn.setGender(Gender.MALE.getGenderValue());
					break;
			case 2: 
					trn.setGender(Gender.FEMALE.getGenderValue());
					break;
			default:
					trn.setGender("NA");
					break;
		}	
		
		trn.setStatus(EmployeeStatus.ACTIVE.getEmployeeStatusCode());
		trn.setBaseProperties(new BaseProperties("A",DateUtils.getCurrentZoneDateTime("Asia/Kolkata").toString(),"admin",null,null));
		

		System.out.println("Date Of Birth [ yyyy-mm-dd ] _________:\n");
		String dateStr = sc.next();
		trn.setBirthDate(DateUtils.convertStringToJUtilDateTime(dateStr));
		
		return trn;
	}
	
	public static void loader(){
		System.out.print("Loading ");
		for(int i=0;i<=20;i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("#");
		}
		System.out.println("\n");
	}
	private static void intiateLandingPage() {
		
		
	}
}
