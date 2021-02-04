package application;

import java.util.Scanner;

import employeeDAO.EmployeeDAO;

public class EmployeeRecordApplication {

	public void displayMessages() {
		System.out.println("These are the choices");
		System.out.println("1. Insert data in to the database");
		System.out.println("2. Display data in the database");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDAO obj=new EmployeeDAO();
		EmployeeRecordApplication obj2=new EmployeeRecordApplication();
		boolean isValid=true;
		do {
			obj2.displayMessages();
			int choice=sc.nextInt();
			try {
				obj.connect();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
			switch(choice) {
			case 1:
				obj.addEmployee();
				break;
			case 2:
				try {
					obj.displayDetails();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);;
				}
				break;
			case 3:
				isValid=false;
				break;
				default:
					System.out.println("Invalid Option, Try Again");
			}
		}
		while(isValid);

	}

}






