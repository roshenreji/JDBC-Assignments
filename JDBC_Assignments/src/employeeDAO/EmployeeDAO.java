package employeeDAO;

import java.sql.*;

import java.util.Scanner;

import entityClass.EmployeeDetails;

public class EmployeeDAO {

	Connection con = null;
	Scanner sc = new Scanner(System.in);

	public void connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase", "root", "Helloworld1234");
	}

	public void addEmployee() {
		System.out.println("Enter Id of the Employee");
		int id = sc.nextInt();
		System.out.println("Enter Name of the Employee");
		try {
			String name = sc.next();
			System.out.println("Enter Designation");
			String designation = sc.next();
			System.out.println("Enter department");
			String department = sc.next();
			System.out.println("Enter Salary");
			double salary = sc.nextDouble();

			/*obj = new EmployeeDetails();
			obj.setId(id);
			obj.setName(name);
			obj.setDepartment(department);
			obj.setDesignation(designation);
			obj.setSalary(salary);*/

			String query = "Insert into employee values(?,?,?,?,?)";
			PreparedStatement pr = con.prepareStatement(query);
			pr.setInt(1, id);
			pr.setString(2, name);
			pr.setString(3, department);
			pr.setString(4, designation);
			pr.setDouble(5, salary);

			int count = pr.executeUpdate();
		} catch (Exception e) {
			System.out.println("You should be entering only a word");
		}

	}

	public void displayDetails() throws Exception {
		String query = "Select id,name,department,designation,salary from employee";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		System.out.println("ID \t Name \t Department \t Designation \t Salary");
		System.out.println("===============================================================================");
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String department=rs.getString(3);
			String designation=rs.getString(4);
			double salary=rs.getDouble(5);
			
			System.out.println(id+" \t "+name+" \t "+department+" \t "+designation+" \t "+salary);
		}
		

	}

}
