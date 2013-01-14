package com.georgeconsulting.expense;

import java.sql.*;

import java.util.Scanner;

public class Employee {
	//Employee information fields
	int empID;
	String firstName;	
	String lastName;
	int supervisorID;
	String email;
	
	//SQL select statement
	String queryStmt = "SELECT * FROM Employee WHERE empID = ";
	
	//Constructor
	public Employee(int numID, DBConnect conn) throws SQLException {
		//Pulls desired data from SQL database
		FetchQuery getEmp = new FetchQuery(conn.conn, queryStmt+numID);
		
		//Sets class fields and prints to screen
		while(getEmp.rs.next()) {
			empID = getEmp.rs.getInt("empID");
			firstName = getEmp.rs.getString("firstNAme");
			lastName = getEmp.rs.getString("lastName");
			supervisorID = getEmp.rs.getInt("supervisorID");
			email = getEmp.rs.getString("email");
			
			System.out.println("Employee: " + firstName + " " + lastName);
			System.out.println("ID Number: " + empID);
			System.out.println("Supervisor's ID: " + supervisorID);
			System.out.println("Email: " + email);
		}
	}
	

	public static void main(String args[]) {
		
	}
}
